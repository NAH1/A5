/**
 * \\file -SaveManager.java
 * \author - Lewis Edwards
 * \date -24nd Mar 14
 * 
 * \brief  SaveManager handles the saving of a game.
 *
 * \
 */





import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class SaveManager {
	
	public SaveManager(GameController game) {

		File file = new File("SaveGame.txt");
		String content = "This needs to be saved.";
		try (FileOutputStream f = new FileOutputStream(file)) {


			PrintWriter p = new PrintWriter(file);
				
			
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
			p.print("x");
			p.print(game.getPlayer1().GetPlayerName());
			p.print(game.getPlayer1().GetPieceColour());
			if (game.getPlayer1().isAI()) {
				//p.print((game.getPlayer1() instanceof HardAI));
			}
			//AI TO BE IMPLEMENTED
			p.print(game.getPlayer2().GetPlayerName());
			p.print(game.getPlayer2().GetPieceColour());
			if (game.getPlayer2().isAI()) {
				//p.print((game.getPlayer1() instanceof HardAI));
			}
			}
			
			p.print(game.GetCurrent().GetPieceColour());
			p.print(game.GetGUI().getClock().getTime());
			//GET CLOCK TO BE IMPLEMENTED
			p.close();

			System.out.println("Saved");

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}











} 