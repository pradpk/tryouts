package pradpk.coding;

import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[] a) {
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		
		if(isNumeric(val)) {
			Integer ival = Integer.valueOf(val);
			int length = val.length();
			
			for(int i=0;i<length/2;i++) {
				
			}
			
		} else {
			int length = val.length();
			
			for(int i=0;i<length/2;i++) { 
				if(val.charAt(i) != val.charAt(length-1-i)) {
					System.out.println("Not a palindrome");
					break;
				}
			}
		}
		
		
		scan.close();
	}
	
	private static boolean isNumeric(String val) {
		for(int i=0;i<val.length();i++) {
			if(!Character.isDigit(val.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isPalindrome(String s) {

        String reverse = "";
        for(int i=s.length()-1;i>-1;i--) {
            reverse = reverse + s.charAt(i);
        }

        if(s.equals(reverse)) {
            return true;
        }
        
        return false;
    }


}
