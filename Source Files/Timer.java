public class Timer {
	long startTime;
	
	private void m_setRunTime(){
		startTime = System.currentTimeMillis();
	}
	
	public void getRunTime(){
		long runTime = System.currentTimeMillis() - startTime;
		System.out.println("Run time: " + runTime);
		
	}
}