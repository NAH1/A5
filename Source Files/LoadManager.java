import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import piece.*;

/**
 * 	\\file LoadManager.java
 * 	\author Gavin Tsang
 *	\date 27/03/2014
 *
 *	\brief LoadManger deals with loading a saved game from a file
 */
public class LoadManager {
	
	/**
	 * Constructor which calls method load() to load the file
	 */
	public LoadManager() {
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
	
	/**
	 * Recreates the game state to what it was at the time of saving the game
	 * Calls all the other private methods to recreate the game.
	 * Once game has been recreated, update the GUI once to output the
	 * pieces on the board to the screen
	 * \throws FileNotFoundException
	 */
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
					controller.GetBoard().SetPiece(x, y, board[x][y].GetColour());
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
		
		controller.GetGUI().getClock().stop();
		controller.GetGUI().setClock(new Clock(controller.GetGUI(), time));
		controller.GetGUI().setPanelColour();
		controller.GetGUI().DrawPieces();
		controller.GetGUI().setInfo();
	}
	
	/**
	 * Displays an error if the save file is broken or corrupted
	 */
	private void brokenFileMsg() {
		JOptionPane.showMessageDialog(null,
				"Error: Save File Corrupted",
				"Error",
				JOptionPane.ERROR_MESSAGE
				);
	}
	
	/**
	 * Finds the type of game that was saved
	 * \param in - Scanner object containing the file
	 * \return "Othello" or "Connect4" depending on what game was saved
	 */
	private String gameType(Scanner in) {
		String gameTypeString = in.nextLine();
		if (m_Trace) System.out.println(gameTypeString);
		if (!gameTypeString.equals("Othello") 
				&& !gameTypeString.equals("Connect 4")) {
			brokenFileMsg();
		}
		return gameTypeString;
	}
	
	/**
	 * Recreates the game board by going through the file line by line
	 * and finding out the GamePiece value at each coordinate
	 * \param in - Scanner object containing the file
	 * \param gameTypeString - string containing the gametype
	 * \return the gameboard that was saved
	 */
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
				String piece = in.nextLine();
				if (m_Trace) System.out.println(piece);
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
		
		if(!in.nextLine().equals("x")) {
			brokenFileMsg();
		}
		
		return board;
	}
	
	/**
	 * Creates a player object from the data in the file
	 * whether it is player 1 or player 2 depends on the call in load()
	 * \param in - Scanner object containing the file
	 * \return Player object containing data for one of the players
	 */
	private Player player(Scanner in) {
		Player player = null;
		Color color = null;
		String name = in.nextLine();
		String colorString = in.nextLine();
		String type = in.nextLine();
		if (m_Trace) System.out.println(name);
		if (m_Trace) System.out.println(colorString);
		if (m_Trace) System.out.println(type);
		
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
	
	/**
	 * Get the colour of the current players turn
	 * \param in - Scanner object containing the file
	 * \return The Colour of the current players turn
	 */
	private Color current(Scanner in) {
		String colorString = in.nextLine();
		if (m_Trace) System.out.println(colorString);
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
	
	/**
	 * Get the time passed at the time of saving the game
	 * \param in Scanner object containing the file
	 * \return The time passed at time of saving
	 */
	private int timer(Scanner in) {
		return in.nextInt();
	}
	
	/**
	 * Used for main method testing
	 * Tests both Load manager and Save Manager
	 */
	public static void main(String args[]) {
		final int maxY = 6;
		final int maxX = 9;
		GameController g = new GameController(GameController.GameType.CONNECTFOUR);
		
		g.GetBoard().SetPiece(0, maxY, Color.RED);
		g.GetBoard().SetPiece(maxX, maxY, Color.YELLOW);
		g.GetBoard().SetPiece(maxX - maxY, maxY, Color.RED);
		g.GetGUI().DrawPieces();
		
		new SaveManager(g);
		new LoadManager();
	}
	
	private boolean m_Trace = true;
}
