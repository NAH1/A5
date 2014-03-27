import java.awt.Color;

import javax.swing.JPanel;

import piece.GamePiece;
import piece.OthelloPiece;
/**
 * \\file -Othello.java 
 * \author -Chun Kit So 742666
 * \date -21th Feb 14
 * 
 * \see BoardGame.java
 * 
 * \brief Othello is used to store the game rules and control the game board . 
 * extends BoardGame.java
 * 
 * This class extends from the BoardGame class. It will check the valid move 
 * when the player place the pieces and return the feedback.
 * 
 * Updated by BSAG to highlight winners
 */
public class Othello extends BoardGame {

	/**
	 * This is the constructor for the Othello. It passes the height and the
	 * width to BoardGame class for constructing the game board.
	 * 
	 */
	public Othello() {
		super(INITIAL_W, INITIAL_H);
        boolean test = false;
        
        if (test || m_test) {
            System.out.println("Othello :: Othello() BEGIN");
        }
		
		initialGame();
        if (test || m_test) {
            System.out.println("Othello :: Othello() END");
        }
	}

	/**
	 * Highlight winning colours
	 * @param m_Lables: the GUI label elements
	 * @param winner the winning colour ID
	 */
	public void HighlightWinners(JPanel[][] panels, Color winner) {
		for (int y = 0; y < GetHeight(); y++) {
			for (int x = 0; x < GetWidth(); x++) {
				System.out.println("HighlightWinners?");
				if (GetPiece(x,y).GetColour() == winner) {
					panels[x][y].setBackground(Color.CYAN);
				}
			}
		}
	}
	
	/**
	 * Public method,It passes the score to GUI class. \return scoreBlack the
	 * black player score.
	 */
	
	public int GetBlackScore() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: GetBlackScore() BEGIN");
        }
        if (test || m_test) {
            System.out.println("Othello :: GetBlackScore() END");
        }

		return m_scoreBlack;
        }

	/**
	 * Place the Othello piece on the game board 
	 * \param x the x axis in the game board. 
	 * \param y the y axis in the game board. 
	 * \param col the color of the game piece. 
	 * \return boolean return true if the action completes.
	 */
	public boolean SetPiece(int x, int y, Color col) {
        boolean test = true;
        if (test || m_test) {
            System.out.println("Othello :: SetPiece() BEGIN");
            System.out.println("Othello::SetPiecce()" + GetPiece(x, y));
        }
        if (x > GetWidth() || x < 0 || y > GetHeight() || y <0 ){
        	return false;
		}
		SetPiece(x, y, new OthelloPiece(col));
        if (test || m_test) {
            System.out.println("Othello :: SetPiece() END");
        }
		countScore();
		return true;
        
	}

	/**
	 * Public method,It passes the score to GUI class. 
	 * \return scoreWhite the white player score
	 */
	
	public int GetWhiteScore() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: GetWhiteScore() BEGIN");
        }
        if (test || m_test) {
            System.out.println("Othello :: GetWhiteScore() END");
        }

		return m_scoreWhite;
    }

	/**
	 * Calculate all the available positions on the game board, then store them
	 * in a char array. 
	 * \param col the color of the game piece. 
	 * \return availableMov return the char array that store 
	 * all the available moves.
	 */
	
	public char[][] AvailableMove(Color col) { // check available move and
		// return the char array.
		// 'O' means available move.

        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: AvailableMove() BEGIN");
        }
		m_availableMov = new char[GetWidth()][GetHeight()];

		for (int i = 0; i < GetHeight(); i++) {
			for (int j = 0; j < GetWidth(); j++) {
				if (validMove(j, i, col)) {
					m_availableMov[j][i] = 'O'; // Location of Available Move
                    
                } else {
					m_availableMov[j][i] = 'X';
				}
			}
		}
        if (test || m_test) {
            System.out.println("Othello :: AvailableMove() END");
        }

		return m_availableMov;
    }

	/**
	 * check if the player do not have any available move , pass the turn to
	 * opponent. 
	 * \return boolean return the char array that store all the available moves.
	 */
	public boolean CheckPassTurn() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: CheckPassTurn() BEGIN");
        }

		boolean passTurn = true;
		for (int i = 0; i < GetHeight(); i++) {
			for (int j = 0; j < GetWidth(); j++) {
				if (m_availableMov[j][i] == 'O') { // Check the AvailableMov in
					// array
					passTurn = false; // if there is AvailableMov , then no need
					// to pass the turn to opponent
				}
			}
		}
        if (test || m_test) {
            System.out.println("Othello :: CheckPassTurn() END");
        }
		return passTurn;
    }

	/**
	 * Loop though the game board and count the current score.
	 */
	private void countScore() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: countScore() BEGIN");
        }

		m_scoreBlack = 0;
		m_scoreWhite = 0;
		for (int i = 0; i < GetHeight(); i++) {
			for (int j = 0; j < GetWidth(); j++) {
				if (board[j][i] != null) {
	
					if (board[j][i].GetColour() == Color.BLACK) {
						m_scoreBlack++;
					} else if (board[j][i].GetColour() == Color.WHITE)
						m_scoreWhite++;
				}
			}
		}
        
		// System.out.println("Black Score:" + scoreBlack + " White Score:"
		// + scoreWhite);
        if (test || m_test) {
            System.out.println("Othello :: countScore() END");
        }

	}
 
	/**
	 * Flip the piece if it is a valid move
	 * \param col the color of the game piece.
	 */
	
	private void flip(Color col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: flip() BEGIN");
        }

        int delay = 0;
		for (int a = 0; a < m_counter; a++) {
			m_searchY -= m_i_diff;
			m_searchX -= m_j_diff;
			board[m_searchX][m_searchY].SetColour(col);
			
			// here call Animation.setXcoord(m_searchX); TODO
			// here call Animation.setYcoord(m_searchY); TODO
			// <animation object>.animate(m_searchX, m_searchY, Color.something);
			GetAnimationController().animate(m_searchX, m_searchY, col, delay);
			delay++;
		}
        if (test || m_test) {
            System.out.println("Othello :: flip() END");
        }
	}

	/**
	 * Initialize the game. Four pieces are centered.
	 */
	private void initialGame() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: initialGame() BEGIN");
        }

		SetPiece(INTIAL_X, INITIAL_Y, Color.BLACK);
		SetPiece(INITIAL_X_TWO, INITIAL_Y_TWO, Color.BLACK);
		SetPiece(INITIAL_X_TWO, INITIAL_Y, Color.WHITE);
		SetPiece(INTIAL_X, INITIAL_Y_TWO, Color.WHITE);
		countScore();
        if (test || m_test) {
            System.out.println("Othello :: initialGame() END");
        }

	}

	/**
	 * If the move is valid, place the piece on the game board and check the
	 * winning condition. 
	 * \param x the x axis in the game board. 
	 * \param y the y axis in the game board. 
	 * \param col the color of the game piece. 
	 * \return boolean return true if the move is valid and the
	 *  piece has been placed on the game board.
	 */

	public boolean Move(int x, int y, Color col) { // move action
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: Move() BEGIN");
        }
        if (x > GetWidth() || x < 0 || y > GetHeight() || y < 0) {
        	System.out.println("Othello :: Move() END");
			return false;
			}

		if (validMove(x, y, col) == true) { // check whether the move is valid
			do {
				flip(col); // do the flip action here
			} while (validMove(x, y, col)); // while it is valid move
			SetPiece(x, y, col); // add the piece into gameBoard
			countScore();
			WinningCondition();
			if (test || m_test) {
	            System.out.println("Othello :: Move() END");
	        }
			return true;
			
			
		} else {
			if (test || m_test) {
	            System.out.println("Othello :: Move() END");
	        }
			return false;
		}

	}

	public boolean SetWinner() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: SetWinner() BEGIN");
        }

		if (m_scoreBlack == m_scoreWhite) {
			SetWinningColour(null);

		} else if (m_scoreWhite > m_scoreBlack)
			SetWinningColour(Color.WHITE);
		else {
			SetWinningColour(Color.BLACK);
		}
        if (test || m_test) {
            System.out.println("Othello :: SetWinner() END");
        }

		return true;
        	}

	/**
	 * Check whether the move is valid or not , It will search through 8
	 * directions of the new piece. 
	 * \param x the x axis in the game board.
	 * \param y the y axis in the game board. 
	 * \param col the color of the game piece. 
	 * \return boolean return true if the move is valid.
	 */

		//HACK
	public boolean AnyValidMoveForAnyone()
	{
		for (int y = 0; y < INITIAL_H; y++)
		{
			for (int x = 0; x < INITIAL_W; x++)
			{
				if (validMove(x, y, Color.WHITE)) { return true; }
				if (validMove(x, y, Color.BLACK)) { return true; }
			}
		}
		
		return false;
	}
	
	private boolean validMove(int x, int y, Color col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: validMove() BEGIN");
        }

		// check valid move here (OTHELLO CORE)
		if (board[x][y] == null) {
			GamePiece searchPiece;

			m_counter = 1;

			// Search each direction (total : 8 direction)
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					boolean found = false;
					m_searchY = y + i;
					m_searchX = x + j;
					if ((m_searchX >= GetWidth() || m_searchX < 0)
							|| (m_searchY >= GetHeight() || m_searchY < 0)) {
						// System.out.println("Over bound! Y:" + searchY +
						// " X: "
						// + searchX + " i:" + i + " j: " + j);
						// Debug message
						continue;

					} else {
						searchPiece = board[m_searchX][m_searchY];
					}
					// skip the search if i and j is 0.
					// skip the search if one of the direction is empty
					// skip the search if one of the direction is same color
					// piece
					if ((i == 0 && j == 0) || searchPiece == null
							|| searchPiece.GetColour() == col) {
						continue;
					}
					m_counter = 1;
					// Searching along the direction
					while (!found) {
						// System.out.println("Looping..");
						// Debug message
						m_searchX += j;
						m_searchY += i;

						// prevent out of bound, if over 8, exit the while loop
						// and stop searching this direction
						if ((m_searchX >= GetWidth() || m_searchX < 0)
								|| (m_searchY >= GetHeight() || m_searchY < 0)){
							found = true;
						} else {
							searchPiece = board[m_searchX][m_searchY];
							// System.out.println(searchValue.getColour());
						}

						// if find the same color is along to direction
						if (searchPiece == null) {
							found = true;
							// System.out.println("empty : true, Y:" + searchY +
							// ", X:" + searchX);
							// Debug message
						} else if (searchPiece.GetColour() == col) {

							found = true;
							m_j_diff = j;
							m_i_diff = i;
							// flip

							// System.out.println("found : true, Y:" + searchY +
							// ", X:" + searchX + ", newp value:" +
							// searchValue);
							// Debug message
							return true;
						} // If end of the direction is empty , then stop search
						// this direction.

						m_counter++;
					}
				}

			}
			if (test || m_test) {
	            System.out.println("Othello :: validMove() END");
	        }

			return false;
		}
		return false;
       
	}

	/**
	 * checking the winning condition, if the board has empty space or more than
	 * one black/white pieces on the board , the game keeps go on. 
	 * \return boolean return true if the player win the game.
	 */

	public boolean WinningCondition() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("Othello :: WinningCondition() BEGIN");
        }

		for (int x = 0; x < GetWidth(); x++) {
			for (int y = 0; y < GetHeight(); y++) {
				if (board[x][y] == null && m_scoreBlack != 0 && 
						m_scoreWhite != 0) {
					return false;
				}
			}
		}
		SetWinner();
        if (test || m_test) {
            System.out.println("Othello :: WinningCondition() END");
        }
		return true;
        
	}
	
	@Override
	public int MoveQuality(int x, int y, Player current) {
		countScore();
		int black = GetBlackScore();
		int white = GetWhiteScore();
		final GamePiece[][] GRID = board;
		Move(x, y, current.GetPieceColour());
		countScore();
		black = GetBlackScore() - black;
		white = GetWhiteScore() - white;
		board = GRID;
		if (current.GetPieceColour() == Color.WHITE) {
			return white;
		} else {
			return black;
		}
	}
	
    /** main method for tests */
    /*public static void main(String[] args) {
        Othello a = new Othello ();
        a.GetBlackScore();
        a.SetPiece(2,3,Color.WHITE);
        a.GetWhiteScore();
        a.AvailableMove(Color.BLACK);
        a.CheckPassTurn();
        a.countScore();
        a.initialGame();
        a.Move(2,2,Color.BLACK);
        a.SetWinner();
        a.validMove(4,4,Color.RED);
        a.WinningCondition();
    }*/
  //The following two int's are static due to calling the BoardGame in method.
    /**Sets the Size in BoardGame (is static due to calling the BoardGame in method*/
    private final static int INITIAL_W = 8;
    /**Sets the Size in BoardGame (is static due to calling the BoardGame in method*/
    private final static int INITIAL_H = 8;
    /**Counts the current pieces in a sequence to check for a win*/
	private int m_counter;
	/**Stores current score for white counter*/
	private int m_scoreWhite;
	/**Stores current score for black counter*/
	private int m_scoreBlack;
	/** integers to store the values to search next on the board for the winning conditions*/
	private int m_searchX;
	/** integers to store the values to search next on the board for the winning conditions*/
	private int m_searchY;
	/**Gets the number of pieces to flip*/
	private int m_i_diff;
	/**Gets the number of pieces to flip*/
	private int m_j_diff;
	/**Stores where the available moves are*/
	private char[][] m_availableMov;
	/**Setting up the initial piece positions*/
	private final int INTIAL_X = 3;
	/**Setting up the initial piece positions*/
	private final int INITIAL_X_TWO = 4;
	/**Setting up the initial piece positions*/
	private final int INITIAL_Y = 3;
	/**Setting up the initial piece positions*/
	private final int INITIAL_Y_TWO = 4;
	/**For testing purposes*/
    private boolean m_test = false;
}
