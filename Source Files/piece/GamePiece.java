package piece;

import java.awt.Color;

import javax.swing.Icon;
/**
 * \\file   -GamePiece.java
 * \author -Gavin Bailey 711036
 * \date   -24th Feb 14
 * 
 *  \brief Parent class of pieces for connect four and
 *  othello games
 *  
 *  This abstract class is the parent object for game pieces,
 *  it contains accessor methods for piece data and abstract 
 *  method declarations
 */
public abstract class GamePiece {
    
    /**
     * Accessor method to set piece colour
     * \param col a String for piece colour
     * \return true when method completes
     */
    public boolean SetColour(Color col) {
        boolean test = false;
        if (test || m_test) {
            System.out.println("GamePiece :: setColour() BEGIN");
        }
        
        m_colour = col;
        
        if (test || m_test) {
            System.out.println("GamePiece :: setColour() END");
        }
        
        return true;
    }
    
    /**
     * Accessor method to get piece colour
     * \return m_colour a String of what colour the piece is currently
     */
    public Color GetColour() {
        boolean test = false;
        if (test || m_test) {
            System.out.println("GamePiece :: getColour() BEGIN");
        }
        
        if (test || m_test) {
            System.out.println("GamePiece :: getColour() END");
        }
        
        return m_colour;
        
        
    }
    
    /* Abstract classes */
    /**
     * An abstract accessor method to get the Icon of the piece
     * \return Icon image of piece 
     */
    public abstract Icon GetIcon();
    
    /**
     * An abstract accessor method to set the icons of the pieces 
     * for the current game
     * \return true when method completes
     */
    public abstract boolean SetIcons();
    
    /*variable declarations*/
    /** Stores the String of the current colour */
    private Color m_colour;
    /** Indicates whether to run tests */
    private boolean m_test = false;
}