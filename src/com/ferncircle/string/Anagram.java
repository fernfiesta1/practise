package com.ferncircle.string;

import junit.framework.Assert;

public class Anagram {
	
	public boolean findAnagram(String input1, String input2){
		
		if(input1 == null || input2 == null){
			return false;
		}
		if(input1.isEmpty() || input2.isEmpty()){
			return false;
		}
		
		int[] charArr = new int[256];
		
		char[] in1 = input1.toLowerCase().toCharArray();
		char[] in2 = input2.toLowerCase().toCharArray();
		
		for(char c: in1){
			if(c!=' '){
				charArr[c]++;
			}
		}
		
		for(char c: in2){
			if(c!=' '){
				if(charArr[c] == 0){
					return false;
				}else{
					charArr[c]--;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Anagram a = new Anagram();
		Assert.assertEquals(true, a.findAnagram("William Shakespeare", "I am a weakish speller"));
		Assert.assertEquals(false, a.findAnagram("Stefina", "salina"));
		Assert.assertEquals(false, a.findAnagram("klkl", "klklk"));
		
		System.out.println("Test Successful");

	}

}
