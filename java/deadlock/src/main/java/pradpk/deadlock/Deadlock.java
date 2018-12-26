package pradpk.deadlock;

import java.util.ArrayList;
import java.util.List;

class Deadlock {
	
	private List<String> items = new ArrayList<String>();
	private List<String> makes = new ArrayList<String>();
	
	private static int SLEEP_VAL = 999;
	
	public void addItems() throws Exception {
		System.out.println("Running addItems");
		synchronized (items) {
			items.add("I");			
			Thread.sleep(SLEEP_VAL);
			synchronized (makes) {
				makes.add("M");
				Thread.sleep(SLEEP_VAL);
			}
		}
		System.out.println(items + "," + makes);
	}
	
	public void addMakes() throws Exception {
		System.out.println("Running addMakes");
		synchronized (makes) {
			makes.add("M");			
			Thread.sleep(SLEEP_VAL);
			synchronized (items) {
				items.add("I");
				Thread.sleep(SLEEP_VAL);
			}
		}
		System.out.println(items + "," + makes);
	}
	
	
}