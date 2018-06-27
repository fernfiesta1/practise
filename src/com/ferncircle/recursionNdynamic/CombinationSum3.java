package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
