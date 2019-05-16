import java.util.*;


public class PriorityQueueHelper {

  public static void main(String[] a) {
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
