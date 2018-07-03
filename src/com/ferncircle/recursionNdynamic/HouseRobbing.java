package com.ferncircle.recursionNdynamic;

public class HouseRobbing {

	public int rob(int[] nums) {

		if(nums.length == 0){
			return 0;
		}
		int profitEven =0;
		int profitOdd = 0;
		for(int i=0; i<nums.length; i++){
			if(i%2==0){
				profitEven +=nums[i];
			}else{
				profitOdd += nums[i];
			}
		}
		
		return Math.max(profitEven, profitOdd);
	}

}
