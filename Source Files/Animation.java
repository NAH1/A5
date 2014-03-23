import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import boardGame.BoardGame;

/**
 * \\file - Animation.java
 * \author Daniel Squires - 709547
 * \date 18/03/2014
 */
public abstract class Animation extends JPanel {
	/**
	 * Get the JFrame from the GUI
	 * \return the GUI JFrame
	 */
	public JFrame getGUIFrame() {
		return m_GUIFrame;
	}
	
	/**
	 * Set the GUI JFrame 
	 * \param frame - JFrame object to instantiate m_GUIFRame to
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
	 * \param image
	 */
	public void setPiece(Image image) {
		m_piece = image;
	}
	
	/**
	 * 
	 * \return
	 */
	public Image getPiece() {
		return m_piece;
	}
	
	/**
	 * 
	 * \param timer
	 */
	public void setTimer(javax.swing.Timer timer) {
		m_timer = timer;
	}
	
	/**
	 * 
	 * \return
	 */
	public javax.swing.Timer getTimer () {
		return m_timer;
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
	 * Abstract method will be used to draw the piece to the board
	 * \param g - The graphics context
	 */
	protected abstract void drawPiece(Graphics g);
	
	protected class EventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cycle();
			repaint();	
		}
	}

	//Global Vairables
	private Thread m_animatorThread;
	private JFrame m_GUIFrame;
	private int m_xCoord;
	private int m_yCoord;
	private boolean m_run = false;
	private BoardGame m_game;
	private GUI m_gui;
	private Image m_piece;
	private javax.swing.Timer m_timer;
	protected final int INITIAL_X = 100;	//The initial X Coordinate of the Image
    protected final int INITIAL_Y = 2;	//The initial Y Coordinate of the Image
    protected final int WIDTH;		//Width of the gameboard
    protected final int HEIGHT;		//Height of the gameboard
    protected final int DELAY = 5;
    //the initial delay to put the thread to sleep by
}
