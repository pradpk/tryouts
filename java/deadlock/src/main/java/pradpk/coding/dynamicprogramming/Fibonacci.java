package pradpk.coding.dynamicprogramming;

public class Fibonacci {
	
	public static void main(String[] s) {
		bruteForceRecursive(10);
		bottomUpFib(10);
	}
	
	/*
	 * Recursive approach (similar to brute force) - Complexity - O(2^n)
	 */
	private static void bruteForceRecursive(int n) {
		for(int i=1;i<=n;i++) {
			System.out.println(recursiveFib(i) + " ");
		}
	}
	
	private static int recursiveFib(int n) {
		return n>2?recursiveFib(n-1)+recursiveFib(n-2):1;
	}
	
	/*
	 * Bottom Up Approach - Linear - O(n)
	 */
	private static void bottomUpFib(int n) {
		int[] fib = new int[n+1];
		int sum = 1;
		for(int i=1;i<=n;i++) {
			if(i <=2) {
				sum = 1;
			} else {
				sum = fib[i-1] + fib[i-2];
			}			 
			fib[i] = sum;
			System.out.println(fib[i]);
		}
	}
	
	private static void memoized(int n) {
		
	}
	

}


