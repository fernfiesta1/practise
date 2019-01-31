package com.ferncircle.string;

public class StringToInteger {


	public int myAtoi(String str) {
		
		if(str == null || str.length() == 0) {
			return 0;
		}
		//REmove white spaces
		int start = 0;
		int end = str.length();
		while(start < end) {
			if(str.charAt(start) == ' ') {
				start++;
			}
		}
		
		//If end of the string return 
		if(start == end || !Character.isDigit(str.charAt(start))) {
			return 0;
		}
		
		int result = 0;
		while(start < end && Character.isDigit(str.charAt(start))) {
			int curr = str.charAt(start) - '0';
			result = result * 10 + curr;
		}
		
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
