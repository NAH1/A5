import java.util.Timer;
import java.util.TimerTask;

 /**
  * \\file Clock.java
  * \author Callum Hazelton
  * \date 27/03/2014
  * \brief Makes the timer
  * 
  * Counts the seconds since game started and converts to hh:mm:ss format. Also references GUI class
  */
public class Clock {
    
	/**
	 * gets the GUI
	 * \return the gui
	 */
	private GUI getGui() {
		return m_gui;
	}

	/**
	 * sets the GUI
	 * \param m_gui the gui
	 */
	private void setGui(GUI m_gui) {
		this.m_gui = m_gui;
	}
	
	/**
	 * gets time
	 * \return gets how many seconds have passed
	 */
	public int getTime() {
		return TASK.getSeconds();
	}
    
	/**
	 * Gets GUI and updates time every 1000 milliseconds 
	 * \param gui The GUI which clock should update.
	 * \param time The initial time in seconds with which
	 * the clock should start counting from.
	 */
    public Clock(GUI gui, int time) {
    	setGui(gui);
        TASK = new UpdateUITask(time);
        TIMER.schedule(TASK, 0, MSINSEC);
    }
    
    	/**
   	 * Stops the clock from counting
   	 * \return Returns true if successful
   	 */
    public boolean stop() {
    	TIMER.cancel();
    	return true;
    }

	private class UpdateUITask extends TimerTask {
		
		/**
		 * gets seconds passed
		 * \return seconds passed
		 */
		private int getSeconds() {
			return m_Seconds;
		}

		/**
		 * sets seconds passed
		 * \param m_Seconds Set's the integer containing
		 * the duration of the clock
		 */ 
		void setSeconds(int m_Seconds) {
			this.m_Seconds = m_Seconds;
		}
		 
		 /**
		  * Constructor method which passes in the time
		  * with which the clock should start counting
		  * from.
		  * \param time The duration to start from in seconds.
		  */
		public UpdateUITask(int time) {
			setSeconds(time);
		}
		
		/**
		 * Formats the seconds passed into hh:mm:ss and passes
		 * the time into the GUI
		 */
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
		

		int m_Seconds = 0;
		boolean m_Trace = false;
	}
	/**
	  * Main method to test class runs GameController to
	  * test the timer works
	  */
    public static void main(String args[]) {
    	GameController g = new GameController(GameController.GameType.OTHELLO);
    }
    

    private final Timer TIMER = new Timer();
    private final UpdateUITask TASK;
    private final int MSINSEC = 1000;
	private GUI m_gui;
}
