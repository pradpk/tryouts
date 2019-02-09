package pradpk.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SecondMostFrequent {

	static int mostFrequent(int arr[]) 
    { 
          Arrays.sort(arr);          
          int maxCount = 0;
          int currCount = 0;
          int freq = 0;
          
          for(int i=0;i<arr.length-1;i++) {        	 
        	if(arr[i] == arr[i+1]) {
        		if(i==0) {
        			currCount = currCount + 2;        			
        		}
        		else {
        			currCount = currCount + 1;
        		}
        	} else {
        		if(currCount > maxCount) {
        			maxCount = currCount;
        			freq = arr[i];
        			currCount = 1;
        		}
        	}
          }
          
          return freq; 
    } 
	
	public static void main (String[] args) { 
        int arr[] = {1, 5, 2, 1, 3, 2, 1, 3};   
        System.out.println(mostFrequent(arr)); 
          
    } 
    
    static int mostFrequentWithMap(int arr[]) {
    	Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    	int maxCount = 0;
    	int freq = 0;
    	
    	for(int i=0;i<arr.length;i++) {
    		if(countMap.containsKey(arr[i])) {
    			countMap.put(arr[i], countMap.get(arr[i]) + 1);
    			
    		} else {
    			countMap.put(arr[i], 1);
    		}
    	}
    	
    	for(Entry<Integer, Integer> entry : countMap.entrySet()) {
    		if(entry.getValue() > maxCount) {
    			maxCount = entry.getValue();
    			freq = entry.getKey();
    		}
    	}
    	
    	return freq;
    }
	
    static int secondMostFrequentWithMap(int arr[]) {
    	Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
    	
    	int freq = 0;
    	
    	for(int i=0;i<arr.length;i++) {
    		if(countMap.containsKey(arr[i])) {
    			countMap.put(arr[i], countMap.get(arr[i]) + 1);
    			
    		} else {
    			countMap.put(arr[i], 1);
    		}
    	}
    	
    	List<Integer> sortedCount = countMap.values().stream().sorted().collect(Collectors.toList());
    	int count = sortedCount.get(sortedCount.size()-2);
    	
    	for(Entry<Integer, Integer> entry : countMap.entrySet()) {
    		if(entry.getValue() == count) {    			
    			freq = entry.getKey();
    			break;
    		}
    	}
    	
    	return freq;
    }
	

}
