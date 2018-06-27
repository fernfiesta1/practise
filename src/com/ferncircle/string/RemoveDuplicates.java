package com.ferncircle.string;

import junit.framework.Assert;

public class RemoveDuplicates {

	
	public String solution(String input){
	
		if(input == null){
			return null;
		}
		if(input.isEmpty() || input.length()==1){
			return input;
		}
		boolean[] characters = new boolean[256];
		
		StringBuffer result = new StringBuffer();
		char[] inputarr = input.toCharArray();
		for(char c: inputarr){
			if(!characters[c]){
				result.append(c);
				characters[c]=true;
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		
		RemoveDuplicates rd = new RemoveDuplicates();
		Assert.assertEquals("a", rd.solution("aaaaaa"));
		Assert.assertEquals("abkl", rd.solution("abkl"));
		Assert.assertEquals("abc", rd.solution("aaabbbbcccc"));
		Assert.assertEquals("abc", rd.solution("abcabcabc"));
		
	}

}
