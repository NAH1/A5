import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private Timer timer = new Timer();
    private String m_TimeString;
    int msInSec = 1000;
    
    public String getTimeString() {
    	return m_TimeString;
    }
    
    public Clock() {
        timer.schedule(new UpdateUITask(), 0, msInSec);
    }

    private class UpdateUITask extends TimerTask {

        private int m_SecondsPassed = 00;
        private int m_Hours = 0;
        private int m_Minutes = 0;
        private int m_Seconds = 0;
        private int m_SecsInMin = 60;
        private int m_SecsInHour = 3600;
        private int m_doubleFigures = 10;
        
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                public void run() {
                    m_SecondsPassed++;
                    m_Hours = m_SecondsPassed / m_SecsInHour;
                    m_Minutes = (m_SecondsPassed % m_SecsInHour) / m_SecsInMin;
                    m_Seconds = m_SecondsPassed % m_SecsInMin;
                    String m_SecondsString = Integer.toString(m_Seconds);
                    String m_MinutesString = Integer.toString(m_Minutes);
                    String m_HoursString = Integer.toString(m_Hours);
                    if (m_Seconds<m_doubleFigures){
                    	m_SecondsString=("0" + m_Seconds);
                    }
                    if (m_Minutes<m_doubleFigures){
                    	m_MinutesString=("0" + m_Minutes);
                    }
                    if (m_Hours<m_doubleFigures){
                    	m_HoursString=("0" + m_Hours);
                    }
                    
                    m_TimeString = m_HoursString + ":" + 
                    m_MinutesString + ":"  +m_SecondsString;
                    System.out.println(m_TimeString);
                }
            });
        }
    }
   /* public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final Clock clock = new Clock();
            }
        });
    }*/
}