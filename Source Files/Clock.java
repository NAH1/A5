import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private Timer timer = new Timer();
    final int MSINSEC = 1000;
	GUI m_gui;
    
	/**
	 * @return the m_gui
	 */
	private GUI getGui() {
		return m_gui;
	}

	/**
	 * @param m_gui the m_gui to set
	 */
	private void setGui(GUI m_gui) {
		this.m_gui = m_gui;
	}
    
    public Clock(GUI gui, int time) {
    	setGui(gui);
        UpdateUITask task = new UpdateUITask(time);
        timer.schedule(task, 0, MSINSEC);
    }
    
    public boolean stop() {
    	timer.cancel();
    	return true;
    }

	private class UpdateUITask extends TimerTask {
		
		/**
		 * @return the m_seconds
		 */
		private int getSeconds() {
			return m_seconds;
		}

		/**
		 * @param m_seconds the m_seconds to set
		 */
		private void setSeconds(int m_seconds) {
			this.m_seconds = m_seconds;
		}

		public UpdateUITask(int time) {
			setSeconds(time);
		}
		
		public void run() {
			int Hours = 0;
			int Minutes = 0;
			int Seconds = 0;
			String TimeString;
			final int SECSINMIN = 60;
			final int SECSINHOUR = 3600;
			final int DOUBLEFIGURES = 10;
			
			Hours = getSeconds() / SECSINHOUR;
			Minutes = (getSeconds() % SECSINHOUR) / SECSINMIN;
			Seconds = getSeconds() % SECSINMIN;
			String SecondsString = Integer.toString(Seconds);
			String MinutesString = Integer.toString(Minutes);
			String HoursString = Integer.toString(Hours);
			if (Seconds < DOUBLEFIGURES){
				SecondsString=("0" + Seconds);
			}
			if (Minutes < DOUBLEFIGURES){
				MinutesString=("0" + Minutes);
			}
			if (Hours < DOUBLEFIGURES){
				HoursString=("0" + Hours);
			}
			
			TimeString = HoursString + ":" + 
			MinutesString + ":" + SecondsString;
		    if (m_Trace) System.out.println(TimeString);
		    getGui().SetTime(TimeString);
			setSeconds(getSeconds() + 1);
		}
		

		int m_seconds = 0;
		boolean m_Trace = true;
	}
    
    public static void main(String args[]) {
    }
}