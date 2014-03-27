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
	 * Accessor method to set the player ones name 
	 * \param playerName a String for the players name
	 */
	private void setPlayerNameOne(String playerName) {
		
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: setPlayerNameOne() BEGIN");
		}
		
		m_p1Text = playerName;
		
		if (test || m_Test){
			System.out.println("Selection :: setPlayerNameOne() END");
		}
	}

	/**
	 * Accessor method to set the player twos name 
	 * \param playerName a String for the players name
	 */
	private void setPlayerNameTwo(String playerName) {
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: setPlayerNameTwo() BEGIN");
		}
		
		m_p2Text = playerName;
		
		if (test || m_Test){
			System.out.println("Selection :: setPlayerNameTwo() END");
		}
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
		m_SelectOpponent = new JComboBox(m_OpponentList);
		m_SelectOpponent.setSelectedIndex(0);
		m_SelectOpponent.addActionListener(this);
		m_ComboPanel.add(m_SelectOpponent);
		/**
		 * sets up the players one and two JTextFields and adds the
		 * actionlistener + mouse listener to both, clears contents currently in
		 * JTextField
		 */
		m_PlayerOne = new JTextField("Player One Name:", FIELD_SIZE);
		m_PlayerTwo = new JTextField("Player Two Name:", FIELD_SIZE);
		m_PlayerOne.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				m_PlayerOne.setText("");
			}
		});
		m_PlayerTwo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				m_PlayerTwo.setText("");
			}
		});
		/**
		 * Adds the JButtons "Cancel" and "play" and adds the action listeners
		 * to both
		 */
		m_BtnCancel = new JButton("Cancel");
		m_BtnPlay = new JButton("Play");
		m_BtnCancel.addActionListener(this);
		m_BtnPlay.addActionListener(this);

		/** Adds the JButtons "cancel" and "play" to the JPanel btnPanel. */
		m_BtnPanel.add(m_BtnCancel); m_BtnPanel.add(m_BtnPlay);
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
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: actionPerformed() BEGIN");
		}
		
		if (e.getSource() == m_BtnCancel) {
			/** Closes the JFrame completely when button is performed.
			 * Creates a new SelectGame * */
			
			SelectGame s = new SelectGame();
			s.Draw();
			m_DisplaySelection.dispose();
			
			if (test || m_Test){
				System.out.println("Selection :: actionPerformed() END");
			}
		}

		/** This if statement implements a action listener for the JComboBox */
		if (e.getSource() == m_SelectOpponent) {
			/** Setting opponent type to Human or AI */
			m_OpponentType = (String) m_SelectOpponent.getSelectedItem();
			
			if (test || m_Test){
				System.out.println("Selection :: actionPerformed() END");
			}
		}

		/**
		 * The if statement implements a action listener for the JButton
		 * btn_play
		 */
		if (e.getSource() == m_BtnPlay) {
			/** setting the Player one name to what is 
			 * typed into the text field */
			if (m_PlayerOne.getText().length() <= 20) {
				if(m_PlayerOne.getText().equals(""))
					setPlayerNameOne(m_p1Text);
				else
					setPlayerNameOne(m_PlayerOne.getText());
			} else {
				JOptionPane
						.showMessageDialog(null,
								"The name of player one exceeds the limit " +
								"of 20 characters.");
				setPlayerNameOne(m_PlayerOne.getText().substring(0, 20));
			}
			/** setting the Player two name to what is typed 
			 * into the text field */
			if (m_PlayerTwo.getText().length() <= 20) {
				if(m_PlayerTwo.getText().equals(""))
					setPlayerNameTwo(m_p2Text);
				else
					setPlayerNameTwo(m_PlayerTwo.getText());
			} else {
				JOptionPane
						.showMessageDialog(null,
								"The name of player two exceeds the limit of " +
								"20 characters. ");
				setPlayerNameTwo(m_PlayerTwo.getText().substring(0, 20));
			}
			/** this if statement checks if the chosenGame is Othello */
			if (m_CurrentGameType == GameController.GameType.OTHELLO) {
				/** then the first human player is set to the 
				 * piece colour black */
				HumanPlayer HuPlay = new HumanPlayer(m_p1Text, Color.BLACK);

				/**
				 * this if statement checks if the opponentType is a Human
				 * player
				 */
				if (m_OpponentType.equals("Human")) {
					/**
					 * then the second human player is set to the piece colour
					 * white
					 */
					HumanPlayer HuPlayOpponent = new HumanPlayer(m_p2Text,
							Color.WHITE);
					/** closes the JFrame displaySelection entirely */

					/** creates a new gameController object */
					GameController gameCont = new GameController(
							GameController.GameType.OTHELLO, HuPlay, HuPlayOpponent);
					m_DisplaySelection.dispose();
				} else {
					/**
					 * displaySelections a error message dialog box, explaining
					 * that AI can't be played in current version
					 */
					JOptionPane.showMessageDialog(null,
							"AI not available in this version.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				if (test || m_Test){
					System.out.println("Selection :: actionPerformed() END");
				}
			}

			/**
			 * this else if statement checks whether the chosen game is Connect
			 * Four
			 */
			else if (m_CurrentGameType == GameController.GameType.CONNECTFOUR){
				/** then the first human player is set to the piece colour red*/
				HumanPlayer HuPlay = new HumanPlayer(m_p1Text, Color.RED);

				/**
				 * this if statement checks if the opponentType is a human
				 * player
				 */
				if (m_OpponentType.equals("Human")) {
					/**
					 * then the second human player is set to the piece colour
					 * yellow
					 */
					HumanPlayer HuPlayOpponent = new HumanPlayer(m_p2Text,
							Color.YELLOW);
					/** closes the JFrame displaySelection entirely */
					m_DisplaySelection.dispose();
					/** creates a new gameController object */
					GameController gameCont = new GameController(
							GameController.GameType.CONNECTFOUR, HuPlay, HuPlayOpponent);
					
					if (test || m_Test){
						System.out.println("Selection :: actionPerformed() END");
					}
					
				} else {
					/**
					 * displaySelections a error message dialog box, explaining
					 * that AI can't be played in current version
					 */
					JOptionPane.showMessageDialog(null,
							"AI not available in this version.", "Error",
							JOptionPane.ERROR_MESSAGE);
					
					if (test || m_Test){
						System.out.println("Selection :: actionPerformed() END");
					}
					
				}
				
				if (test || m_Test){
					System.out.println("Selection :: actionPerformed() END");
				}
			}
		}
	}
	
	/**
	 * Constructor of Selection, receives the type of game, ready for later.
	 * \param chosenGame a String for the chosen game.
	 */
	public Selection(GameController.GameType chosenGame) {
		boolean test = false;
		if (test || m_Test){
			System.out.println("Selection :: Selection() BEGIN");
		}
		setGameType(chosenGame);
		if (chosenGame == GameController.GameType.OTHELLO
				|| chosenGame == GameController.GameType.CONNECTFOUR)
			setGameType(chosenGame);
		else
			System.err
					.println("Selection::Selection() can only be Othello " +
							"or ConnectFour.");
		Draw();
		if (test || m_Test){
			System.out.println("Selection :: Selection() END");
		}
	}	
	
	public static void main(String args[]) {

		Selection select = new Selection(GameController.GameType.CONNECTFOUR);
		
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
	private JComboBox m_SelectOpponent;
	/** The list of values for the JComboBox */
	private String[] m_OpponentList = { "Human", "AI" };
	/**
	 * Initialising the opponent type in case the player doesn's select an
	 * option from the JComboBox
	 */
	private String m_OpponentType = "Human";


	/** The JButtons used in the display */
	private JButton m_BtnCancel, m_BtnPlay;
	/** The JTextFields used in the display */
	private JTextField m_PlayerOne, m_PlayerTwo;

	/** Number of character spaces in JTextField */
	private final int FIELD_SIZE = 10;
	/**
	 * Initialising text to pass as parameter if user doesn't change the value
	 * in JTextField
	 */
	private String m_p1Text = "playerOne";
	/**
	 * Initialising text to pass as parameter if user doesn't change the value
	 * in JTextField
	 */
	private String m_p2Text = "playerTwo";
	/** Variable used to turn testing on or off*/
	private boolean m_Test = false;
	/** Stores the game type that is passed through from SelectGame.java */
	private GameController.GameType m_CurrentGameType;
}
