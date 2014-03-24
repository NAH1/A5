import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * \\file -SelectGame.java 
 * \author -Tyrone Bramwell 710981 
 * \date -20th Feb 14
 * 
 * \brief SelectGame, used to select the game which the player wants to play.
 *  Part of the GUI package
 */
public class SelectGame {

	/**
	 * A method to draw GUI for SelectGame.
	 */
	public void Draw() {
		boolean test = false;
		if (test || m_test){
			System.out.println("SelectGame :: Draw() BEGIN");
		}
		m_display = new JFrame("Select Game");
	
		m_display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		m_othello_Button = new JButton("Othello");
	
		m_connectFour_Button = new JButton("Connect Four");
	
		m_content = new JPanel(new GridBagLayout());
	
		GridBagConstraints c = new GridBagConstraints();
	
		m_message_Label = new JLabel("Please Select a Game");
	
		m_message_Label.setFont(m_fontSettings);
	
		c.gridwidth = LBL_MES_WIDTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = LBL_MES_X;
		c.gridy = LBL_MES_Y;
		m_content.add(m_message_Label, c);
	
		c.gridwidth = BTN_WIDTH;
	
		c.gridx = BTN_OTHELLO_X;
		c.gridy = BTN_OTHELLO_Y;
		m_content.add(m_othello_Button, c);
	
		c.gridx = BTN_CONNECT4_X;
		c.gridy = BTN_CONNECT4_Y;
		m_content.add(m_connectFour_Button, c);
	
		guiEventHandler handler = new guiEventHandler();
	
		m_othello_Button.addActionListener(handler);
		m_connectFour_Button.addActionListener(handler);
		m_display.add(m_content);
	
		m_display.pack();
		m_display.setLocationRelativeTo(null);
		m_display.setVisible(true);
		
		if (test || m_test){
			System.out.println("SelectGame :: Draw() END");
		}
	}

	/**
	 * A private class to hold the event listener. The class implements
	 * ActionListener
	 */
	private class guiEventHandler implements ActionListener {
	
		/**
		 * Method to perform events.
		 */
		public void actionPerformed(ActionEvent event) {
			boolean test = false;
			if (test || m_test){
				System.out.println("SelectGame :: actionPerformed() BEGIN");
			}
			if (event.getSource() == m_othello_Button) {
	
				Selection s1 = new Selection(GameController.GameType.OTHELLO);
				m_display.dispose();
				if (test || m_test){
					System.out.println("SelectGame :: actionPerformed() END");
				}
			}
	
			if (event.getSource() == m_connectFour_Button) {
	
				Selection s2 = new Selection(GameController.GameType.CONNECTFOUR);
				m_display.dispose();
				
				if (test || m_test){
					System.out.println("SelectGame :: actionPerformed() END");
				}
			}
		}
	}

	/**
	 * main method to run and test program.
	 */
	public static void main(String[] args) {
		SelectGame sg = new SelectGame();
		sg.Draw();
	}

	/**
	 * Uses the constructor provided by the Object class
	 */

	/**
	 * display is a JFrame for the GUI
	 */
	private JFrame m_display;
	/**
	 * othello_Button is a JButton to select othello game
	 */
	private JButton m_othello_Button;
	/**
	 * connectFour_Button is a JButton to select Connect Four game
	 */
	private JButton m_connectFour_Button;
	/**
	 * content is a JPanel to hold buttons and labels. content will use
	 * GridBagLayout. 
	 * \see http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html 
	 * \see http://docs.oracle.com/javase/7/docs/api/java/awt/GridBagLayout.html 
	 * \see http://www.macs.hw.ac.uk/guidebook/?name=Layouts&page=7 
	 * for more information on GridBagLayout.
	 */
	private JPanel m_content;
	/**
	 * message_Label is JLabel used to tell the player to pick a game
	 */
	private JLabel m_message_Label;
	/**
	 * FONT_SIZE sets the pt size of the font object
	 */
	private final int FONT_SIZE = 15;
	/**
	 * fontSettings is a Font object to store the font settings, 
	 * \see http://docs.oracle.com/javase/7/docs/api/java/awt/Font.html 
	 * for more informatin on Font objects
	 */
	private Font m_fontSettings = new Font("Dialog", Font.PLAIN, FONT_SIZE);

	/**
	 * LBL_MES_WIDTH sets width of message_Label. Using GridBagLayout
	 */
	private final int LBL_MES_WIDTH = 2;
	/**
	 * LBL_MES_X sets position x of message_Label. Using GridBagLayout
	 */
	private final int LBL_MES_X = 0;
	/**
	 * LBL_MES_X sets position y of message_Label. Using GridBagLayout
	 */
	private final int LBL_MES_Y = 0;

	/**
	 * BTN_WIDTH sets width of othello_Button, connectFour_Button. Using
	 * GridBagLayout
	 */
	private final int BTN_WIDTH = 1;
	/**
	 * BTN_OTHELLO_X sets position x of othello_Button. Using GridBagLayout
	 */
	private final int BTN_OTHELLO_X = 0;
	/**
	 * BTN_OTHELLO_Y sets position y of othello_Button. Using GridBagLayout
	 */
	private final int BTN_OTHELLO_Y = 1;
	/**
	 * BTN_CONNECT4_X sets position x of connectFour_Button. Using GridBagLayout
	 */
	private final int BTN_CONNECT4_X = 1;
	/**
	 * BTN_CONNECT4_Y sets position y of connectFour_Button. Using GridBagLayout
	 */
	private final int BTN_CONNECT4_Y = 1;
	
	private boolean m_test=false;
}
