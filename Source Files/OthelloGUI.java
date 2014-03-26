import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

import piece.GamePiece;
import piece.OthelloPiece;
import boardGame.*;

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
		
		playerOneColor.setText(GetGame().GetPlayerName(Color.BLACK) + ":");
		playerOneColor.setFont(FONT);
		playerOneColor.setVisible(true);
		OthelloPiece black = new OthelloPiece(Color.BLACK);
		playerOneIcon.setIcon(black.GetIcon());
		playerOneIcon.setVisible(true);
		playerTwoColor.setText(GetGame().GetPlayerName(Color.WHITE) + ":");
		playerTwoColor.setFont(FONT);
		playerTwoColor.setVisible(true);
		OthelloPiece white = new OthelloPiece(Color.WHITE);
		playerTwoIcon.setIcon(white.GetIcon());
		playerTwoIcon.setVisible(true);
		playerTurnIcon.setIcon(new OthelloPiece(
				GetGame().GetCurrent().GetPieceColour()).GetIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText(
				GetGame().GetCurrent().GetPlayerName() + "'s TURN");
		playerTurnLabel.setFont(FONT);
		playerTurnLabel.setVisible(true);
		blackIcon.setIcon(black.GetIcon());
		blackIcon.setVisible(true);
		blackPieces.setText(((Othello) (GetBoard())).GetBlackScore() + "");
		blackPieces.setFont(FONT);
		blackPieces.setVisible(true);
		whiteIcon.setIcon(white.GetIcon());
		whiteIcon.setVisible(true);
		whitePieces.setText(((Othello) (GetBoard())).GetWhiteScore() + "");
		whitePieces.setFont(FONT);
		whitePieces.setVisible(true);
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
		Color defCol = new Color(170, 150, 100);
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
				GetPanel(x, y).setBorder(BorderFactory
						.createLineBorder(Color.black));
				if (availableMoves[x][y] == 'O') {
					if ((GetGame().GetCurrent().GetPieceColour() == Color.BLACK))
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
    * \param a BoardGame object which is in Othello type,a GameController object
    */
	public OthelloGUI(BoardGame b, GameController g) {
		super(b, g);
		setInfo();
	}
	/** boolean turn to true to print out begining and ends of methods*/
	boolean m_test = false;
}
