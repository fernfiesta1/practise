package com.ferncircle.recursionNdynamic;

import java.util.Arrays;

/**
 * 
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

Solution:
Sorting the array and then having two pointers doesnt work coz, subset could be a combination of small and large numbers
 * @author dbrit00s
 *
 */
public class PartitionEqualSubsetsRecursion {

	public boolean canPartition(int[] nums) {

		int sum =0;
		for(int i=0; i< nums.length; i++){
			sum += nums[i];
		}
		
		if(sum %2 != 0){
			return false;
		}
		
		int target = sum /2;		
		return helper(nums, target, 0);
		
	}
	
	private boolean helper(int[] nums, int target, int idx){
		if(target == 0){
			return true;
		}
		
		if(target < 0){
			return false;
		}
		
		for(int i = idx; i< nums.length; i++){
			target = target - nums[i];
			i = i+1;
			boolean result = helper(nums, target, i);
			if(result){
				return true;
			}
			i = i-1;
			target = target + nums[i];
		}
		
		return false;
		
	}
	
	public static void main(String[] args){
		PartitionEqualSubsetsRecursion pes = new PartitionEqualSubsetsRecursion();
		System.out.println(pes.canPartition(new int[]{2,2,2,2,4,4}));
	}

}
