import javax.swing.*; 
import java.awt.*; 
import java.awt.event.AWTEventListener; 
import java.awt.event.MouseEvent; 
 
public class OthelloAnimationPane extends JPanel implements AWTEventListener { 
    private final JFrame frame; 
    private Point point = new Point(); 
 
    public OthelloAnimationPane(JFrame frame) { 
        super(null); 
        this.frame = frame; 
        //setOpaque(false); 
        System.out.println("OthelloAnimationPane constructed");
        setLocation(0, 0);
        setSize(1000, 1000);
        setVisible(true);
    } 
 
    public void setPoint(Point point) { 
        this.point = point; 
    } 
 
    protected void paintComponent(Graphics g) { 
    	System.out.println("OthelloAnimationPane::paintComponent: do");
        Graphics2D g2 = (Graphics2D) g; 
        g2.setColor(Color.ORANGE); 
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f)); 
        int d = 22;  
        g2.fillRect(getWidth() - d, 0, d, d); 
        if (point != null) {             
            g2.fillOval(point.x + d, point.y + d, d, d); 
        } 
        g2.setColor(Color.red);
        g2.fillOval(0, 0, 20, 20);
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
} 