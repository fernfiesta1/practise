package com.ferncircle.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

	public String reverseVowels(String s) {

		char[] input = s.toCharArray();
		
		Set<Integer> vowels = new HashSet<>();
		vowels.add((int)'a');
		vowels.add((int)'e');
		vowels.add((int)'i');
		vowels.add((int)'o');
		vowels.add((int)'u');
		vowels.add((int)'A');
		vowels.add((int)'E');
		vowels.add((int)'I');
		vowels.add((int)'O');
		vowels.add((int)'U');
		
		int start = 0;
		int end = input.length-1;
		while(start < end){
			if(vowels.contains((int)input[start])){
				if(vowels.contains((int)input[end])){
					//swap
					char temp = input[start];
					input[start] = input[end];
					input[end] = temp;
					start++;
					end--;
				}else{
					end--;
				}				
			}else{
				start++;
			}
			
		}
		return String.copyValueOf(input);
	}


	public static void main(String[] args) {
		
		ReverseVowels rv = new ReverseVowels();
		System.out.println(rv.reverseVowels("aeIOA"));

	}

}
