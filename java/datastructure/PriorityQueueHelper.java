import java.util.*;

/**
PriorityQueue is an implement of Queue which can be used to store and retrieve sorted sequence of elements.
It is ideal to use PriorityQueue data structure to store and retrieve job schedulers based on priorities.
*/
public class PriorityQueueHelper {

  public static void main(String[] a) {
    asPriorityQueue();
  }
  
  private static void asPriorityQueue() {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for(int i=1;i<11;i++) {
      pq.offer(i + new Random().nextInt());
    }
    
    while(!pq.isEmpty()) {
      System.out.print(pq.poll() + " ");
    }
  }

}
