package piece;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * \\file -ConnectFourPiece.java
 * \author -Gavin Bailey 711036
 * \date -24th Feb 14
 * 
 * \brief Connect Four game piece used in a game of Connect Four,extends GamePiece.java
 * 
 * This is an extension of the GamePiece class, where the icons
 * differ from other piece types.
 */

public class ConnectFourPiece extends GamePiece {
    
    /**
     * Constructor of ConnectFourPiece, calls  setColour() and setIcons()
     * \param col a String to set colour using setColour() of the superclass
     */
    public ConnectFourPiece(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: ConnectFourPiece() BEGIN");
        }
        
        if (col.equals(m_red) || col.equals(m_yellow)) {
            SetColour(col);
            m_iconsSet = SetIcons();
        } else {
            System.out.println("Invalid Colours");
        }
        
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: ConnectFourPiece() END");
        }
    }
    
    /**
     * Accessor method to retrieve the ImageIcon of the piece
     * \return Icon depending on piece colour
     */
    public Icon GetIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: getIcon() BEGIN");
        }
        
        if (m_iconsSet) {
            if (GetColour().equals(m_yellow)) {
                if (test || m_test) {
                    System.out.println("ConnectFourPiece :: getIcon() END");
                }
                
                return m_yellowpiece;
            } else if (GetColour().equals(m_red)){
                if (test || m_test) {
                    System.out.println("ConnectFourPiece :: getIcon() END");
                }
                
                return m_redpiece;
            }
        }
        return null;
    }
    
    /**
     * Accessor method to set the ImageIcons of a piece
     * \return boolean on success
     * \throws NullPointerException
     */
    public boolean SetIcons() throws NullPointerException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: setIcons() BEGIN");
        }
        
        String yellowImageURL = "yellow.png";
        String redImageURL = "red.png";
        
        try {
            m_yellowpiece = new ImageIcon(getClass()
                                    .getResource(yellowImageURL));
            m_redpiece = new ImageIcon(getClass().getResource(redImageURL));
            
            if (test || m_test) {
                System.out.println("ConnectFourPiece :: setIcons() END");
            }
            
            return true;
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
            System.out.println("ConnectFourPiece :: setIcons() END");
        }
        return false;
        
    }
    
    /** main method for tests */
    public static void main(String[] args) {
        ConnectFourPiece a = new ConnectFourPiece("red");
        a.GetIcon();
        a.SetIcons();
        a.GetColour();
        
        ConnectFourPiece b = new ConnectFourPiece("123");
        b.GetIcon();
        b.SetIcons();
        b.GetColour();
    }
    
    // variable declarations
    /** flag for setting icons */
    private boolean m_iconsSet = false;
    /** Colour Strings */
    private final String m_red = "red";
    private final String m_yellow = "yellow";
    /** store the yellow icon */
    private Icon m_yellowpiece;
    /** store the red icon */
    private Icon m_redpiece;
    /** Indicates whether to run tests */
    private boolean m_test = false;
}