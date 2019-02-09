package pradpk.coding;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FizzBuzz {
	
	public static void main(String[] a) {
		List<Integer> list = (List) Arrays.asList(1,2,3);
		reduceSum1(list);
	}
	
	private static void reduceSum(List<Integer> list) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(list);
        int sum = priorityQueue.poll();
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
        	System.out.println("priorityQueue :" + priorityQueue +", cost :" + cost + ", sum : " + sum);
            int currentElement = priorityQueue.poll();
            if (currentElement < sum) {
                priorityQueue.add(sum);
                sum = currentElement;
            } else {
                sum += currentElement;
                cost += sum;
                continue;
            }

            sum += priorityQueue.poll();
            cost += sum;
            
        }

        System.out.println(cost);
	}
	
	
	private static void reduceSum1(List<Integer> list) {
		int sum = list.get(0);
		int cost = 0;
		
		int index = 1;
		while(!list.isEmpty()) {
			int current = list.get(index);
			if(current < sum) {
				list.add(sum);
				sum = current;
			} else {
				sum += current;
                cost += sum;
                continue;
			}
			sum += list.get(index);
			cost += sum;
			index++;
		}
        
        System.out.println(cost);
	}
	

}
