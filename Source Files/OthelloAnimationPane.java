import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
 
/**
 * \\file -OthelloAnimationPane.java 
 * \author -Ben Golightly
 * \date -27th March 2014
 * 
 * \see Animation.java
 * \see Othello.java
 * \see OthelloAnimaiton.java
 * \see OthelloAnimaitonPoint.java
 * 
 * \brief This class manages a "glass pane" to draw animations on to. 
 */
public class OthelloAnimationPane extends JPanel {  
 
    /**
     * Constructor for the glass pane
     */
    public OthelloAnimationPane() { 
        super(null); 
        m_toDraw = null;
        setOpaque(false); 
        setLocation(0, 0);
        setSize(WIDTH, HEIGHT);
    } 
 
    /**
     * Set the list of points to draw
     * @param points the points to draw
     */
    public void setPoints(ArrayList <OthelloAnimationPoint> points) { 
        m_toDraw = points;
    } 
 
    /**
     * paintComponent is called automatically when the panel needs to be
     * drawn.
     * @param g a given graphics handle.
     */
    protected void paintComponent(Graphics g) { 
        Graphics2D g2 = (Graphics2D) g;
        
        // Set transparency to opaque (1.0f = maximum)
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
        			OPACITY));  
        
        // Draw each point
        if (m_toDraw != null) {
        	for (OthelloAnimationPoint point : m_toDraw) {
        		point.draw(g2);
        	}
        }      
        g2.dispose(); 
    } 
    
    /** the points to draw */
    private ArrayList <OthelloAnimationPoint> m_toDraw;
    /** width of pane */
    private final int WIDTH = 1000; // big enough
    /** height of pane */
    private final int HEIGHT = 1000; // big enough
    /** opacity of pane */
    private final float OPACITY = 1.0f;
} 