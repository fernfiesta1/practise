package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 * @author dbrit00s
 *
 */
public class CombinationSum3 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		
		int[] input = new int[]{1,2,3,4,5,6,7,8,9};
		int[] count = new int[]{1,1,1,1,1,1,1,1,1};
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		
		backtrack(input, count, n, temp, result, 0, k);
	
		return result;
		
	}
	
	private void backtrack(int[] input,int[] count, int target, List<Integer> temp, List<List<Integer>> result, int pos, int num){
		
		if(temp.size() == num && target == 0){
			result.add(new ArrayList<>(temp));
		}		
		
		for(int i=pos; i< input.length; i++){
			if(temp.size() == num || target < 0){
				return;
			}
			
			if(count[i] == 0){
				continue;
			}
			
			count[i]--;
			temp.add(input[i]);
			target = target - input[i];
			backtrack(input, count, target, new ArrayList<>(temp), result, i, num);
			count[i]++;
			temp.remove(temp.size() -1);
			target =target + input[i];
			
			
		}
	}
	
	public static void main(String[] args){
		
		CombinationSum3 cs = new CombinationSum3();
		System.out.println(cs.combinationSum3(3, 9));
		
	}

}
