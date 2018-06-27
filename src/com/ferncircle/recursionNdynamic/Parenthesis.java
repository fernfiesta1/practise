package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
	
	public List<String> generateParenthesis(int num){
		
		char[] input = new char[]{'(', ')'};
		int[] count = new int[]{num, num};
		
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>();
		
		backtrack(input, count, sb, result, num*2);
		return result;
		
	}
	
	public void backtrack(char[] input, int[] count, StringBuilder temp, List<String> result, int num){
		if(count[0]<0 || count[1]<0) return;
		if(count[0] > count[1]) return;
		
		if(temp.length() == num){
			result.add(new String(temp.toString()));
		}
		
		for(int i=0; i<input.length; i++){			
			temp.append(input[i]);
			count[i]--;
			backtrack(input, count, temp, result, num);
			count[i]++;
			temp.deleteCharAt(temp.length() -1);
		}
	}
	
	public static void main(String[] args){
		Parenthesis p = new Parenthesis();
		System.out.println(p.generateParenthesis(3));
	}

}
