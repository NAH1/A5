import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    private Timer timer = new Timer();
    
    public Clock() {
        timer.schedule(new UpdateUITask(), 0, 1000);
    }

    private class UpdateUITask extends TimerTask {

        int nSeconds = 595;
        String timeString;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        
        
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    nSeconds++;
                    hours = nSeconds / 3600;
                    minutes = (nSeconds % 3600) / 60;
                    seconds = nSeconds % 60;
                    String s_Seconds = Integer.toString(seconds);
                    String s_Minutes = Integer.toString(minutes);
                    String s_Hours = Integer.toString(hours);
                    if (seconds<10){
                    	s_Seconds=("0" + seconds);
                    }
                    if (minutes<10){
                    	s_Minutes=("0" + minutes);
                    }
                    if (hours<10){
                    	s_Hours=("0" + hours);
                    }
                    
                    timeString = s_Hours + ":" + s_Minutes + ":" + s_Seconds;
                    System.out.println(timeString);
                }
            });
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final Clock clock = new Clock();
            }
        });
    }
}