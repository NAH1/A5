import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * \\file -SaveManager.java
 * \author - Lewis Edwards
 * \date -24nd Mar 14
 * 
 * \brief  SaveManager handles the saving of a game.
 *
 * This class handles all saving of a game. It saves the state of the game,
 * and the information on the players.
 */
public class SaveManager {
	/**
	 * This is the constructor for this class. Here, we save all aspects of
	 * the game, including the grid, player names, colour, wheather the 
	 * opponent is AI and the save time.
	 * \param game Creates an instance of the GameController class.
	 */
	public SaveManager(GameController game) {
		File file = new File("SaveGame.txt");
		try (FileOutputStream f = new FileOutputStream(file)) {
			PrintWriter p = new PrintWriter(file);	
			if (game.GetBoard() instanceof Othello) {
				p.println("Othello");
			} else {
				p.println("Connect 4");
			}
			for (int i = 0; i < game.GetBoard().GetWidth(); i++){
				for (int j = 0; j< game.GetBoard().GetHeight(); j++){
					if (game.GetBoard().GetPiece(i, j) == null) {
						p.println("N");
					} else if (game.GetBoard().GetPiece(i, j)
							.GetColour() == Color.YELLOW){
						p.println("Y");
					} else if (game.GetBoard().GetPiece(i, j)
							.GetColour() == Color.RED){
						p.println("R");
					} else if (game.GetBoard().GetPiece(i, j)
							.GetColour() == Color.BLACK){
						p.println("B");
					} else if (game.GetBoard().GetPiece(i, j)
							.GetColour() == Color.WHITE){
						p.println("W");
					} else {
						p.println("N");
					}
				}
			}
			p.println("x");
			p.println(game.getPlayer1().GetPlayerName());
			Color color = game.getPlayer1().GetPieceColour();
			if (color == Color.WHITE) p.println("White");
			else if (color == Color.BLACK) p.println("Black");
			else if (color == Color.RED) p.println("Red");
			else if (color == Color.YELLOW) p.println("Yellow");
			if (game.getPlayer1().isAI()) {
				if(game.getPlayer1() instanceof AIHard) {
					p.println("Hard");
				} else {
					p.println("Easy");
				}
			} else {
				p.println("Human");
			}
			p.println(game.getPlayer2().GetPlayerName());
			color = game.getPlayer2().GetPieceColour();
			if (color == Color.WHITE) p.println("White");
			else if (color == Color.BLACK) p.println("Black");
			else if (color == Color.RED) p.println("Red");
			else if (color == Color.YELLOW) p.println("Yellow");
			if (game.getPlayer2().isAI()) {
				if(game.getPlayer2() instanceof AIHard) {
					p.println("Hard");
				} else {
					p.println("Easy");
				}
			} else {
				p.println("Human");
			}
			color = game.GetCurrent().GetPieceColour();
			if (color == Color.WHITE) p.println("White");
			else if (color == Color.BLACK) p.println("Black");
			else if (color == Color.RED) p.println("Red");
			else if (color == Color.YELLOW) p.println("Yellow");
			p.println(game.GetGUI().getClock().getTime());
			p.close();
			System.out.println("Saved");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}	
} 
