package com.ferncircle.recursionNdynamic;


/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * 
 * Solution:
 * Use Kadane's Algorithm:
 *
 *
 */

//TODO: Try to expalin thid to stany
public class MaximumSubArray {


	public int maxSubArray(int[] nums) {
		
		int maxGlobal = nums[0];
		int maxSoFar = nums[0];
		
		for(int i =1; i< nums.length; i++){
			maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
			if(maxSoFar > maxGlobal){
				maxGlobal = maxSoFar;
			}			
		}
		return maxGlobal;

	}

	public static void main(String[] args) {
		MaximumSubArray msa = new MaximumSubArray();
		System.out.println(msa.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		

	}

}
