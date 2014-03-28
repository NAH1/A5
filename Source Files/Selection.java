import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * \\file -Selection.java
 * \author -Thomas Letheby 
 * \date -25th Feb 14
 * 
 * \see SelectGame.java
 * \see GameController.java
 * \see HumanPlayer.java
 * 
 * \brief Selection class, used to allow the user to select opponent names, opponent types 
 * 
 * The class is a user interface to select name and opponent type
 */
public class Selection implements ActionListener {

	/**
	 * Accessor method to set the current game type 
	 * \param GameType a string for the current game type
	 */
	private void setGameType(GameController.GameType GameType) {
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: setGameType() BEGIN");
		}
		m_CurrentGameType = GameType;
		if (test || m_Test){
			System.out.println("Selection :: setGameType() END");
		}
	}

	/**
	 * Accessor method to get the current game type 
	 * \return currentGameType a String of what the current game type is
	 */
	public GameController.GameType GetGameType() {
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: GetGameType() BEGIN");
		}
		if (test || m_Test){
			System.out.println("Selection :: GetGameType() END");
		}
		return m_CurrentGameType;
		

	}

	/**
	 * The method that sets up and draws the JFrame and its corresponding
	 * elements
	 */
	public void Draw() {
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: Draw() BEGIN");
		}
		/** sets up JFrame */
		m_DisplaySelection = new JFrame();
		m_DisplaySelection.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		m_DisplaySelection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m_DisplaySelection.setTitle("Select Players");
		/**
		 * Sets up the JPanels within the JFrame and set their flow layout to
		 * centre
		 */
		m_BtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		m_SelectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		m_ComboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		/**
		 * Sets up a JComboBox and adds it to the selectPanel JPanel, also adds
		 * the action listener
		 */
		
		m_SelectOpponent.setSelectedIndex(0);
		m_SelectOpponent.addActionListener(this);
		m_ComboPanel.add(m_SelectOpponent);
		/**
		 * sets up the players one and two JTextFields and adds the
		 * actionlistener + mouse listener to both, clears contents currently in
		 * JTextField
		 */
		m_PlayerOne = new JTextField("Player One", FIELD_SIZE);
		m_PlayerTwo = new JTextField("Player Two", FIELD_SIZE);
		/**
		 * Adds the JButtons "Cancel" and "play" and adds the action listeners
		 * to both
		 */
		m_BtnCancel = new JButton("Cancel");
		m_BtnPlay = new JButton("Play");
		m_BtnCancel.addActionListener(this);
		m_BtnPlay.addActionListener(this);

		/** Adds the JButtons "cancel" and "play" to the JPanel btnPanel. */
		m_BtnPanel.add(m_BtnCancel);
		m_BtnPanel.add(m_BtnPlay);
		/***
		 * Adds the JTextFields for player one and player two to the JPanel
		 * selectPanel.
		 */
		m_SelectPanel.add(m_PlayerOne);
		m_SelectPanel.add(m_PlayerTwo);
		m_DisplaySelection.add(m_ComboPanel, BorderLayout.NORTH);
		/** adds the btnPanel to the JFrame and aligns it to SOUTH of frame */
		m_DisplaySelection.add(m_BtnPanel, BorderLayout.SOUTH);
		/** adds the selectPanel to the JFrame and 
		 * sets the JFrame to be visible */
		m_DisplaySelection.add(m_SelectPanel, BorderLayout.CENTER);
		/**
		 * sets the displaySelection JFrame displaySelection to be visible, so
		 * that it can't be resized and to centre the JFrame
		 */
		m_DisplaySelection.setLocationRelativeTo(null);
		m_DisplaySelection.setVisible(true);
		m_DisplaySelection.setResizable(false);
        if (test || m_Test) {
            System.out.println("Selection :: Draw() END");
        }
	}

	/** Sets up the action listeners for the objects needed for Listeners */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m_BtnCancel) {
			new SelectGame();
			m_DisplaySelection.dispose();
		} else if (e.getSource() == m_BtnPlay) {
			Color color1;
			Color color2;
			GameController controller;
			if (GetGameType() == GameController.GameType.OTHELLO) {
				color1 = Color.BLACK;
				color2 = Color.WHITE;
			} else {
				color1 = Color.RED;
				color2 = Color.YELLOW;
			}
			
			Player player1 = new HumanPlayer(m_PlayerOne.getText(), color1);
			Player player2 = null;
			if (m_SelectOpponent.getSelectedItem().equals("Human")) {
				player2 = new HumanPlayer(m_PlayerTwo.getText(), color2);
			} else if (m_SelectOpponent.getSelectedItem().equals("Easy AI")) {
				player2 = new AIEasy(m_PlayerTwo.getText(), color2);
			} else if (m_SelectOpponent.getSelectedItem().equals("Hard AI")) {
				player2 = new AIHard(m_PlayerTwo.getText(), color2);
			}
			
			controller = new GameController(m_CurrentGameType, player1, player2);
			player2.SetBoard(controller.GetBoard());
			m_DisplaySelection.dispose();
		}
		
	}
	/**
	 * Constructor of Selection, receives the type of game, ready for later.
	 * \param chosenGame An enumerator indicating which game type was chosen.
	 */
	public Selection(GameController.GameType chosenGame) {
		boolean test = false;
		m_SelectOpponent = new JComboBox<String>(m_OpponentList);
		if (test || m_Test){
			System.out.println("Selection :: Selection() BEGIN");
		}
		setGameType(chosenGame);
		Draw();
	}	
	
	public static void main(String args[]) {
		new Selection(GameController.GameType.CONNECTFOUR);
	}

	/** The JFrame name for displaying. */
	private JFrame m_DisplaySelection;
	/** value for the display frame width */
	private final int FRAME_WIDTH = 300;
	/** value for the display frame Height */
	private final int FRAME_HEIGHT = 135;

	/** The Panels to keep all elements on in the JFrame */
	private JPanel m_BtnPanel, m_SelectPanel, m_ComboPanel;

	/** The JComboBox */
	private final JComboBox<String> m_SelectOpponent;
	/** The list of values for the JComboBox */
	private String[] m_OpponentList = { "Human", "Easy AI", "Hard AI" };
	/** The JButtons used in the display */
	private JButton m_BtnCancel, m_BtnPlay;
	/** The JTextFields used in the display */
	private JTextField m_PlayerOne, m_PlayerTwo;

	/** Number of character spaces in JTextField */
	private final int FIELD_SIZE = 10;
	/** Variable used to turn testing on or off*/
	private boolean m_Test = false;
	/** Stores the game type that is passed through from SelectGame.java */
	private GameController.GameType m_CurrentGameType;
}
