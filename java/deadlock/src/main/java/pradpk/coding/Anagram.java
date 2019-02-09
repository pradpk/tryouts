package pradpk.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * Class which takes a sentence and prints a map of anagram texts.
 * Sentence will be separated by a space.
 * @author prakpr7
 *
 */
public class Anagram {
	
	public static void main(String[] a) {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		scan.close();		
		printAnagrams(text!= null?text.trim().toLowerCase().split(" "):new String[]{""});
	}
	
	/**
	 * Method which takes a string array and prints the anagrams.	 *  
	 * @param wordArr - Array of string
	 */
	private static void printAnagrams(String[] wordArr) {		
		Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		/*
		 * ignore index - if anagram string already found, we will not check it again.
		 */
		List<Integer> ignoreIndex = new ArrayList<Integer>();
		for(int i=0;i<wordArr.length;i++) {
			if(ignoreIndex.contains(i)) {
				continue;
			}
			for(int j=i+1;j<wordArr.length;j++) {
				if(isAnagram(wordArr[i], wordArr[j])) {
					ignoreIndex.add(j);
					if(anagramMap.containsKey(wordArr[i])) {
						List<String> anagrams = anagramMap.get(wordArr[i]);
						anagrams.add(wordArr[j]);
					} else {
						List<String> anagrams = new ArrayList<String>();
						anagrams.add(wordArr[j]);
						anagramMap.put(wordArr[i], anagrams);
					}
				}
			}
			
		}
		
		System.out.println("map : " + anagramMap);
	}
	
	/**
	 * Method to check 2 strings are anagram.
	 * @param a
	 * @param b
	 * @return 
	 * 	true - if both strings are anagram
	 * 	false - if they are not anagram
	 */
	private static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		int[] charIndex = new int[26];
		
		for(int i=0;i<a.length();i++) {
			charIndex[a.charAt(i) - 'a']++;
			charIndex[b.charAt(i) - 'a']--;
		}
		
		for(int i=0;i<charIndex.length;i++) {
			if(charIndex[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	

}
