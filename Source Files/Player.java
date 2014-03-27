import java.awt.Color;

/**
 * \\file -Player.java 
 * \author -Mathew Lloyd 711293 
 * \date -20th Feb 14
 * 
 * \see HumanPlayer.java 
 * \see http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * \brief Parent class of methods for HumanPlayer.java
 * 
 * This abstract class is the parent object for the different types of players,
 * it contains accessor methods for player data and abstract method declarations
 */

public abstract class Player {

	/** \return m_pieceColor players piece colour */
	public Color GetPieceColour() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Player :: GetPiece() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("Player :: GetPiece() END");
        }
		
		return m_pieceColor;
	}

	/** \return m_playerName the players name */
	public String GetPlayerName() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("Player :: GetPlayerName() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("Player :: GetPlayerName() END");
        }
		
		return m_playerName;
	}
	
	public abstract int getX();
	
	public abstract int getY();
	
	/**
	 * An accessor method to set the players name. 
	 * \param settingPlayerName parameter comes from the constructor, 
	 * sets the players name in the Player class.
	 */
	public boolean SetPlayerName(String settingPlayerName) {
		boolean test = false;
		if (settingPlayerName.isEmpty() && (test == true)) {
			System.err
			.println("*** Warning HumanPlayer:"
			        + "  :SetPlayerName() name set to empty string.");
		}
		m_playerName = settingPlayerName;
		return true;
	}

	/**
	 * An accessor method to set the players game piece colour. 
	 * \param gamePiece parameter comes from the constructor sets 
	 * the players piece colour in the Player class.
	 *  Has if statement to make sure that there are only 4 possible inputs
	 */
	public boolean SetPieceColor(Color gamePiece) {
		m_pieceColor = gamePiece;
		return true;
	}
	
	public abstract boolean isAI();
	
	public abstract boolean takeMove();

	/**
	 * For testing purposes have a main method.
	 */
	public static void main(String args[]) {
	}

	/** The players set name */
	protected String m_playerName;
	/** The players piece colour */
	protected Color m_pieceColor;
	/** Indicates whether to run tests */
    private boolean m_test = false;
}