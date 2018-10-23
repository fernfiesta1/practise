package com.ferncircle.recursionNdynamic;


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
 * @author dbrit00s
 *
 */
public class PartitionEqualSetsDP {

	public boolean canPartition(int[] nums) {

		if(nums.length == 0){
			return true;
		}
		int sum = getSum(nums);
		if(sum%2 != 0){
			return false;
		}
		
		int target = sum/2;
		boolean[][] dp = new boolean[nums.length][target + 1];
		
		//Fill the rows
		for(int i=0; i< dp.length; i++){
			dp[i][0] = true; //since dp[0][0] = true for empty array, all the subsequent values can be true
		}
		
		//Fill columns
		for(int j=1; j< dp[0].length; j++){
			dp[0][j] = false;
		}
		
		for(int i=1; i< dp.length; i++){
			for(int j=1; j<dp[0].length; j++){
				
				dp[i][j] = dp[i-1][j]; //donot use the value at nums[i]
				if(nums[i-1]<=j){
					dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];					
				}
			}
		}		
		
		return dp[dp.length-1][dp[0].length-1];
	}
	
	private int getSum(int[] nums){
		int sum = 0;
		for(int i=0; i< nums.length; i++){
			sum += nums[i];
		}
		
		return sum;
	}

	public static void main(String[] args){
		PartitionEqualSetsDP pes = new PartitionEqualSetsDP();
		System.out.println(pes.canPartition(new int[]{2,2,2,2,4,4}));
	}
}
