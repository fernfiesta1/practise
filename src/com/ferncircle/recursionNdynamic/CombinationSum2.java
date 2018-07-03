package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author dbrit00s
 *Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class CombinationSum2 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		
		Map<Integer, Integer> elementCount = new TreeMap<>();
		// Count the number of unique Integers in the input array
		for (Integer i : candidates) {
			elementCount.compute(i, (k, v) -> (v == null) ? 1 : (v + 1));
		}

		// Create input array of unique integers
		int[] input = new int[elementCount.size()];
		// Create count array of elements in the input array
		int[] count = new int[elementCount.size()];

		int i = 0;
		for(Integer key: elementCount.keySet()){
			input[i] = key;
			count[i] = elementCount.get(key);
			i++;
		}
		
		backtrack(input,count, target, temp, result, 0);
		return result;
		
	}
	
	private void backtrack(int[] input, int[] count, int target, List<Integer> temp, List<List<Integer>> result, int pos){
		
		if(target == 0){
			result.add(new ArrayList<>(temp));
		}
		
		for(int i=pos; i<input.length; i++){
			
			if(count[i] == 0){
				continue;
			}
			if(target < input[i]){
				return;
			}
			
			target = target - input[i];
			count[i]--;
			temp.add(input[i]);
			backtrack(input,count, target,temp, result, i);
			
			target = target + temp.get(temp.size()-1);
			temp.remove(temp.size()-1);
			count[i]++;
			
		}
	}
	
	public static void main(String[] args){
		
		CombinationSum2 cs = new CombinationSum2();
		int[] cadidates = new int[]{10,1,2,7,6,1,5};
		
		System.out.println(cs.combinationSum(cadidates, 8));
	}

}
