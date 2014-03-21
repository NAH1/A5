import java.awt.Graphics;

import javax.swing.JFrame;

import boardGame.BoardGame;

/**
 * \\file - Animation.java
 * \author Daniel Squires - 709547
 * \date 18/03/2014
 */
public abstract class Animation implements Runnable {
	/**
	 * 
	 * \return
	 */
	public JFrame getGUIFrame() {
		return m_GUIFrame;
	}
	
	/**
	 * 
	 * \param frame - 
	 */
	public void setGUIFrame(JFrame frame) {
		m_GUIFrame = frame;
	}
	
	/**
	 * 
	 * \return
	 */
	public int getYCoord() {
		return m_yCoord;
	}
	
	/**
	 * 
	 * \param coord - 
	 */
	public void setYCoord(int coord) {
		m_yCoord = coord;
	}
	
	/**
	 * 
	 * \return
	 */
	public int getXCoord() {
		return m_xCoord;
	}
	
	/**
	 * 
	 * \param coord
	 */
	public void setXCoord(int coord) {
		m_xCoord = coord;
	}
	
	/**
	 * 
	 * \return
	 */
	public Thread getAnimatorThread() {
		return m_animatorThread;
	}
	
	/**
	 * 
	 * \param thread - 
	 */
	public void setAnimatorThread(Thread thread) {
		m_animatorThread = thread;
	}
	
	/**
	 * 
	 * \return
	 */
	public boolean getRunBool() {
		return m_run;
	}
	
	/**
	 * 
	 * \param bool - 
	 */
	public void setRunBool(boolean bool) {
		m_run = bool;
	}
	
	/**
	 * 
	 * \return
	 */
	public BoardGame getGame () {
		return m_game;
	}
	
	/**
	 * 
	 * \param game - 
	 */
	public void setGame (BoardGame game) {
		m_game = game;
	}
	
	/**
	 * 
	 * \return
	 */
	public GUI getGUI() {
		return m_gui;
	}
	
	public void setGUI (GUI gui) {
		m_gui = gui;
	}
	
	/**
	 * 
	 */	
	/*
	public void addNotify() {
		getGUIFrame().addNotify();
		
		Thread thread = new Thread(this);
		setAnimatorThread(thread);
		getAnimatorThread().start();
	}
	*/
	
	/**
	 * 
	 * \param frame
	 */
	public Animation(JFrame frame, BoardGame game, GUI gui) {
		setGUIFrame(frame);
		setGame(game);
		setGUI(gui);
		WIDTH = getGUI().m_width;
		HEIGHT = getGUI().m_height;
	}
	
	/**
	 * This abstract method will be used to update GUI coordinates
	 */
	protected abstract void cycle();
	
	/**
	 * 
	 * \param g
	 */
	public abstract void paintComponent(Graphics g);
	
	/**
	 * 
	 * \param g
	 */
	protected abstract void drawPiece(Graphics g);
	
	/**
	 * Abstractly define the run method to force subclasses to implement
	 */
	@Override
	public abstract void run();

	//Global Vairables
	private Thread m_animatorThread;
	private JFrame m_GUIFrame;
	private int m_xCoord;
	private int m_yCoord;
	private boolean m_run = true;
	private BoardGame m_game;
	private GUI m_gui;
	protected final int INITIAL_X = 3;	//The initial X Coordinate of the Image
    protected final int INITIAL_Y = 2;	//The initial Y Coordinate of the Image
    protected final int WIDTH;		//Width of the gameboard
    protected final int HEIGHT;		//Height of the gameboard
    protected final int DELAY = 15;	
    //the initial delay to put the thread to sleep by
}
