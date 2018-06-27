package com.ferncircle.string;

import org.junit.Assert;

public class UniqueCharacters {
	
	public boolean solution(String input){
		
		boolean[] result = new boolean[256];
		for(int i=0; i<input.length(); i++){
			int c = input.charAt(i);
			if(result[c]){
				return true;
			}else{
				result[c] = true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		UniqueCharacters uc = new UniqueCharacters();
		Assert.assertTrue(uc.solution("bobba"));
		Assert.assertFalse(uc.solution("stefina"));
		Assert.assertTrue(uc.solution("kjkj,,"));
		
		System.out.println("Test Successful");

	}

}
