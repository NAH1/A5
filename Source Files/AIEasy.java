import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * \\file - AIEasy.java
 * \author Geraint Howard - 710909
 * \date 27/03/2014
 */

public class AIEasy extends Player{
	
	public AIEasy(String name, Color color) {
		SetPlayerName(name);
		SetPieceColor(color);
	}
	
	
	
	@Override
	public int getX() {
		return m_X;
	}

	@Override
	public int getY() {
		return m_Y;
	}

	@Override
	public boolean isAI() {
		return true;
	}
	
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
		
		
		
		
		Random ran = new Random();
		int random = ran.nextInt(moves.size());
					
		m_X = moves.get(random)[0];	
		m_Y = moves.get(random)[1];
		
		return true;
	}
	
	private int m_X;
	private int m_Y;
}

