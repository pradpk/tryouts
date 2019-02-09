package pradpk.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctSubSequence {

	public static void main(String[] args) {
		System.out.println(numDistinct("babgbag", "bag"));

	}

	public static int numDistinct(String s, String t) {

		List<Character> target = new ArrayList();
		for (int i = 0; i < t.length(); i++) {
			target.add(t.charAt(i));
		}

		Map<Character, List<Integer>> charIndex = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (charIndex.containsKey(ch)) {
				List<Integer> list = charIndex.get(ch);
				list.add(i);
				charIndex.put(ch, list);
			} else {
				List<Integer> list = new ArrayList<Integer>(); 
				list.add(i);
				charIndex.put(ch, list);
			}
		}
		
		char ch  = t.charAt(0);
		int count = 0;
		
		List<Integer> index = charIndex.get(ch);
		for(int i : index) {
			boolean flag = true;
			while(flag) {
				
			}
		}
		
		System.out.println(charIndex);

		return count;
	}

}
