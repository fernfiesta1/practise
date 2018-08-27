package com.ferncircle.string;

/**
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 * @author dbrit00s
 *
 */
public class FirstNonRepeatingCharacter {

	public int firstUniqChar(String s) {

		int[] count = new int[26];
		//Create a character array and keep a coun of all the characters in the input string
		for(int i=0; i< s.length(); i++){
			count[s.charAt(i) - 'a'] = count[s.charAt(i) - 'a'] + 1;
		}
		
		
		//Go through each character of the input string and see if it is the first non repeating character.
		for(int i=0; i<s.length(); i++){
			if(count[s.charAt(i) - 'a'] == 1){
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		FirstNonRepeatingCharacter fs = new FirstNonRepeatingCharacter();
		System.out.println(fs.firstUniqChar("leetcode"));

	}

}
