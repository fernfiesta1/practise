package com.ferncircle.arrays;


/**
 * 
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * @author dbrit00s
 * 
 * This seems like a variation of Kadene's Algorithm.
 * 
 * Maintain maxSum and minSum.
 * Either the current element by itself is max or multiplied with the maxSum is max.
 * If the current element is negative, then minSum becomes maxSum and vice versa
 *
 */
public class MaximumProductSubarray {

	
	public int maxProduct(int[] nums) {

		int globalMax = nums[0];
		int maxSum = nums[0];
		int minSum = nums[0];
		
		for(int i=1; i< nums.length; i++){
			if(nums[i] < 0){
				int temp = maxSum;
				maxSum = minSum;
				minSum = temp;
			}
			
			maxSum = Math.max(maxSum * nums[i], nums[i]);
			minSum = Math.min(minSum * nums[i], nums[i]);
			globalMax = Math.max(globalMax, maxSum);
		}
		return globalMax;
	}
	
	public static void main(String[] args){
		MaximumProductSubarray mps = new MaximumProductSubarray();
		mps.maxProduct(new int[]{0,-1,2,3,0,1,-2,5});
	}

}
