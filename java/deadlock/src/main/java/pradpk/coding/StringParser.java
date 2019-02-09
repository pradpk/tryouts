package pradpk.coding;

import java.util.Scanner;

public class StringParser {
	
	
	public static void main(String[] a) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
	}
	
	private static void parseStr(String str) {
		String[] splits = str.split(",");
		if(null != splits) {
			System.out.println(splits.length);
		}		
	
	}
	

	
	

}
