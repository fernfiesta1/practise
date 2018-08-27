package com.ferncircle.arrays;

public class ProductOfArrayExceptSelf {


	public int[] productExceptSelf(int[] nums) {

		int[] out = new int[nums.length];
		for(int i=0; i< out.length; i++){
			out[i] = 1;
		}
		
		//Calculate the product of all the element to the left of the element.
		int productSoFarFromleft = 1;		
		for(int i=0; i< nums.length-1; i++){
			out[i] = productSoFarFromleft*out[i];
			productSoFarFromleft = productSoFarFromleft*nums[i];
		}	
		
		//Calculate the product of all the elements to the right of the element and multiply with the left one.
		int productSoFar = 1;	
		for(int i=nums.length-1; i>=0; i--){
			out[i] = productSoFar*out[i];
			productSoFar = productSoFar*nums[i];
		}
		
		return out;
	}
	public static void main(String[] args) {
		
		int[] input = new int[]{1,2,3,4};
		ProductOfArrayExceptSelf ps = new ProductOfArrayExceptSelf();
		ps.productExceptSelf(input);
	}

}
