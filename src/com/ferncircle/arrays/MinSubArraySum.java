package com.ferncircle.arrays;


/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 * @author dbrit00s
 * 
 * Solution:
 * Use two pointers
 * while(i+j >= target)
 * update length,sum and  move the slow pointer
 * 
 * 
 * else just keep moving the fast pointer
 *
 */
public class MinSubArraySum {

	public int minSubArrayLen(int s, int[] nums) {

		
		int i=0;
		int sum =0;
		int length = Integer.MAX_VALUE;
		for(int j=0; j< nums.length; j++){
			
			sum = sum + nums[j];
			while(sum >= s){
				length = Math.min(length, i - j+1);
				sum = sum - nums[i];
				i++;
			}
			
		}
		return length != Integer.MAX_VALUE? length: 0;
	}

	public static void main(String[] args) {
		
		

	}

}
