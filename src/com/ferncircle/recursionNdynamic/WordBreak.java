package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {

		if(s.isEmpty()){
			return true;
		}
		int length = s.length()-1;
		for(int i = length;i>=0; i--){
			String temp = s.substring(i);
			if(wordDict.contains(temp)){
				return wordBreak(s.substring(0, i), wordDict);
			}
		}
		return false;
	}
	
	public boolean wordBreakBottomUp(String s, List<String> wordDict){
		
		boolean[] dp = new boolean[s.length()+1];
		
		//Empty String is always present
		dp[0] = true;
		for(int i =1; i< dp.length; i++){
			for(int j=0; j< i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}				
			}
		}
		
		return dp[dp.length-1];
	}

	public static void main(String[] args) {

		WordBreak wb = new WordBreak();
		List<String> input = new ArrayList<>();
		input.add("leet");
		input.add("code");
		input.add("leeter");
		System.out.println(wb.wordBreak("leetcode", input));
		System.out.println(wb.wordBreakBottomUp("leetcode", input));
	}

}
