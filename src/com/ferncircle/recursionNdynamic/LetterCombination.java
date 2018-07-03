package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

Solution:
for each element of first array, go through all the elements of second array, for each element of second array fo through all the elements of third array ...
 * 
 * 
 * NOTE: Refer again
 *
 */
public class LetterCombination {

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
		
		helper(input, 0, result, temp);
		return result;

	}	
	
	public void helper(String[] input,int index, List<String> result, StringBuffer temp){
		if(index > input.length-1){
			result.add(new String(temp.toString()));
			return;
		}
		
		for(int i=0; i< input[index].length(); i++){
			temp.append(input[index].charAt(i));
			index = index +1;
			helper(input, index, result, temp);
			temp.deleteCharAt(temp.length()-1);
			index = index-1;
		}
	}

	public static void main(String[] args) {
		
		LetterCombination lc = new LetterCombination();
		System.out.println(lc.letterCombinations("239"));

	}

}
