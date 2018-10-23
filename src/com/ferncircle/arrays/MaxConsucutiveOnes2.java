package com.ferncircle.arrays;

public class MaxConsucutiveOnes2 {

	public int findMaxConsecutiveOnes(int[] nums) {

		int k =1;
		int zerosFlipped = 0;
		int globalMax =0;
		int tempMax = 0;
		
		for(int i=0; i< nums.length; i++){
			if((nums[i] == 0 && zerosFlipped < k) || nums[i] == 1){
				tempMax++;
				zerosFlipped++;
				
			}else if(nums[i] == 0 && zerosFlipped == k){
				zerosFlipped = 0;
				tempMax = 0;
			}
			globalMax = Math.max(globalMax, tempMax);
		}
		
		return globalMax;
				
	}

}
