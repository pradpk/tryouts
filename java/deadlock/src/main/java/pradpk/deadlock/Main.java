package pradpk.deadlock;

public class Main {
	
	public static void main(String[] s) {
		
		Task task = new Task();
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
	}

}
