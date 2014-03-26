import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import boardGame.*;

import javax.swing.*;

import piece.ConnectFourPiece;
import piece.GamePiece;
import piece.OthelloPiece;

/**
* \\file connect4GUI.java
* \author Chak Yan Lam
* \date 22nd Feb 14
* 
* \see GUI.java
* 
* \brief Connect4GUI is used to set up the background of the game board.Extends GUI.
* 
* This class extends from the GUI class, it sets up the background of the connect four game board.
* Due to problems of trying to test in the main. Testing is done in another class

*/
public class Connect4GUI extends GUI {

	 /**
     * Set the the player names, player turn and the new game button to 
     * display on screen.
     * \return boolean  return true if the action complete.
     */
	public boolean setInfo(){
		boolean test = false;
		if (test || m_test){
			System.out.println("Connect4GUI :: SetConnectFourInfo() BEGIN");
		}
		
		playerOneColor.setText(GetGame().GetPlayerName(Color.RED)+":");
		playerOneColor.setFont(FONT);
		playerOneColor.setVisible(true);
		ConnectFourPiece red = new ConnectFourPiece(Color.RED);
		playerOneIcon.setIcon(red.GetIcon());
		playerOneIcon.setVisible(true);
		playerTwoColor.setText(GetGame().GetPlayerName(Color.YELLOW)+":");
		playerTwoColor.setFont(FONT);
		playerTwoColor.setVisible(true);
		ConnectFourPiece yellow = new ConnectFourPiece(Color.YELLOW);
		playerTwoIcon.setIcon(yellow.GetIcon());
		playerTwoIcon.setVisible(true);
		playerTurnIcon.setIcon(new ConnectFourPiece(
				GetGame().GetCurrent().GetPieceColour()).GetIcon());
		playerTurnIcon.setVisible(true);
		playerTurnLabel.setText(
				GetGame().GetCurrent().GetPlayerName() + "'s TURN");
		playerTurnLabel.setFont(FONT);
		playerTurnLabel.setVisible(true);
		FRAME.pack();
		
		if (test || m_test){
			System.out.println("Connect4GUI :: SetConnectFourInfo() END");
		}
		return true;
	}
	
		 /**
     * Set the background colour of the connect four game board. 
     * \return boolean  return true if the action complete.
     */
	public boolean setPanelColour() {
		boolean test = false;
		if (test || m_test){
			System.out.println("Connect4GUI :: SetPannelColour() BEGIN");
		}
		
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
				GetPanel(x, y).removeAll();
				GetPanel(x, y).add(new JLabel(EMPTY));
				GetPanel(x, y).setBackground(Color.BLUE);
			}
		}
		
		if (test || m_test){
			System.out.println("Connect4GUI :: SetPannelColour() END");
		}
		
		return true;
	}
	
    /**
    * Constructor of Connect4GUI, calls the constructor of GUI for constructing
    *  the game board and sets the player information.
    * \param a BoardGame object which is in ConnectFour type,a GameController 
    * object.
    */
	
	public Connect4GUI(BoardGame b, GameController g) {
		super(b, g);
		
		boolean test = false;
		if (test || m_test){
			System.out.println("Connect4GUI :: Connect4GUI() BEGIN");
		}

		EMPTY = new ImageIcon(getClass().getResource("empty.png"));
		
		setInfo();
		
		if (test || m_test){
			System.out.println("Connect4GUI :: Connect4GUI() END");
		}
	}

	/** image icon which holds a blank piece image*/
	private final ImageIcon EMPTY;
	/** boolean turn to true to print out beginning and ends of methods*/
	private boolean m_test = false;
}
