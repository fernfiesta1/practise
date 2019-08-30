package com.ferncircle.arrays;

import java.util.Arrays;

public class TwoSum2pointer {

	public int[] twoSum(int[] nums, int target) {

		Arrays.sort(nums);
		
		int i=0;
		int j= nums.length-1;
		int[] result = new int[2];
		while(i<j){
			int sum = nums[i] + nums[j];
			if(sum == target){
				result[0] = i;
				result[1] = j;
				return result;
			}
			
			if(sum < target){
				j--;
			}else{
				i++;
			}
		}
		
		return result;
	}

	
}
