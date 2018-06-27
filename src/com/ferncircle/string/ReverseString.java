package com.ferncircle.string;

import junit.framework.Assert;

public class ReverseString {

	public String solution(String input){
		
		
		char[] input_char = input.toCharArray();
		int j= input_char.length-1;
		
		for(int i=0; i<input_char.length/2; i++){
			char temp = input_char[i];
			input_char[i] = input_char[j];
			input_char[j] = temp;
			j--;
		}		
		return String.valueOf(input_char);
	}
	
	public static void main(String[] args) {
		
		ReverseString rs = new ReverseString();
		Assert.assertEquals("elppa", rs.solution("apple"));
		Assert.assertEquals("abas", rs.solution("saba"));
		
		System.out.println("Test Successful");

	}

}

