import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import piece.*;

public class LoadManager {

	public LoadManager(SelectGame window) {
		try {
			load();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(
					null, 
					"Error: Save File not found", 
					"Error", 
					JOptionPane.ERROR_MESSAGE
					);
		}
	}
	
	private void load() throws FileNotFoundException {
		Scanner in = new Scanner(new File("SaveGame.txt"));
		
		GameController controller;
		String gameTypeString = gameType(in);
		GamePiece[][] board = gameBoard(in, gameTypeString);
		Player player1 = player(in);
		Player player2 = player(in);
		Color current = current(in);
		int time = timer(in);
		
		if (gameTypeString.equals("Othello")) {
			controller = new GameController(GameController.GameType.OTHELLO, player1, player2);
		} else {
			controller = new GameController(GameController.GameType.CONNECTFOUR, player1, player2);
		}
		
		if (player1.isAI()) {
			player1.SetBoard(controller.GetBoard());
		}
		if (player2.isAI()) {
			player2.SetBoard(controller.GetBoard());
		}
		
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if(board[x][y] == null) {
					
				} else {
					controller.GetBoard().SetPiece(x, y, board[x][y]);
				}
			}
		}
		if(player1.GetPieceColour() == current) {
			controller.setCurrentPlayer(player1);
		} else if (player2.GetPieceColour() == current) {
			controller.setCurrentPlayer(player2);
		} else {
			brokenFileMsg();
		}
		
		controller.GetGUI().setClock(new Clock(controller.GetGUI(), time));
	}
	
	private void brokenFileMsg() {
		JOptionPane.showMessageDialog(null,
				"Error: Save File Corrupted",
				"Error",
				JOptionPane.ERROR_MESSAGE
				);
	}
	
	private String gameType(Scanner in) {
		String gameTypeString = in.nextLine();
		if (!gameTypeString.equals("Othello") 
				&& !gameTypeString.equals("Connect 4")) {
			brokenFileMsg();
		}
		return gameTypeString;
	}
	
	private GamePiece[][] gameBoard(Scanner in, String gameTypeString) {
		final int OTHELLOHEIGHT = 8;
		final int OTHELLOWIDTH = 8;
		final int CONNECT4HEIGHT = 7;
		final int CONNECT4WIDTH = 10;
		
		GamePiece[][] board;
		int height;
		int width;
		if(gameTypeString.equals("Othello")) {
			board = new OthelloPiece[OTHELLOWIDTH][OTHELLOHEIGHT];
			height = OTHELLOHEIGHT;
			width = OTHELLOWIDTH;
		} else {
			board = new ConnectFourPiece[CONNECT4WIDTH][CONNECT4HEIGHT];
			height = CONNECT4HEIGHT;
			width = CONNECT4WIDTH;
		}
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				String piece = in.next();
				switch (piece) {
				case "Y":	board[x][y] = new ConnectFourPiece(Color.YELLOW); break;
				case "R":	board[x][y] = new ConnectFourPiece(Color.RED); break;
				case "B":	board[x][y] = new OthelloPiece(Color.BLACK); break;
				case "W":	board[x][y] = new OthelloPiece(Color.WHITE); break;
				case "N":	board[x][y] = null; break;
				default:	brokenFileMsg(); break;
				}
			}
		}
		
		if(!in.nextLine().equals("X")) {
			brokenFileMsg();
		}
		
		return board;
	}
	
	private Player player(Scanner in) {
		Player player = null;
		Color color = null;
		String name = in.nextLine();
		String colorString = in.nextLine();
		String type = in.nextLine();
		
		switch(colorString) {
		case "Black":	color = Color.BLACK; break;
		case "White":	color = Color.WHITE; break;
		case "Red":		color = Color.RED; break;
		case "Yellow":	color = Color.YELLOW; break;
		default:		brokenFileMsg(); break;
		}
		
		switch(type) {
		case "Human":	player = new HumanPlayer(name, color); break;
		case "Easy":	player = new AIEasy(name, color); break;
		case "Hard":	player = new AIHard(name, color); break;
		default:		brokenFileMsg(); break;
		}
		
		return player;
	}
	
	private Color current(Scanner in) {
		String colorString = in.nextLine();
		Color color = null;
		
		switch(colorString) {
		case "Black":	color = Color.BLACK; break;
		case "White":	color = Color.WHITE; break;
		case "Red":		color = Color.RED; break;
		case "Yellow":	color = Color.YELLOW; break;
		default:		brokenFileMsg(); break;
		}
		
		return color;
	}
	
	private int timer(Scanner in) {
		return in.nextInt();
	}
}
