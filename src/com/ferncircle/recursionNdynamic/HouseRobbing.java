package com.ferncircle.recursionNdynamic;

/**
 * 
 * 
 * @author dbrit00s
 *
 */
public class HouseRobbing {

	public int rob(int[] nums){
		
		if(nums.length == 0){
			return 0;
		}
		if(nums.length ==1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		int[] dp = new int[nums.length];		
		dp[0]= nums[0];		
		dp[1]= Math.max(nums[0], nums[1]);
		
		for(int i=2; i< nums.length; i++){
			int option1 = dp[i-1];
			int option2 = nums[i] + dp[i-2];
			dp[i] = Math.max(option1, option2);
		}
		return dp[nums.length-1];
	}

	
	public static void main(String[] args){
		HouseRobbing hr = new HouseRobbing();
		System.out.println(hr.rob(new int[]{1,2,3,1}));
	}
}
