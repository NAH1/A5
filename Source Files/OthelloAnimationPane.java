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
    	// System.out.println("OthelloAnimationPane::paintComponent: do");
        Graphics2D g2 = (Graphics2D) g; 
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));  
        
        if (m_toDraw != null) {
        	for (OthelloAnimationPoint point : m_toDraw) {
        		point.draw(g2);
        	}
        }
        // g2.drawImage(img, 0, 0, null);
        //g2.setColor(Color.red);
        //g2.fillOval(0, 0, 20, 20);
        
        g2.dispose(); 
    } 
 
    public void eventDispatched(AWTEvent event) { 
    	System.out.println("OthelloAnimationPane::paintComponent: redispatch event");
        if (event instanceof MouseEvent) { 
            MouseEvent me = (MouseEvent) event; 
            if (!SwingUtilities.isDescendingFrom(me.getComponent(), frame)) { 
                return; 
            } 
            if (me.getID() == MouseEvent.MOUSE_EXITED && me.getComponent() == frame) { 
                point = null; 
            } else { 
                MouseEvent converted = SwingUtilities.convertMouseEvent(me.getComponent(), me, frame.getGlassPane()); 
                point = converted.getPoint(); 
            } 
            repaint(); 
        } 
    } 
    
    private ArrayList <OthelloAnimationPoint> m_toDraw;
} 