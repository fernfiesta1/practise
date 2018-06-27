package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Permutation {

	public List<List<Integer>> permute(int[] nums) {

		Map<Integer, Integer> elementCount = new TreeMap<>();
		// Count the number of unique Integers in the input array
		for (Integer i : nums) {
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
		
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<Integer>();
		//backtrack(nums, tempList, result);
		backtrackCombi(input, count, tempList, result, nums.length);
		return result;
	}
	
	private void backtrackCombi(int[] input, int[] count, List<Integer> tempList, List<List<Integer>> result, int depth){
		
		if(tempList.size() == depth){
			result.add(new ArrayList<Integer>(tempList));
		}
		
		for(int i=0; i< input.length; i++){
			
			if(count[i] == 0){
				continue;
			}
			
			tempList.add(input[i]);
			count[i]--;
			backtrackCombi(input, count, tempList, result, depth);
			tempList.remove(tempList.size() -1);
			count[i]++;
		}
		
	}
	
	/*private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result){
	System.out.println(tempList + "--> templist");
	if(tempList.size() == nums.length){
		result.add(new ArrayList<Integer>(tempList));
	}
	
	for(int i=0; i<nums.length; i++){
		if(tempList.contains(nums[i])){
			continue;
		}
		
		tempList.add(nums[i]);
		backtrack(nums, tempList, result);
		tempList.remove(tempList.size()-1);
	}
}	*/
		
	public static void main(String[] args){
		
		Permutation per = new Permutation();
		System.out.println(per.permute(new int[]{1,1,2}));
		
	}


}
