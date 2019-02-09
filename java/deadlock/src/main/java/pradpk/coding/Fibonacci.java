package pradpk.coding;

import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] a) {
		Scanner scan = new Scanner(System.in);
		int max= scan.nextInt();
		//fib1(max);
		
		for(int i=1;i<=max;i++) {
			System.out.print(fib2(i) + " ");
		}
		scan.close();
	}
	
	private static int fib2(int num) {
		return num>2?fib2(num-1) + fib2(num-2):1;
	}

}
