import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * \\file - AIEasy.java
 * \author Geraint Howard - 710909
 * \date 27/03/2014
 * 
 * \brief Sets how the computer will make moves in both games.
 * 		  Computer selects any random legal move then places a piece there
 */

public class AIEasy extends Player{
	
	/**
	 * Sets the player's name and sets the player's color
	 * \param name - the name of the player
	 * \param color - the color of the player
	 * 
	 */
	
	public AIEasy(String name, Color color) {
		SetPlayerName(name);
		SetPieceColor(color);
	}
	
	/**
	 * Gets the x coordinate
	 * \return the x coordinate
	 */
	
	@Override
	public int getX() {
		return m_X;
	}
	
	/**
	 * Gets the y coordinate
	 * \return the y coordinate
	 */
	@Override
	public int getY() {
		return m_Y;
	}
	
    /**
     * Checks whether the player is AI or not
     * \return true
     */
	@Override
	public boolean isAI() {
		return true;
	}
	
	/**
	 * Creates an array list of all legal moves that the computer can make. 
	 * The computer then randomly chooses one these moves
	 * 
	 * \return true
	 */
	
	public boolean takeMove(){
		ArrayList<int[]> moves = new ArrayList<int[]>();
		char[][] availableMoves = (GetBoard())
				.AvailableMove(GetPieceColour());
		
		for (int y = 0; y < GetBoard().GetHeight(); ++y) {
			for (int x = 0; x < GetBoard().GetWidth(); ++x) {
				if (availableMoves[x][y] == 'O') {
					int score = GetBoard().MoveQuality(x,y,this);
					int[] move = {x, y, score};
					moves.add(move);
				}
			}
		}
		
		Random ran = new Random();
		int random = ran.nextInt(moves.size());
					
		m_X = moves.get(random)[0];	
		m_Y = moves.get(random)[1];
		
		return true;
	}
	
	// Global variables
	private int m_X;
	private int m_Y;
}

