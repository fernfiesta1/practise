package com.ferncircle.twopointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		if(s== null || t == null){
			return null;
		}
		if(t.length() > s.length()) {
			return null;
		}

		//Initialize map here:
			Map<Character, Integer> map = new HashMap<>();
			for(int i=0; i< t.length(); i++){
				map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
			}

			int count = t.length();
			int start =0;
			int min = Integer.MAX_VALUE;
			int sIn=-1;
			int eIn=-1;

			for(int j=0; j< s.length(); j++){
				if(map.containsKey(s.charAt(j))){
					if(map.get(s.charAt(j)) > 0){
						count--;
					}
					map.put(s.charAt(j), map.get(s.charAt(j)) - 1);					

				}

				while(count == 0){   
					int currMin = j - start + 1;
					if(currMin < min) {
						min = currMin;
						sIn = start;
						eIn = j;
					}					
					if(map.containsKey(s.charAt(start))){
						map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
						if(map.get(s.charAt(start)) > 0) {	                    	
							count++;
						}						
					}
					start++;
				}
			}
			
			if(sIn == -1) {
				return "";
			}else {				
				return s.substring(sIn, eIn + 1);
			}
	}
	
	public static void main(String[] args) {
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		String result = mws.minWindow(s, t);
		System.out.println(result);
		
	}
}
