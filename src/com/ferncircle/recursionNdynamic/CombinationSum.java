package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * 
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(candidates);
		backtrack(candidates, target, temp, result, 0);
		return result;
		
	}
	
	private void backtrack(int[] input, int target, List<Integer> temp, List<List<Integer>> result, int pos){
		
		if(target == 0){
			result.add(new ArrayList<>(temp));
		}
		
		for(int i=pos; i<input.length; i++){
			if(target < input[i]){
				return;
			}
			
			target = target - input[i];
			temp.add(input[i]);
			backtrack(input, target, temp, result, i);
			
			target = target + temp.get(temp.size()-1);
			temp.remove(temp.size()-1);
			
		}
	}
	
	public static void main(String[] args){
		
		CombinationSum cs = new CombinationSum();
		int[] cadidates = new int[]{5,3,2};
		
		System.out.println(cs.combinationSum(cadidates, 8));
	}

}
