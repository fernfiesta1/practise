package com.ferncircle.string;

import junit.framework.Assert;

public class StringCompression {
	
	public String compress(String input){
		
		int j=0;
		int count = 1;
		StringBuffer output = new StringBuffer();
		
		for(int i=1; i< input.length(); i++){
			if(input.charAt(i) == input.charAt(j)){
				count++;
			}else{
				output.append(input.charAt(j));
				output.append(count);
				count = 1;
			}
			j++;
		}
		
		output.append(input.charAt(j));
		output.append(count);
		
		if(output.length() >= input.length()){
			return input;
		}
		
		return output.toString();
	}

	public static void main(String[] args) {
		
		StringCompression sc = new StringCompression();
		Assert.assertEquals("a2b3c4a2", sc.compress("aabbbccccaa"));
		Assert.assertEquals("abcd", sc.compress("abcd"));
		System.out.println("Test successful");

	}

}
