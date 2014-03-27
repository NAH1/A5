import java.awt.Color;

/**
 * \\file -HumanPlayer.java 
 * \author -Mathew Lloyd 711293 
 * \date -20th Feb 14
 * 
 * \see Player.java
 * 
 * \brief HumanPlayer, used to store data about the player, extends Player.java
 * 
 * This class extends from the Player class. It inherits the accessor methods,
 * implements the methods in it's own way that differs to other player types.
 */

public class HumanPlayer extends Player {
	
	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public boolean takeMove() {
		return false;
	}
	
	@Override
	public boolean isAI() {
		return false;
	}

	/** No argument constructor for testing purposes */
	private HumanPlayer() {
		boolean test = false;
		if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() BEGIN");
		}
        if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() END");
        }
	}
	
	/**
	 * This is the constructor for the player calls to set the player name, turn
	 * and piece colour
	 * 
	 * \param playName a String that contains the players name 
	 * \param gamePiece sets the players piece colour
	 * 
	 */
	public HumanPlayer(String playName, Color gamePiece) {
		boolean test = false;
		if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() BEGIN");
        }
		
		SetPlayerName(playName);
		SetPieceColor(gamePiece);
		
		if (test || m_test) {
            System.out.println("HumanPlayer :: HumanPlayer() END");
        }
	}
	
	/**
	 * Testing in the main method.
	 */
	public static void main(String args[]) {
		boolean test = false;
		if (test == true) {
			System.out.println("HumanPlayer::main() BEGIN unit test");
		}
		/** Invalid Entry: */
		HumanPlayer humanPlayer = new HumanPlayer();
		humanPlayer.SetPlayerName("");
		humanPlayer.SetPlayerName("Proper Name Player");
		/** Valid Entries: */
		humanPlayer.SetPieceColor(Color.RED);
		/** Print statements to test setting of piece colour */
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPieceColour());
		humanPlayer.SetPieceColor(Color.RED);
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPieceColour());
		humanPlayer.SetPieceColor(Color.BLACK);
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPieceColour());
		humanPlayer.SetPieceColor(Color.WHITE);
		System.out.println("HumanPlayer test:: Piece: "
				+ humanPlayer.GetPieceColour());
		System.out.println("HumanPlayer test:: PlayerName: "
				+ humanPlayer.GetPlayerName());
		if (test == true) {
			System.out.println("HumanPlayer::main() END unit test");
		}
	}
	/** Indicates whether to run tests */
    private boolean m_test = false;
}
