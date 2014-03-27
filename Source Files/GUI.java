import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import piece.GamePiece;
import piece.OthelloPiece;

/**
 * \\file -GUI.java 
 * \author - Jake Daryl Plumley
 * \date -24th Feb 14
 * 
 * \see BoardGame.java
 * \see GameController.java
 * \see OthelloGUI.java
 * \see Connect4GUI.java
 * 
 * \brief GUI is used to set up and update the display for game board and the information. 
 * 
 */
public abstract class GUI extends JFrame {

	 /**
     * Get the game controller object.
     * \return GameController  return the game controller object.
     */
	public GameController GetGame() {
		return m_game;
	}

	 /**
     * Get the board game object.
     * \return BoardGame  return the board game object which is either 
     * connect4 or othello.
     */
	public BoardGame GetBoard() {
		return m_board;
	}

	public JFrame GetFrame() {
		return FRAME;
	}
	
	 /**
     * Get the squares of the game board.
     * \return JPanel[][]  return the two dimensional array in the game panel.
     */
	public JPanel[][] GetPanel() {
		return m_panels;
	}
	
	public JPanel GetPanel(int x, int y) {
		return m_panels[x][y];
	}
	
	public boolean SetPanel(int x, int y, JPanel panel) {
		m_panels[x][y] = panel;
		return true;
	}
	
	public JLabel GetLabel(int x, int y) {
		return m_labels[x][y];
	}
	
	public boolean SetLabel(int x, int y, JLabel label) {
		m_labels[x][y] = label;
		return true;
	}
	
	public Clock getClock() {
		return m_clock;
	}
	
	public boolean setClock(Clock clock) {
		m_clock = clock;
		return true;
	}
	
	public abstract boolean setPanelColour();
	
	public abstract boolean setInfo();

    /**
    * Constructor of GUI, construct the game board and sets the player 
    * information.
    * \param a BoardGame object , a GameController object.
    */
	public GUI(BoardGame b, GameController g) {
		
		FRAME = new JFrame("Game");
		m_board = b;
		m_game = g;
		WIDTH = GetBoard().GetWidth();
		HEIGHT = GetBoard().GetHeight();
		m_panels = new JPanel[WIDTH][HEIGHT];
		m_labels = new JLabel[WIDTH][HEIGHT];
		ICON = new ImageIcon(getClass().getResource(ICON_URL));
		PASSMOVE = new JButton("Pass");
		NEWGAME = new JButton("New Game");
		SAVEGAME = new JButton("Save Game");
		draw();

		m_clock = new Clock(this, 0);
	}
	
	/**
     * Update the piece icon of the current player.
     * \return boolean  return true if the action completes.
     */
	public boolean UpdatePlayerTurnIcon(Icon picon) {
		m_playerTurnIcon.setIcon(picon);
		return true;
	}
	
	/**
     * Draw the main frame which includes the game panel and the info panel.
     */
	private void draw() {
		final int PADX = 15;
		GUIHandler handler = new GUIHandler();
		JPanel infoPanel = DrawInfoPanel(handler);
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = PADX;
	
		JPanel gamePanel = new JPanel(new GridLayout(HEIGHT, WIDTH));
		mainPanel.add(gamePanel, c);
	
		
		for (int y = 0; y < HEIGHT; ++y) {
			for (int x = 0; x < WIDTH; ++x) {
				SetPanel(x, y, new JPanel());
				GetPanel(x, y).setPreferredSize(new Dimension(70, 70));
				SetLabel(x, y, new JLabel());
				GetPanel(x, y).addMouseListener(handler);
				gamePanel.add(GetPanel(x, y));
			}
		}
	
		FRAME.add(mainPanel, BorderLayout.WEST);
		FRAME.add(infoPanel, BorderLayout.EAST);
	
		FRAME.pack();
		FRAME.setLocationRelativeTo(null);
		FRAME.setVisible(true);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JPanel DrawInfoPanel(GUIHandler handler) {
		JPanel infoPanel = new JPanel(new GridLayout(7, 2));
		m_playerOneColor = new JLabel();
		m_playerOneColor.setVisible(false);
		infoPanel.add(m_playerOneColor);
		// playerOneColor.setVisible(true);
		m_playerOneIcon = new JLabel();
		infoPanel.add(m_playerOneIcon);
		m_playerOneIcon.setVisible(false);
		m_playerTwoColor = new JLabel();
		m_playerTwoColor.setVisible(false);
		infoPanel.add(m_playerTwoColor);
		// playerOneIcon.setVisible(true);
		m_playerTwoIcon = new JLabel();
		m_playerTwoIcon.setVisible(false);
		infoPanel.add(m_playerTwoIcon);
		m_playerTurnIcon = new JLabel();
		m_playerTurnIcon.setVisible(false);
		infoPanel.add(m_playerTurnIcon);
		m_playerTurnLabel = new JLabel();
		m_playerTurnLabel.setVisible(false);
		infoPanel.add(m_playerTurnLabel);
		// JLabel whiteIcon = new JLabel();
		m_blackIcon = new JLabel();
		m_blackIcon.setVisible(false);
		infoPanel.add(m_blackIcon);
		m_blackPieces = new JLabel();
		m_blackPieces.setVisible(false);
		infoPanel.add(m_blackPieces);
		m_whiteIcon = new JLabel();
		m_whiteIcon.setVisible(false);
		infoPanel.add(m_whiteIcon);
		m_whitePieces = new JLabel();
		m_whitePieces.setVisible(false);
		infoPanel.add(m_whitePieces);
		infoPanel.add(NEWGAME);
		NEWGAME.setVisible(true);
		infoPanel.add(PASSMOVE);
		PASSMOVE.setVisible(false);
		infoPanel.add(SAVEGAME);

		m_timerLabel = new JLabel("Time Elapsed:");
		infoPanel.add(m_timerLabel);
		
		PASSMOVE.addActionListener(handler);
		NEWGAME.addActionListener(handler);
		SAVEGAME.addActionListener(handler);
		return infoPanel;
	}
	
	public boolean SetTime(String time) {
		m_timerLabel.setText("Time Elapsed: " + time);
		return true;
	}

		 /**
     * Draw the pieces to be displayed on the JFrame.
     */
	public void DrawPieces() {
		for (int y = 0; y < HEIGHT; ++y) {
			for (int x = 0; x < WIDTH; ++x) {
				GamePiece p = GetBoard().GetPiece(x, y);
	
				if (p != null) {
					GetLabel(x, y).setIcon(p.GetIcon());
					GetPanel(x, y).removeAll();
				}
				GetPanel(x, y).add(GetLabel(x, y));
			}
		}
		SwingUtilities.updateComponentTreeUI(FRAME);
	}

	/** These methods had to be declared as MouseListener is abstract. 
	 * Detect mouse action and button click to pass the information to the 
	 * BoardGame and GameController class.
	 */
	private class GUIHandler extends MouseAdapter implements ActionListener {
		
		public void mouseClicked(MouseEvent e) {
			if(GetGame().GetGamOn()) {
				playerMove(e);
				if (GetGame().GetCurrent().isAI() && GetGame().GetGamOn()) {
					AIMove();
				}
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == PASSMOVE) {
				if (GetGame().GetGamOn()) {
					if (((Othello) GetBoard()).CheckPassTurn()) {
					if (((Othello) GetBoard()).AnyValidMoveForAnyone()) {
					GetGame().Alternate();
					UpdatePlayerTurnIcon(new OthelloPiece(
					GetGame().GetCurrent().GetPieceColour()).GetIcon());
					} else {
					ShowWinningBox();
					}
						
					}
				}
			}
	
			if (e.getSource() == NEWGAME) {
				m_clock.stop();
				SelectGame sg = new SelectGame();
				sg.Draw();
				FRAME.dispose();
			}
			
			if (e.getSource() == SAVEGAME) {
				if (GetGame().GetGamOn()) {
					new SaveManager(GetGame());
				}
				
			}
		}
		
		private void playerMove(MouseEvent e) {
			boolean moveComplete = false;
			for (int y = 0; y < HEIGHT; y++) {
				for (int x = 0; x < WIDTH; ++x) {
					if (e.getSource() == GetPanel()[x][y]) {
						moveComplete = GetBoard().Move(x, y,
								GetGame().GetCurrent().GetPieceColour());
					}
				}
			}
			if (moveComplete) {
				GetGame().Alternate();
				DrawPieces();
				if (GetGame().CheckWin()) {
					ShowWinningBox();
				}
				// System.out.println(GetBoard().toString());
			}
		}
		
		private void AIMove() {
			boolean moveComplete = false;
			Player player = GetGame().GetCurrent();
			player.takeMove();
			moveComplete = GetBoard().Move(player.getX(), player.getY(), player.GetPieceColour());
			if (moveComplete) {
				GetGame().Alternate();
				DrawPieces();
				if (GetGame().CheckWin()) {
					ShowWinningBox();
				}
				// System.out.println(GetBoard().toString());
			}
		}
	}

	 /**
     * Show a dialog box of the game result when the game ends.
     */
	public void ShowWinningBox() {
		m_clock.stop();
		if (GetBoard().GetWinningColour() == null) {
			JOptionPane.showMessageDialog(FRAME, "GAME DRAWN", "Draw",
					JOptionPane.OK_OPTION, ICON);
		} else {
			m_board.HighlightWinners(m_panels, GetBoard().GetWinningColour());
			JOptionPane.showMessageDialog(FRAME,
					GetGame().GetPlayerName(GetBoard().GetWinningColour())
					+ "   WINS!!!!", "Winner", JOptionPane.OK_OPTION,
					ICON);
		}
	}
	final int FSIZE = 15;
	/**Setting the default font face*/
	protected final Font FONT = new Font("Dialog", Font.PLAIN, FSIZE);
	/**Setting up all of the JLabels for the GUI*/
	protected JLabel m_playerOneColor, m_playerOneIcon, m_playerTwoColor,
	                 m_playerTwoIcon, m_playerTurnIcon, m_playerTurnLabel, m_whiteIcon,
	                 m_whitePieces, m_blackIcon, m_blackPieces, m_timerLabel;
	/**The gameBoard*/
	protected BoardGame m_board;
	/**setting up the GameController to interact with for each game*/
	protected GameController m_game;
	/**The panel to display the board*/
	protected JPanel[][] m_panels;
	/**The width of the gameboard*/
	protected final int WIDTH;
	/**The height of the gameboard*/
	protected final int HEIGHT;
	/**An array of labels to set the piece upon*/
	protected JLabel[][] m_labels;
	/**The JFrame to display the board*/
	protected final JFrame FRAME;
	/**The pass move button*/
	protected final JButton PASSMOVE;
	/**The new game button*/
	private final JButton NEWGAME;
	/**The save game button*/
	private final JButton SAVEGAME;
	/**The Icon on which the piece is equal to*/
	private final Icon ICON;
	/**The image location for the initial image on the gameboard*/
	private String ICON_URL = "icon.png";

	private Clock m_clock;
}
