package com.ferncircle.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
 * @author dbrit00s
 *
 *
 *Solution:
 *I go through the pattern letters and words in parallel and compare the indexes where they last appeared.
 */
public class WordPattern {

	public boolean wordPattern(String pattern, String str) {

		String[] input = str.split("\\s");
		if(pattern.length() != input.length){
			return false;
		}
		
		Map<String, Integer> lookup = new HashMap<>();		
		for(int i=0; i<pattern.length(); i++){
									
			if(lookup.put(String.valueOf(pattern.charAt(i)), i) != lookup.put(input[i], i)){
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args){
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
	}

}
