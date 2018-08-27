package com.ferncircle.string;


/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * @author dbrit00s
 *
 */
public class LongestSubstringWithoutRepeatingChars {

	public int lengthOfLongestSubstring(String s) {

		int length = 0;
		if(s.length() == 0){
			return 0;
		}
		
		if(s.length() == 1){
			return 1;
		}
		int[] chars = new int[256];			
		
		for (int j = 0, i = 0; j < s.length(); j++) {
            i = Math.max(chars[s.charAt(j)], i);
            length = Math.max(length, j - i + 1);
            chars[s.charAt(j)] = j + 1;
        }
		
		return length;
	}

	public static void main(String[] args) {
		
		String input = "tmmzuxt";
		LongestSubstringWithoutRepeatingChars ls = new LongestSubstringWithoutRepeatingChars();
		System.out.println(ls.lengthOfLongestSubstring(input));

	}

}
