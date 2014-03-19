package piece;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * \\file   -OthelloPiece.java
 * \author -Tyrone Bramwell
 * \date   -24th Feb 14
 * 
 * \brief Othello game piece used in a game of Othello,
 * extends GamePiece.java
 * 
 * This is an extension of the GamePiece class, where the icons
 * differ from other piece types.
 */
public class OthelloPiece extends GamePiece{
    
    /**
     * Constructor of OthelloPiece, calls  setColour() and setIcons()
     * \param col a String to set colour using setColour() of the superclass
     */
    public OthelloPiece(String col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() BEGIN");
        }
        
        if (col.equals(m_white) || col.equals(m_black)) {
            SetColour(col);
            m_iconsSet = SetIcons();
        } else {
            System.out.println("Invalid Colours");
        }
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: OthelloPiece() END");
        }
    }
    
    /**
     * Accessor method to retrieve the ImageIcon of the piece
     * \return Icon depending on piece colour
     */
    public Icon GetIcon() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: getIcon() BEGIN");
        }
        if (m_iconsSet) {
            if (GetColour().equals("black")) {
                if (test || m_test) {
                    System.out.println("OthelloPiece :: getIcon() END");
                }
                
                return m_blackpiece;
            } else {
                if (test || m_test) {
                    System.out.println("OthelloPiece :: getIcon() END");
                }
                
                return m_whitepiece;
            }
        }
        return null;
    }
    
    /**
     * Accessor method to set the ImageIcons of a piece
     * \return boolean on success
     * \throws NullPointerException
     */
    public boolean SetIcons()  throws NullPointerException {
        boolean test = false;
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() BEGIN");
        }
        
        String blackImageURL = "black.png";
        String whiteImageURL = "white.png";
        
        try {
            m_blackpiece = new ImageIcon(getClass().getResource(blackImageURL));
            m_whitepiece = new ImageIcon(getClass().getResource(whiteImageURL));
            
            if (test || m_test) {
                System.out.println("OthelloPiece :: setIcons() END");
            }
            
            return true;
        } catch (NullPointerException e) {
            System.out.println("Images Not Found");
        }
        
        if (test || m_test) {
            System.out.println("OthelloPiece :: setIcons() END");
        }
        
        return false;
    }
    
    /** main method for tests */
    public static void main(String[] args) {
        OthelloPiece a = new OthelloPiece("white");
        a.GetIcon();
        a.SetIcons();
        a.GetColour();
        
        OthelloPiece b = new OthelloPiece("123");
        b.GetIcon();
        b.SetIcons();
        b.GetColour();
    }
    
    //variable declarations
    /** flaf for the seting of the icons */
    private boolean m_iconsSet = false;
    /** Strings for colours */
    private final String m_white = "white";
    private final String m_black = "black";
    /** store the black icon */

    private Icon m_blackpiece;
    /** store the white icon */
    private Icon m_whitepiece;
    /** Indicates whether to run tests */
    private boolean m_test = false;
}