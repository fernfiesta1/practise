package com.ferncircle.recursionNdynamic;

public class HouseRobber2 {

	public int rob(int[] nums){
		if(nums.length == 0){
			return 0;
		}

		if(nums.length == 1){
			return nums[0];
		}

		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		if(nums.length == 3){
			return Math.max(Math.max(nums[0], nums[1]), nums[2]);
		}

		int[] nums1 = new int[nums.length-1];
		int[] nums2 = new int[nums.length-1];

		for(int i=0; i<nums1.length; i++){
			nums1[i] = nums[i];
		}

		for(int i=0; i<nums2.length; i++){
			nums2[i] = nums[i+1];
		}
		
		return Math.max(rob1(nums1), rob1(nums2));
	}

	public int rob1(int[] nums){

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

	public static void main(String[] args) {

		HouseRobber2 hr = new HouseRobber2();
		int[] input = new int[]{1,2,3,4,8,9};
		System.out.println(hr.rob(input));

	}

}
