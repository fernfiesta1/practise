package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			backtrack(input, target, new ArrayList<>(temp), result, i);
			
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
