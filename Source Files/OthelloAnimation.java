import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

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
	public OthelloAnimation(GUI gui) {
		JFrame frame = gui.GetFrame();
		
		m_GlassPane = new OthelloAnimationPane(gui.GetFrame());
		m_Animating = new ArrayList<OthelloAnimationPoint>();
		frame.setGlassPane(m_GlassPane);
		m_GlassPane.setVisible(true);

		createTimer();
		getTimer().start();
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
			if (point.completed()) { toRemove.add(point); }
		}
	
		m_Animating.removeAll(toRemove);
		//this.repaint();
		m_GlassPane.setPoints(m_Animating);
		m_GlassPane.revalidate();
		m_GlassPane.repaint();
		// TODO m_GlassPane.setPoints(m_Animating);
	}

	public void paintComponent(Graphics g) {
		System.out.println("OthelloAnimation::paintComponent: do");
		// super.paintComponents(g);
		m_GlassPane.paintComponent(g);
	}	
	
	private OthelloAnimationPane m_GlassPane;
	private ArrayList <OthelloAnimationPoint> m_Animating;
	private final int FRAMES = 15; // 15 frames == 0.5 seconds
}
