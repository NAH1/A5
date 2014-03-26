import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import boardGame.*;

import java.util.ArrayList;

/**
 * 
 * \author Ben Golightly
 *
 */
public class OthelloAnimation extends Animation{

	/**
	 * Constructor method
	 * \param frame - 
	 * \param game - 
	 */
	public OthelloAnimation(JFrame frame,  BoardGame game, GUI gui) {
		super(frame, game, gui);
		
		m_GlassPane = new OthelloAnimationPane(frame);
		m_Animating = new ArrayList<OthelloAnimationPoint>();
		frame.setGlassPane(m_GlassPane);

		EventHandler handler = new EventHandler();
		javax.swing.Timer timer =
			new javax.swing.Timer(DELAY, new ActionListener() {         
	        @Override
	        public void actionPerformed(ActionEvent e) {
	               cycle();          
	        }
	    });
		
		setTimer(timer);
		timer.start();
		
		ImageIcon ii[] = new ImageIcon[FRAMES];
		for (int i = 1; i <= FRAMES; i++) {
			ii[i - 1] = new ImageIcon("othello-anim-"+i+".png");
		}
		
	}

	@Override
	public void animate(int xcoord, int ycoord, Color playerColour) {
		int dir;
		
		if (playerColour == Color.black) {
			dir = 1;
		}
		else if (playerColour == Color.white) {
			dir = -1;
		}
		else {
			throw new IllegalArgumentException("bad playerColour");
		}
		
		m_Animating.add(new OthelloAnimationPoint(xcoord, ycoord, dir, FRAMES));
	}

	/**
	 * 
	 */
	@Override
	protected void cycle() {
		ArrayList<OthelloAnimationPoint> toRemove =
			new ArrayList<OthelloAnimationPoint>();

		for (OthelloAnimationPoint point : m_Animating) {
			point.sync();
			System.out.println("TEST ANIMATION: " + point.frame());
			if (point.completed()) { toRemove.add(point); }
		}
	
		m_Animating.removeAll(toRemove);
		//this.repaint();
		m_GlassPane.revalidate();
		m_GlassPane.repaint();
		// TODO m_GlassPane.setPoints(m_Animating);
	}

	public void paintComponent(Graphics g) {
		System.out.println("OthelloAnimation::paintComponent: do");
		// super.paintComponents(g);
		m_GlassPane.paintComponent(g);
	}

	@Override
	protected void drawPiece(Graphics g) {
		
	}
	
	
	private OthelloAnimationPane m_GlassPane;
	private ArrayList <OthelloAnimationPoint> m_Animating;
	private final int FRAMES = 6;
}
