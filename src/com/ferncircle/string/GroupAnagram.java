package com.ferncircle.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> output = new ArrayList<>();
		
		if(strs.length == 0){
			return output;
		}
		Map<String, List<String>> outMap = new HashMap<>();
		for(String s: strs){
			String intStr = getIntString(s);
			outMap.computeIfAbsent(intStr,  x -> new ArrayList()).add(s);
		}
		
		for(List<String> ls: outMap.values()){
			output.add(ls);
		}
		
		return output;
	}
	
	private String getIntString(String word){		
		int[] intArr = new int[26];
		char[] charArr = word.toCharArray();
		for(int i=0; i< charArr.length; i++){
			int index = charArr[i] - 97;
			intArr[index]++;			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<intArr.length; i++){
			sb.append(intArr[i] + ",");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {

		GroupAnagram ga = new GroupAnagram();
		System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

}
