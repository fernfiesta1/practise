package com.ferncircle.arrays;

public class TriangleNumber {

	public int triangleNumber(int[] nums) {

		if(nums == null || nums.length < 3){
			return 0;
		}

		int length = nums.length -1;
		int result =0;
		for(int i = length; i>=0; i--){
			for(int j = i-1; j>=0; j--){

				for(int k=0; k< j; k++){
					if(nums[k]+nums[j] > nums[i]){
						result += (j-k);
						break;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		

		int[] input = new int[] {2,2,3,4};
		TriangleNumber tn = new TriangleNumber();
		System.out.println(tn.triangleNumber(input));
	}

}
