package com.ferncircle.string;

/**
 * 
 * Given an input string , reverse the string word by word. 

Example:

Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.

 * @author dbrit00s
 *
 */
public class ReverseString2 {

	public void reverseWords(char[] str) {

		reverse(str, 0, str.length-1);
		int i=-1;
		for(int j = 0; j< str.length; j++){
			if(str[j] == ' '){
				reverse(str, i+1, j-1);
				i = j;
			}					
		}
		
		//this is to reverse the last word
		reverse(str, i+1, str.length-1);
		
		
	}
	
	private void reverse(char[] input, int i, int j){		
		
		while(i<j){
			char temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			j--;
			i++;
		}		
		
	}

	public static void main(String[] args) {
		ReverseString2 rs2 = new ReverseString2();
		char[] input = new char[]{' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		System.out.println(input);
		rs2.reverseWords(input);
		System.out.println(input);

	}

}
