package com.ferncircle.recursionNdynamic;

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
