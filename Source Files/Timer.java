public class Timer {
	long startTime;
	
	public void setRunTime(){
		long startTime = System.currentTimeMillis();
	}
	
	public void getRunTime(){
		long runTime = System.currentTimeMillis() - startTime;
		System.out.println("Run time: " + runTime);
		
	}
}