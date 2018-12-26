package pradpk.deadlock;

public class Task implements Runnable {
	
	private Deadlock deadlock = new Deadlock();
	
	public void run() {
		try {
			System.out.println("Starting task ");
			deadlock.addItems();
			deadlock.addMakes();
			System.out.println("Ending task");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
