package com.ferncircle.recursionNdynamic;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		
		int[] dp = new int[nums.length];
		int maxL = 0;
		
		for(int i=0; i< dp.length; i++){
			int max = 0;
			for(int j=0; j<i; j++){
				if(nums[i] > nums[j]){
					max = Math.max(max, dp[j]);
				}				
			}
			dp[i] = max + 1;
			maxL = Math.max(maxL, dp[i]);
		}
		
		return maxL;
	}	
	
	public static void main(String[] args) {
		
		int[] nums = new int[]{10,20,5};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(nums));

	}

}
