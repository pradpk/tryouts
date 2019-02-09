package pradpk.coding;

public class Sample {
	int commaSeperatedTotal = 0;
	int palndromeTotal = 0;
	int numberTotal = 0;
	int alphaTotal = 0;
	int alphaNumericTotal = 0;

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		parseString("wasd,aaa,891,foo122");
	}

	public static void parseString(String str) {
		// Parse String here.
		str = str.toLowerCase();
		String[] values = str.split(",");

		if (null != values) {
			System.out.println(values.length);
		}

		int[] print = new int[4];

		for (String val : values) {
			print[0] += isPalindrome(val) ? 1 : 0;
			print[1] += isNumeric(val) ? 1 : 0;
			print[2] += isLetters(val) ? 1 : 0;
			print[3] += isAlphaNumeric(val) ? 1 : 0;
		}

		for (int i = 0; i < print.length; i++) {
			System.out.println(print[i]);
		}
	}

	private static boolean isPalindrome(String s) {
		
		String reverse = "";
		for (int i = s.length() - 1; i > -1; i--) {
			reverse = reverse + s.charAt(i);
		}

		if (s.equals(reverse)) {
			return true;
		}

		return false;
	}

	private static boolean isNumeric(String s) {
		for (char ch : s.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isLetters(String s) {
		for (char ch : s.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAlphaNumeric(String s) {

		if (isNumeric(s)) {
			return false;
		}

		if (isLetters(s)) {
			return false;
		}

		for (char ch : s.toCharArray()) {
			if (!Character.isLetterOrDigit(ch)) {
				return false;
			}
		}

		return true;
	}
}
