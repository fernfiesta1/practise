package com.ferncircle.string;

import org.junit.Assert;

public class PalindromePermutation {
	
	
	public boolean solution(String input){
		
		//TODO: why create an array of 256 when we only need an array of 26 elements. coz we are only considering lowercase characters. Will using a hashmap be a good solution?
		int[] letters = new int[256];
		
		char[] inputArr = input.toCharArray();
		for(int i=0; i<inputArr.length; i++){
			int inChar = inputArr[i];
			if(inChar != ' '){
				letters[inChar] = letters[inChar] + 1;
			}
		}
		
		int oddCount = 0;
		for(int i =0; i< letters.length; i++){
			if(letters[i]%2!=0){
				oddCount = oddCount +1;
				
				if(oddCount > 1){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		
		PalindromePermutation pp = new PalindromePermutation();
		Assert.assertTrue(pp.solution("taco cat"));
		Assert.assertTrue(pp.solution("santa a at nasa"));
		Assert.assertTrue(pp.solution("fieddie"));
		Assert.assertFalse(pp.solution("black hawk"));
		Assert.assertFalse(pp.solution("taco bell"));
		Assert.assertTrue(pp.solution("batu but a"));
		
		System.out.println("test successful");
	}
	

	
	
}
