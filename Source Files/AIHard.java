package Player;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import boardGame.*;

/**
 * \\file - AIHard.java
 * \author Jiaming Dong - 742299
 * \date 27/03/2014
 * \brief Let the program take a move with logic.
 * 
 */

public class AIHard extends Player{	
	/**
	 * Extend BoardGame class.
	 * \param board
	 */
	public AIHard(BoardGame board) {
		m_board = board;
	}
	
	/**
	 * Get game board.
	 * \return game board.
	 */
	private BoardGame GetBoard() {
		return m_board;
	}
	
	/**
	 * Get x coordinate.
	 */
	@Override
	public int getX() {
		return m_X;
	}
	/**
	 * Get y coordinate.
	 */
	@Override
	public int getY() {
		return m_Y;
	}
	/**
	 *  Check whether the player is AI or not.
	 */
	@Override
	public boolean isAI() {
		return true;
	}
	/**
	 * Let the AI do a move.
	 */
	public boolean takeMove(){
		ArrayList<int[]> moves = new ArrayList<int[]>();
		char[][] availableMoves = ((ConnectFour) GetBoard())
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
		
		int position_max = 0;
		for(int i=0; i < moves.size() ;i++){
			if (moves.get(i)[2] > moves.get(position_max)[2]) {
				position_max = i;
			}
		}
		
		ArrayList<int[]> bestMoves = new ArrayList<int[]>();
		bestMoves.add(moves.get(position_max));
		for (int i = 0; i < moves.size(); i++) {
			if(moves.get(i)[2] == moves.get(position_max)[2]) {
				bestMoves.add(moves.get(i));
			}
		}
		
		Random ran = new Random();
		int random = ran.nextInt(bestMoves.size());
					
		m_X = bestMoves.get(random)[0];	
		m_Y = bestMoves.get(random)[1];
		
		return true;
	}
	/**
	 * Global variables.
	 */
	private int m_X;
	private int m_Y;
	private BoardGame m_board;
}