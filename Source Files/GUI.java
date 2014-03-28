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
     * \return Returns the game controller object.
     */
	public GameController GetGame() {
		return m_game;
	}

	 /**
     * Get the board game object.
     * \return Returns the board game object which is either 
     * connect4 or othello.
     */
	public BoardGame GetBoard() {
		return m_board;
	}

	/**
	 * Retrieves the JFrame which contains the game.
	 * \return The JFrame containing the GUI inteface.
	 */
	public JFrame GetFrame() {
		return FRAME;
	}
	
	 /**
     * Retrieves a grid of JPanels which are used to display the
     * game board.
     * \return Returns a two dimensional array of JPanels 
     */
	public JPanel[][] GetPanel() {
		return m_panels;
	}
	
	/**
	 * Retrieves a specific JPanel corresponding to the indicated
	 * grid position in the game.
	 * \param x The X coordinate of the grid position corresponding
	 * to the JPanel required
	 * \param y The Y coordinate of the grid position corresponding
	 * to the JPanel required
	 * \return Returns the JPanel
	 */
	public JPanel GetPanel(int x, int y) {
		return m_panels[x][y];
	}
	
	/**
	 * Sets the specific JPanel corresponding to the indicated grid
	 * position in the game.
	 * \param x The X coordinate of the grid position
	 * \param y The Y coordinate of the grid positioln
	 * \param panel The new JPanel that is being saved into the
	 * indicated grid position
	 * \return Returns TRUE if successful
	 */
	public boolean SetPanel(int x, int y, JPanel panel) {
		m_panels[x][y] = panel;
		return true;
	}
	
	/**
	 * Retrieves the specific JLabel corresponding to the indicated
	 * grid position in the game. The JLabel contains the icon image
	 * of a piece on the game board.
	 * \param x The X coordinate of the grid position
	 * \param y The Y coordinate of the grid position
	 * \return Returns the JLabel
	 */
	public JLabel GetLabel(int x, int y) {
		return m_labels[x][y];
	}
	
	/**
	 * Sets the specific JLabel corresponding to the indicated grid
	 * position in the game. The JLabel contains the icon image of
	 * a piece on the game board.
	 * \param x The X coordinate of the grid position
	 * \param y The Y coordinate of the grid position
	 * \param label The new JLabel that is being saved into the
	 * indicated grid position
	 * \return Returns TRUE if successful
	 */
	public boolean SetLabel(int x, int y, JLabel label) {
		m_labels[x][y] = label;
		return true;
	}
	
	/**
	 * Retrieves the clock class which displays and keeps track of
	 * the duration of the game.
	 * \return The Clock class currently recording game duration
	 */
	public Clock getClock() {
		return m_clock;
	}
	
	/**
	 * Sets the clock class which is to be used to display and keep
	 * track of the duration of the game.
	 * \param clock The new clock class which is to be used to
	 * record the time.
	 * \return Returns TRUE if successful.
	 */
	public boolean setClock(Clock clock) {
		m_clock = clock;
		return true;
	}
	
	/**
	 * An abstract class that is called at initialisation and is used
	 * to display the background grid on the game board GUI.
	 * \return Returns TRUE if successful.
	 */
	public abstract boolean setPanelColour();
	
	/**
	 * An abstract class that is called at initialisation and is used
	 * to set the user and game information that is to be displayed in
	 * the info panel.
	 * \return Returns TRUE if successful.
	 */
	public abstract boolean setInfo();

	/**
	 * Constructor class which initialises and draws the JFrame containing
	 * the GUI interface of the game.
	 * \param b The BoardGame class which this GUI will display data from.
	 * \param g The GameController class which this GUI will display data
	 * from.
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
	 * Sets the Icon which indicates who's player turn it is.
	 * \param picon The Icon which is to be displayed.
	 * \return Returns TRUE if successful.
	 */
	public boolean UpdatePlayerTurnIcon(Icon picon) {
		m_playerTurnIcon.setIcon(picon);
		return true;
	}
	
	/**
	 * Draws the individual GUI elements within the JFrame.
	 */
	private void draw() {
		final int PADX = 15;
		final int X_DIMENSION = 70;
		final int Y_DIMENSION = 70;
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
				GetPanel(x, y).setPreferredSize(new Dimension(X_DIMENSION,
						Y_DIMENSION));
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
	
	/**
	 * Draws the sidebar panel which displays the game's data.
	 * \param handler The GUIHandler which deals with the GUIs buttons.
	 * \return Returns the completed sidebar JPanel.
	 */
	private JPanel DrawInfoPanel(GUIHandler handler) {
		final int ROWS = 7;
		final int COLUMNS = 2;
		JPanel infoPanel = new JPanel(new GridLayout(ROWS, COLUMNS));
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
	
	/**
	 * Method used to update and set the JLabel displaying the
	 * duration of the game to the user.
	 * \param time The time in a String format of HH:MM:SS to
	 * be displayed to the user.
	 * \return Returns TRUE if successful.
	 */
	public boolean SetTime(String time) {
		m_timerLabel.setText("Time Elapsed: " + time);
		return true;
	}

	/**
	 * Draws and updates the graphical game board with the placed pieces.
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

	/**
	 * 
	 * \author Gavin Tsang
	 *
	 * \brief This class is used by the main JFrame to provide methods for
	 * the buttons to call.
	 * 
	 * This class contains methods used by the JFrame. Any user interaction
	 * between the GUI get's sent to this class which then processes the action
	 * and passes the input to the correct subsystem within the game.
	 */
	private class GUIHandler extends MouseAdapter implements ActionListener {
		
		/**
		 * This method is called whenever the user clicks on the game board
		 * in order to place a piece down. If player 2 is an AI player, player
		 * 2 will then take a move.
		 */
		public void mouseClicked(MouseEvent e) {
			if(GetGame().GetGamOn()) {
				playerMove(e);
				if (GetGame().GetCurrent().isAI() && GetGame().GetGamOn()) {
					AIMove();
				}
			}
		}
		
		/**
		 * Provides interaction between the pass, new game and save game buttons
		 * within the GUI.
		 */
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
					JOptionPane.showMessageDialog(
							FRAME, 
							"Game has been Saved", 
							"SaveGame", 
							JOptionPane.INFORMATION_MESSAGE
							);
				}
				
			}
		}
		
		/**
		 * This method is called whenever it is a human player's turn.
		 * It processes the mouse click and passes the move into the game
		 * logic to be validated and saved.
		 * \param e The mouseEvent indicating the mouse move.
		 */
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
			} else {
				JOptionPane.showMessageDialog(
						FRAME, 
						"Invalid move was performed", 
						"Invalid move", 
						JOptionPane.ERROR_MESSAGE
						);
			}
		}
		
		/**
		 * This method is called whenever it is an AI player's turn.
		 * It calls the correct AI logic process which provides a move
		 * before being sent to game logic to be validated and saved.
		 */
		private void AIMove() {
			boolean moveComplete = false;
			Player player = GetGame().GetCurrent();
			player.takeMove();
			moveComplete = GetBoard().Move(player.getX(), player.getY(),
					player.GetPieceColour());
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
     * Shows a dialog box of the game result when the game ends.
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
	                 m_playerTwoIcon, m_playerTurnIcon, m_playerTurnLabel, 
	                 m_whiteIcon,m_whitePieces, m_blackIcon, m_blackPieces,
	                 m_timerLabel;
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
