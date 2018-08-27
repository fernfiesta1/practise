package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination2 {

public List<String> letterCombinations(String digits) {
		
		
		Map<Character, String> phNumbers = new HashMap<>();
		phNumbers.put('2',"abc");
		phNumbers.put('3',"def");
		phNumbers.put('4',"ghi");
		phNumbers.put('5',"jkl");
		phNumbers.put('6',"mno");
		phNumbers.put('7',"pqrs");
		phNumbers.put('8',"tuv");
		phNumbers.put('9',"wxyz");
		
		
		List<String> result = new ArrayList<>();
		StringBuffer temp = new StringBuffer();
		String[] input = new String[digits.length()];
		
		for(int i=0; i< digits.length(); i++){
			input[i] = phNumbers.get(digits.charAt(i));
		}	
		
		List<String> dictionary = new ArrayList<>();
		dictionary.add("tree");		
		helper(input, 0, result, temp, dictionary);
		return result;

	}	


	private void helper(String[] input, int idx, List<String> result, StringBuffer temp, List<String> dictionary){
		if(dictionary.contains(temp.toString())){
			result.add(new String(temp));
		}
		
		if(idx >= input.length){
			return;
		}
		
		for(int i =0; i< input[idx].length(); i++){
			temp.append(input[idx].charAt(i));
			idx+=1;
			helper(input, idx, result, temp, dictionary);
			idx = idx-1;
			temp.deleteCharAt(temp.length() -1);			
		}
		
	}

	public static void main(String[] args) {
		LetterCombination2 lc2 = new LetterCombination2();
		System.out.println(lc2.letterCombinations("8733"));

	}

}
