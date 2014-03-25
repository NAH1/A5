/**
 * \\file -OthelloAnimationPoint.java 
 * \author - Ben Golightly
 * 
 * \see OthelloAnimation.java
 * 
 * \brief Simple structure class to hold information about a peice being
 *        animated. Multiple copies of these will be held in a list by
 *        the OthelloAnimation class which may need to animate multiple
 *        peices when capturing.
 * 
 */

public class OthelloAnimationPoint {
	
	public OthelloAnimationPoint(int x, int y, int type, int limit) {
		m_X = x;
		m_Y = y;
		m_Type = type;
		m_Completion = 0;
		m_Limit = limit;
	}
	
	public int frame()
	{
		if (m_Type < 0) {
			return (m_Limit - m_Completion);
		}
		else {
			return m_Completion;
		}
	}
	
	public void sync()
	{
		m_Completion++;
	}
	
	public boolean completed()
	{
		return m_Completion == m_Limit;
	}
	
	private int m_X;     // X location of an animation = new ArrayList<Integer>()
	private int m_Y;     // Y location of an animation
	private int m_Type;  // black to white, or reverse
	private int m_Completion;
	private int m_Limit;
}