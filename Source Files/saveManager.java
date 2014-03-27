import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * \file -SaveManager.java
 * \author - Lewis Edwards
 * \date -24nd Mar 14
 * 
 * \brief  SaveManager handles the saving of a game.
 *
 * 
 */
public class SaveManager {
	
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
					if (game.GetBoard().GetPiece(i, j).GetColour() == Color.YELLOW){
						p.print("Y");
					}
					else if (game.GetBoard().GetPiece(i, j).GetColour() == Color.RED){
						p.print("R");
					}
					else if (game.GetBoard().GetPiece(i, j).GetColour() == Color.BLACK){
						p.print("B");
					}	
					else if (game.GetBoard().GetPiece(i, j).GetColour() == Color.WHITE){
						p.print("W");
					}
					else {
						p.print("N");
					}
				}
				p.println();
			}
			p.print("x");
			p.println(game.getPlayer1().GetPlayerName());
			p.println(game.getPlayer1().GetPieceColour());
			if (game.getPlayer1().isAI()) {
				if(game.getPlayer1() instanceof AIHard) {
					p.println("Hard");
				} else {
					p.println("Easy");
				}
			}
			p.println(game.getPlayer2().GetPlayerName());
			p.println(game.getPlayer2().GetPieceColour());
			if (game.getPlayer2().isAI()) {
				if(game.getPlayer2() instanceof AIHard) {
					p.println("Hard");
				} else {
					p.println("Easy");
				}
			}
			
			p.println(game.GetCurrent().GetPieceColour());
			p.println(game.GetGUI().getClock().getTime());
			p.close();

			System.out.println("Saved");

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
} 