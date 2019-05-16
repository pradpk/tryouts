
import java.util.*;

/**
Class to apply LinkedList to use as queue and stack data structure.
Queue is FIFO (First in First Out)
Stack is LIFO (Last In First Out)
*/
public class LinkedListHelper {
	
	public static void main(String[] a) {
		useAsQueue();
		useAsStack();
	}
	
	private static void useAsQueue() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<11;i++) {
			list.offer(i);
		}
		
		while(!list.isEmpty()) {
			System.out.print(list.poll() + "\t");
		}
	}
	
	private static void useAsStack() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<11;i++) {
			list.offer(i);
		}
		
		while(!list.isEmpty()) {
			System.out.print(list.pollLast() + "\t");
		}		
	}
	
	
	
}
