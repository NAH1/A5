import java.awt.Color;

import javax.swing.BorderFactory;

import piece.OthelloPiece;

/**
 * \\file -OthelloGUI.java 
 * \author - Jake Daryl Plumley
 * \date -22nd Feb 14
 * 
 * \see GUI.java
 * 
 * \brief OthelloGUI is used to set up and update the background of the Othello
 *  game board. 
 *  
 * This class extends from the GUI class, it changes the background colors of 
 * each square with different available moves.extends GUI.java
 * 
 * Due to problems of trying to test in the main. 
 * Testing is done in another class
 */
public class OthelloGUI extends GUI {

	 /**
     * Set the player names, scores, player turn, the pass and new game button
     *  to display on screen.
     * \return boolean  return true if the action complete.
     */	
	public boolean setInfo() {
		boolean test = false;
		if (test || m_test){
			System.out.println("OthelloGUI :: SetOthelloInfo() BEGIN");
		}
		
		m_playerOneColor.setText(GetGame().GetPlayerName(Color.BLACK) + ":");
		m_playerOneColor.setFont(FONT);
		m_playerOneColor.setVisible(true);
		OthelloPiece black = new OthelloPiece(Color.BLACK);
		m_playerOneIcon.setIcon(black.GetIcon());
		m_playerOneIcon.setVisible(true);
		m_playerTwoColor.setText(GetGame().GetPlayerName(Color.WHITE) + ":");
		m_playerTwoColor.setFont(FONT);
		m_playerTwoColor.setVisible(true);
		OthelloPiece white = new OthelloPiece(Color.WHITE);
		m_playerTwoIcon.setIcon(white.GetIcon());
		m_playerTwoIcon.setVisible(true);
		m_playerTurnIcon.setIcon(new OthelloPiece(
				GetGame().GetCurrent().GetPieceColour()).GetIcon());
		m_playerTurnIcon.setVisible(true);
		m_playerTurnLabel.setText(
				GetGame().GetCurrent().GetPlayerName() + "'s TURN");
		m_playerTurnLabel.setFont(FONT);
		m_playerTurnLabel.setVisible(true);
		m_blackIcon.setIcon(black.GetIcon());
		m_blackIcon.setVisible(true);
		m_blackPieces.setText(((Othello) (GetBoard())).GetBlackScore() + "");
		m_blackPieces.setFont(FONT);
		m_blackPieces.setVisible(true);
		m_whiteIcon.setIcon(white.GetIcon());
		m_whiteIcon.setVisible(true);
		m_whitePieces.setText(((Othello) (GetBoard())).GetWhiteScore() + "");
		m_whitePieces.setFont(FONT);
		m_whitePieces.setVisible(true);
		PASSMOVE.setVisible(true);
		FRAME.pack();
		
		if (test || m_test){
			System.out.println("OthelloGUI :: SetOthelloInfo() END");
		}
		
		return true;
	}

	 /**
     * Set the background colour and border of each square in the game board 
     * with regard to available moves of different player. 
     * \return boolean  return true if the action complete.
     */
	public boolean setPanelColour() {
		boolean test=false;
		if (test || m_test){
			System.out.println("OthelloGUI :: SetPanelColour() BEGIN");
		}
		
		char[][] availableMoves = ((Othello) GetBoard())
				.AvailableMove(GetGame().GetCurrent().GetPieceColour());
		Color defCol = BACKGROUND_COLOR;
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
			GetPanel(x, y).setBorder(BorderFactory
					.createLineBorder(Color.black));
				if (availableMoves[x][y] == 'O') {
					if ((GetGame().GetCurrent().GetPieceColour() 
					== Color.BLACK))
					GetPanel(x, y).setBackground(Color.BLUE);
					else
					GetPanel(x, y).setBackground(Color.RED);
				} else {
					GetPanel(x, y).setBackground(defCol);
				}
			}
		}
		
		if (test || m_test){
			System.out.println("OthelloGUI :: SetPanelColour() END");
		}
		
		return true;
	}
	
    /**
    * Constructor of OthelloGUI, calls the constructor of GUI for constructing
    * the game board and sets the player information.
    * \param a BoardGame object which is in Othello type,
    * a GameController object
    */
	public OthelloGUI(BoardGame b, GameController g) {
		super(b, g);
		setInfo();
	}
	/** boolean turn to true to print out begining and ends of methods*/
	boolean m_test = false;
	private final int BACK_RED = 170;
	private final int BACK_GREEN = 150;
	private final int BACK_BLUE = 100;
	/** background colour */
	private final Color BACKGROUND_COLOR = 
			new Color(BACK_RED, BACK_GREEN, BACK_BLUE);

}
