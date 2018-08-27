package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.List;

public class DivingBoard {
	
	public void getCombinations(int k){
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		helper(k, new int[]{1,2}, result, temp);
		System.out.println(result);
	}
	
	private void helper(int k, int[] input, List<List<Integer>> result, List<Integer> temp){
		
		if(k==0){
			result.add(new ArrayList(temp));
			return;
		}
		
		for(int i=0; i< input.length; i++){
			temp.add(input[i]);
			k--;
			helper(k, input, result, temp);
			k++;
			temp.remove(temp.size()-1);
		}
		
	}
	public static void main(String[] args){
		DivingBoard db = new DivingBoard();
		db.getCombinations(3);
	}

}
