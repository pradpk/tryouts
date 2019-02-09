package pradpk.coding;

import java.util.Scanner;

public class Prime {
	
	public static void main(String[] a) {
		Scanner scan = new Scanner(System.in);
		int num= scan.nextInt();
		
		for(int i=3;i<Math.sqrt(num)+1;i=i+2) {
			if(num % 2 == 0) {
				System.out.print("Not prime");
				break;
			}			
			if(num % i == 0) {
				System.out.print("Not prime");
				break;
			}
		}
		
		scan.close();
	}

}
