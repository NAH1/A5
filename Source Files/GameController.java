import java.awt.Color;

import Player.*;
import boardGame.*;
/**
 * \\file -GameController.java 
 * \author - Thomas Letheby
 * \date -22nd Feb 14
 * 
 * \brief GameController is used to control the game flow. 
 * 
 * This class monitor the game status, it checks the winning condition and change the player turn.
 * There are tests that cannot be run due to problems in the class.
 */
public class GameController {

		 /**
     * Get whether the game is finished or not.
     * \return boolean  return true if the game is on.
     */
     
	public boolean GetGamOn() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GetGamOn() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("GameController :: GetGamOn() END");
        }
		
		
		return m_gameOn;
	}

	 /**
     * Set whether the game is finished or not.
     * \param the situation of the the game.
     * \return boolean  return true if the game is on.
     */
	public boolean SetGameOn(boolean win) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: SetGameOn() BEGIN");
        }
		if (win) {
			if (test || m_test) {
	            System.out.println("GameController :: SetGameOn() END");
	        }
			m_gameOn = false;
		} else {
			if (test || m_test) {
	            System.out.println("GameController :: SetGameOn() END");
	        }
			m_gameOn = true;
		}
		return true;
	}

	 /**
     * Get player name.
     * \param the colour of a piece.
     * \return String  return the player name with the given colour.
     */
	public String GetPlayerName(Color colour) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GetPlayerName() BEGIN");
        }
        
		if (getPlayer1().GetPieceColour() == colour) {
		if (test || m_test) {
			System.out.println("GameController :: GetPlayerName() END");
		}
			return getPlayer1().GetPlayerName();
		} else {
		if (test || m_test) {
			System.out.println("GameController :: GetPlayerName() END");
		}
			return getPlayer2().GetPlayerName();
		}
	}

	 /**
	 * @return the m_p1
	 */
	public Player getPlayer1() {
		return m_p1;
	}

	/**
	 * @param m_p1 the m_p1 to set
	 */
	public void setPlayer1(Player player) {
		m_p1 = player;
	}

	/**
	 * @return the m_p2
	 */
	public Player getPlayer2() {
		return m_p2;
	}

	/**
	 * @param m_p2 the m_p2 to set
	 */
	public void setPlayer2(Player player) {
		m_p2 = player;
	}

	/**
     * Get current player.
     * \return String  return the name of the current player.
     */
	public Player GetCurrent() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GetCurrent() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("GameController :: GetCurrent() END");
        }
		
		return m_currentPlayer;
	}

	 /**
	  * Exchange player turn in othello or connect four.
  */
	public void Alternate() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: Alternate() BEGIN");
        }
		if (m_currentPlayer == getPlayer1()) {
			if (test || m_test) {
	            System.out.println("GameController :: Alternate() END :: " + 
	                                m_currentPlayer + " " + getPlayer2());
	        }
			m_currentPlayer = getPlayer2();
		} else if (m_currentPlayer == getPlayer2()) {
			if (test || m_test) {
	            System.out.println("GameController :: Alternate() END :: " + 
	                                m_currentPlayer + " " + getPlayer1());
	        }
			m_currentPlayer = getPlayer1();
		}
		if (test || m_test) {
            System.out.println("GameController :: Alternate() END");
        }
		m_GUI.setPanelColour();
		m_GUI.setInfo();
	}

	 /**
	  * Check the winning condition of othello and connect four.
	  * return boolean  true when the game is finished.
  */
	public boolean CheckWin() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: CheckWin() BEGIN");
        }
		boolean win = false;
		if (test || m_test) {
            System.out.println("GameController :: CheckWin() END");
        }
		win = m_board.WinningCondition();
	
		SetGameOn(win);
		return win;
	}

	/**
	  * Set up the game board with given game type.
	  * \param the game type.
  */
	public void SetUp(GameType gameType) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: SetUp() BEGIN");
        }
		// System.out.println(getCurrent());
		if (test || m_test) {
            System.out.println("GameController :: SetUp() END");
        }
		if (gameType == GameType.OTHELLO) {
			m_board = new Othello();
			m_GUI = new OthelloGUI(m_board, this);
		} else if (gameType == GameType.CONNECTFOUR) {
			m_board = new ConnectFour();
			m_GUI = new Connect4GUI(m_board, this);
		}
		m_GUI.DrawPieces();
		m_GUI.setPanelColour();
	}
	
	 /**
	  * Constructor of GameController.
	  * \param game type, the two HumanPlayer objects
    */
	public GameController(GameType gt, Player one, Player two) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GameController() BEGIN");
        }
		setPlayer1(one);
		setPlayer2(two);
		if (gt == GameType.CONNECTFOUR) {
			m_currentPlayer = getPlayer1();
		} else if (gt == GameType.OTHELLO) {
			if(getPlayer1().GetPieceColour() == Color.BLACK) {
				m_currentPlayer = getPlayer1();
			} else if (getPlayer2().GetPieceColour() == Color.BLACK){
				m_currentPlayer = getPlayer2();
			} else {
				m_currentPlayer = getPlayer1();
				System.err.println("GameController::GameController() Error,"
						+ "Current player is not valid");
			}
		}
		SetUp(gt);
		
		if (test || m_test) {
            System.out.println("GameController :: GameController() END");
        }
	}

	 /**
	  * It is used for testing.
	  * \param the game type.
    */
	public GameController(GameType gt) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GameController() BEGIN");
        }

		if (gt == GameType.OTHELLO) {
			if (test || m_test) {
	            System.out.println("GameController :: GameController() END");
	        }
			setPlayer1(new HumanPlayer("Jim", Color.WHITE));
			setPlayer2(new HumanPlayer("Bob", Color.BLACK));
		} else if (gt == GameType.CONNECTFOUR) {
			if (test || m_test) {
	            System.out.println("GameController :: GameController() END");
	        }
			setPlayer1(new HumanPlayer("Jim", Color.RED));
			setPlayer2(new HumanPlayer("Bob", Color.YELLOW));
		}
		m_currentPlayer = getPlayer1();
		// System.out.println("P1: " + getPlayer1().GetPiece());
		// System.out.println("P2: " + getPlayer2().GetPiece());

		SetUp(gt);
		if (test || m_test) {
            System.out.println("GameController :: GameController() END");
        }
	}

	 

	 /**
	  * It is used for testing.
     */
	public static void main(String[] args) {
		GameController a = new GameController(GameType.CONNECTFOUR);
		//GameController b = new GameController("m_othello");
		
		/** Can't get these test cases to run */
		a.GetGamOn(); 
		a.Alternate();
		a.CheckWin();
	
	}

	public enum GameType {OTHELLO, CONNECTFOUR};
	/**Identifier for the GUI*/
	private GUI m_GUI;
	/**Identifier for the Gameboard*/
	private BoardGame m_board;
	/**Available for a boolean test to check whether the game is still in session*/
	private boolean m_gameOn = true;
	/**Identifier for first player object*/
	private Player m_p1;
	/**Identifier for second player object*/
	private Player m_p2;
	/**Identifier to store which player object is the current turn*/
	private Player m_currentPlayer; //TODO Getter and setter
	/** Indicates whether to run tests */
    private boolean m_test = false;
}
