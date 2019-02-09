package pradpk.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to print distinct pairs which can add up to specified sum from a set of numbers.
 * @author prakpr7
 *
 */
public class DistinctPairs {

	/**
	 * Enter the set of numbers first and then enter the sum in the next line
	 * @param a
	 */
	public static void main(String[] a) {
		Scanner scan = new Scanner(System.in);
		String[] inputs = scan.nextLine().split(" ");
		int sum = scan.nextInt();
		scan.close();
		printDistinctPairs(sum, createIntArray(inputs));
	}
	
	/**
	 * Prints the distinct pairs that can add up to specified sum.
	 * @param sum - Sum specified during input
	 * @param input - Array of Integers - Using Integer object as it is already from JVM cache (flyweight pattern).
	 */
	private static void printDistinctPairs(int sum, Integer[] input) {
		List<String> pairs = new ArrayList<String>();
		for(int i=0;i<input.length;i++)	{
			for (int j=i+1;j<input.length;j++) {
				if((input[i] + input[j] == sum) && 
						!(pairs.contains("("+input[j]+","+input[i]+")"))) {
					pairs.add("("+input[i]+","+input[j]+")");
				}
			}
		}		
		System.out.println(pairs);
	}
	
	/**
	 * Checks whether a number
	 * @param sequence
	 * @return 
	 * 	true if numeric 
	 */
	private static boolean isNumeric(final String sequence) {
		for(int i=0;i<sequence.length();i++) {
			if(!Character.isDigit(sequence.charAt(i))) {
				return false;
			}
		}
		return true;		
	}
	
	/**
	 * Method to create integer array 
	 * @param s - Array of string which can contain Integer
	 * @return Array of integers
	 */
	private static Integer[] createIntArray(String[] s) {
		Integer[] i = new Integer[s.length];
		int x = 0;
		for(String w : s) {
			if(isNumeric(w)) {
				i[x++] = Integer.valueOf(w);
			}
		}		
		return i;
	}

}
