package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

Intuition:

Sort the array first.for each element in the array, run twoSum logic on rest of the Array.
to avoid duplicates. If the sum of two elements is equal to target(in two sum logic), skip those elements until you find the next set of elements.
 * @author dbrit00s
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if(nums.length<3){
			return result;
		}
		
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++){
			
			if(i>0 && nums[i] == nums[i-1]){
				continue;
			}
			int target = Math.negateExact(nums[i]);
			List<List<Integer>> twoSumResult = getTwoSum(nums, target, i+1);
			if(!twoSumResult.isEmpty()){
				for(List<Integer> list: twoSumResult){
					list.add(nums[i]);
					result.add(list);
				}
			}
		}		
		
		return result;
	}

	
	public List<List<Integer>> getTwoSum(int[] nums, int target, int start){
		
		List<List<Integer>> result = new ArrayList<>();
		int end = nums.length-1;
		while(start < end){		
			
			int sum = nums[start] + nums[end];
			if(sum == target){
				List<Integer> res = new ArrayList<>();
				res.add(nums[start]);
				res.add(nums[end]);
				result.add(res);
				
				//this is the part to avoid duplicate combinations.
				while(start < end && nums[start] == nums[start+1]){
					start++;
				}
				
				while(start<end && nums[end] == nums[end-1]){
					end--;	
				}
				
				start++;
				end--;
			}else if(sum > target){
				end--;
			}else{
				start++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		ThreeSum threesum = new ThreeSum();
		int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(threesum.threeSum(nums));

	}

}
