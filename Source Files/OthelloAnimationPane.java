import javax.swing.*; 

import java.awt.*; 
import java.awt.event.AWTEventListener; 
import java.awt.event.MouseEvent; 
import java.util.ArrayList;
 
public class OthelloAnimationPane extends JPanel implements AWTEventListener { 
    private final JFrame frame; 
    private Point point = new Point(); 
 
    public OthelloAnimationPane(JFrame frame) { 
        super(null); 
        this.frame = frame; 
        m_toDraw = null;
        setOpaque(false); 
        System.out.println("OthelloAnimationPane constructed");
        setLocation(0, 0);
        setSize(1000, 1000);
    } 
 
    public void setPoints(ArrayList <OthelloAnimationPoint> points) { 
        m_toDraw = points;
    } 
 
    protected void paintComponent(Graphics g) { 
        Graphics2D g2 = (Graphics2D) g;
        
        // Set transparency to opaque (1.0f = maximum)
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));  
        
        // Draw each point
        if (m_toDraw != null) {
        	for (OthelloAnimationPoint point : m_toDraw) {
        		point.draw(g2);
        	}
        }      
        g2.dispose(); 
    } 
    
    /* This needs to be implemented to extend JPanel even though it is never
     * called. */
    public void eventDispatched(AWTEvent event) { 
    	System.out.println("OthelloAnimationPane::paintComponent: redispatch event");
        if (event instanceof MouseEvent) { 
            MouseEvent me = (MouseEvent) event; 
            if (!SwingUtilities.isDescendingFrom(me.getComponent(), frame)) { 
                return; 
            } 
            repaint(); 
        } 
    } 

    
    private ArrayList <OthelloAnimationPoint> m_toDraw;
} 