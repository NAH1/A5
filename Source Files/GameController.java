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
	public String GetPlayerName(String colour) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GetPlayerName() BEGIN");
        }
        
		if (m_p1.GetPiece().equals(colour)) {
		if (test || m_test) {
			System.out.println("GameController :: GetPlayerName() END");
		}
			return m_p1.GetPlayerName();
		} else {
		if (test || m_test) {
			System.out.println("GameController :: GetPlayerName() END");
		}
			return m_p2.GetPlayerName();
		}
	}

	 /**
     * Get current player name.
     * \return String  return the name of the current player.
     */
	public String GetCurrent() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GetCurrent() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("GameController :: GetCurrent() END");
        }
		
		return m_currentPlayer.GetPiece();
	}

	 /**
	  * Exchange player turn in othello or connect four.
  */
	public void Alternate() {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: Alternate() BEGIN");
        }
		if (m_currentPlayer == m_p1) {
			if (test || m_test) {
	            System.out.println("GameController :: Alternate() END :: " + 
	                                m_currentPlayer + " " + m_p2);
	        }
			m_currentPlayer = m_p2;
		} else if (m_currentPlayer == m_p2) {
			if (test || m_test) {
	            System.out.println("GameController :: Alternate() END :: " + 
	                                m_currentPlayer + " " + m_p1);
	        }
			m_currentPlayer = m_p1;
		}
	
		if (m_gameType.equals(m_othello)) {
			if (test || m_test) {
	            System.out.println("GameController :: Alternate() END");
	        }
			m_othelloGUI.SetPanelColour();
			m_othelloGUI.SetOthelloInfo();
		} else if (m_gameType.equals(m_connectFour)) {
			if (test || m_test) {
	            System.out.println("GameController :: Alternate() END");
	        }
			m_c4GUI.SetPanelColour();
			m_c4GUI.SetConnectFourInfo();
		}
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
		if (m_gameType.equals(m_othello)) {
			if (test || m_test) {
	            System.out.println("GameController :: CheckWin() END");
	        }
			win = m_othelloBoard.WinningCondition();
		} else if (m_gameType.equals(m_connectFour)) {
			if (test || m_test) {
	            System.out.println("GameController :: CheckWin() END");
	        }
			win = m_connectFourBoard.WinningCondition();
		}
		SetGameOn(win);
		return win;
	}

	/**
	  * Set up the game board with given game type.
	  * \param the game type.
  */
	public void SetUp(String m_gameType) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: SetUp() BEGIN");
        }
		// System.out.println(getCurrent());

		if (m_gameType.equals(m_othello)) {
			if (test || m_test) {
	            System.out.println("GameController :: SetUp() END");
	        }
			m_othelloBoard = new Othello();
			m_othelloGUI = new OthelloGUI(m_othelloBoard, this);
			m_othelloGUI.DrawPieces();
			m_othelloGUI.SetPanelColour();
		} else if (m_gameType.equals(m_connectFour)) {
			if (test || m_test) {
	            System.out.println("GameController :: SetUp() END");
	        }
			m_connectFourBoard = new ConnectFour();
			m_c4GUI = new Connect4GUI(m_connectFourBoard, this);
			m_c4GUI.SetPanelColour();
		}
	}
	
	 /**
	  * Constructor of GameController.
	  * \param game type, the two HumanPlayer objects
    */
	public GameController(String gt, HumanPlayer one, HumanPlayer two) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GameController() BEGIN");
        }
		m_p1 = one;
		m_p2 = two;
		m_currentPlayer = m_p1;
		m_gameType = gt;
		SetUp(m_gameType);
		
		if (test || m_test) {
            System.out.println("GameController :: GameController() END");
        }
	}

	 /**
	  * It is used for testing.
	  * \param the game type.
    */
	public GameController(String gt) {
		boolean test = false;
        if (test || m_test) {
            System.out.println("GameController :: GameController() BEGIN");
        }
		m_gameType = gt;

		if (m_gameType.equals(m_othello)) {
			if (test || m_test) {
	            System.out.println("GameController :: GameController() END");
	        }
			m_p1 = new HumanPlayer("Jim", "white");
			m_p2 = new HumanPlayer("Bob", "black");
		} else if (m_gameType.equals(m_connectFour)) {
			if (test || m_test) {
	            System.out.println("GameController :: GameController() END");
	        }
			m_p1 = new HumanPlayer("Jim", "red");
			m_p2 = new HumanPlayer("Bob", "yellow");
		}
		m_currentPlayer = m_p1;
		// System.out.println("P1: " + m_p1.GetPiece());
		// System.out.println("P2: " + m_p2.GetPiece());

		SetUp(m_gameType);
		if (test || m_test) {
            System.out.println("GameController :: GameController() END");
        }
	}

	 

	 /**
	  * It is used for testing.
     */
	public static void main(String[] args) {
		GameController a = new GameController("m_connectFour");
		//GameController b = new GameController("m_othello");
		
		/** Can't get these test cases to run */
		a.GetGamOn(); 
		a.Alternate();
		a.CheckWin();
	
	}

	/**The default String for the ConnectFour game*/
	private final String m_connectFour = "connectFour";
	/**The default String for the Othello game*/
	private final String m_othello = "othello";
	/**Identifier for the Connect4GUI*/
	private Connect4GUI m_c4GUI;
	/**Identifier for the Othello4GUI*/
	private OthelloGUI m_othelloGUI;
	/**Identifier for the Othello Gameboard*/
	private Othello m_othelloBoard;
	/**Identifier for the Connect4 Gameboard*/
	private ConnectFour m_connectFourBoard;
	/**Stores the gameType (connectFour or Othello).*/
	private String m_gameType;
	/**Available for a boolean test to check whether the game is still in session*/
	private boolean m_gameOn = true;
	/**Identifier for first player object*/
	private HumanPlayer m_p1;
	/**Identifier for second player object*/
	private HumanPlayer m_p2;
	/**Identifier to store which player object is the current turn*/
	private HumanPlayer m_currentPlayer;
	/** Indicates whether to run tests */
    private boolean m_test = false;
}
