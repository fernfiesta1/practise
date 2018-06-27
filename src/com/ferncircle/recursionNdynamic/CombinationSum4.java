package com.ferncircle.recursionNdynamic;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {

	Map<Integer, Integer> cache = new HashMap<>();
	public int combinationSum(int[] nums, int target) {
		
		if(cache.containsKey(target)){
			return cache.get(target);
		}
		if(target == 0){
			return 1;
		}
		
		if(target < 0){
			return 0;
		}
		
		int res = 0;
		for(int i=0; i< nums.length; i++){
			res +=combinationSum(nums, target-nums[i]);			
		}
		
		cache.put(target, res);
		return res;
		
	}
	
	public int combinationSum4(int[] nums, int target) {
	    int[] comb = new int[target + 1];
	    comb[0] = 1;
	    for (int i = 1; i < comb.length; i++) {
	        for (int j = 0; j < nums.length; j++) {
	        	int temp = i - nums[j];
	        	if (temp >= 0) {	                
	            	comb[i] += comb[temp];
	            }
	        }
	    }
	    return comb[target];
	}
	
	
	public static void main(String[] args){
		
		CombinationSum4 cs = new CombinationSum4();
		int[] cadidates = new int[]{1,2,3};
		
		System.out.println("Top down: " + cs.combinationSum(cadidates, 4));
		System.out.println("Bottom Up: " + cs.combinationSum4(cadidates, 4));
	}

}
