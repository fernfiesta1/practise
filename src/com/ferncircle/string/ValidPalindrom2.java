package com.ferncircle.string;

public class ValidPalindrom2 {

	public boolean validPalindrome(String s) {

		if(s == null || s.isEmpty()){
			return false;
		}

		if(s.length() == 1){
			return true;
		}

		int start = 0;
		int end = s.length()-1;

		while(start<=end){
			
			if(s.charAt(start) != s.charAt(end)){
				if(!isPalindrome(s.substring(start+1, end+1))){
					return isPalindrome(s.substring(start, end));
				}
				return true;
			}else{
				start++;
				end--;
			}

		}

		return true;
	}


	private boolean isPalindrome(String input){
		int start = 0;
		int end = input.length()-1;
		while(start <= end){
			if(input.charAt(start)!=input.charAt(end)){
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {

		ValidPalindrom2 vp2 = new ValidPalindrom2();
		String input = "aaabba";
		System.out.println(vp2.validPalindrome(input));

	}

}
