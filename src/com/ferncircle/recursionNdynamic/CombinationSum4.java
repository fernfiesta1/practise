package com.ferncircle.recursionNdynamic;

import java.util.HashMap;
import java.util.Map;


/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
 * @author dbrit00s
 *
 */
public class CombinationSum4 {

	Map<Integer, Integer> cache = new HashMap<>();
	public int combinationSum(int[] nums, int target) {
		
		if(target == 0){
			return 1;
		}
		
		if(target < 0){
			return 0;
		}
		if(cache.containsKey(target)){
			return cache.get(target);
		}
		
		int res = 0;
		for(int i=0; i< nums.length; i++){
			res +=combinationSum(nums, target-nums[i]);			
		}
		
		cache.put(target, res);
		return res;
		
	}
	
	public int combinationSum2(int[] nums, int target, int idx) {
		if(target == 0){
			return 1;
		}
		
		if(target < 0){
			return 0;
		}
		if(cache.containsKey(target)){
			return cache.get(target);
		}
		
		int res = 0;
		for(int i=idx; i< nums.length; i++){
			res +=combinationSum2(nums, target-nums[i], i+1);			
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
		int[] cadidates = new int[]{-1,2,2,4,5};
		
		//System.out.println("Top down: " + cs.combinationSum(cadidates, 5));
		//System.out.println("Bottom Up: " + cs.combinationSum4(cadidates, 5));
		
		System.out.println("Combination : " + cs.combinationSum2(cadidates, 4, 0));
	}

}
