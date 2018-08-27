package com.ferncircle.string;


/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 * @author dbrit00s
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		
		if(s == null || s.length() == 0){
			return true;
		}
		
		int start = 0;
		int end = s.length()-1;
		
		while(start<=end){
			if(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))){
				start++;
			}else if(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))){
				end--;
			}else if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
				return false;
			}else{
				start++;
				end--;
			}
				
		}
		
		return true;
		
	}

	public static void main(String[] args) {

		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("0110"));
	}

}
