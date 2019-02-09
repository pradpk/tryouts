package dynamicprogramming;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		System.out.print(findLongestCommonSequence("ABAZDC".toCharArray(), "BACBAD".toCharArray()));
	}
	
	
	private static int findLongestCommonSequence(char[] s, char[] t) {
		int longest = 0;
		int[][] lcs = new int[s.length+1][t.length+1];
		
		for(int i=1;i<=s.length;i++) {
			for(int j=1;j<=t.length;j++) {
				if(s[i-1] == t[j-1]) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
				}
				
				if(lcs[i][j] > longest) {
					longest = lcs[i][j];
				}
			}
		}
		
		return longest;
	}

}
