package com.ferncircle.twopointers;

public class TrapingRainWater {


	public int trap(int[] height) {

		int left_peak = 0;
		int right_peak =0;
		int water = 0;
		int left =0;
		int right=height.length -1;
		
		while(left<right){
			
			if(height[left] < height[right]){
				if(left_peak>height[left]){
					water = water + (left_peak - height[left]);
				}else{
					left_peak = height[left];
				}
				left++;
			}else{
				if(right_peak > height[right]){
					water = water + (right_peak - height[right]);
				}else{
					right_peak = height[right];
				}
				right++;
			}
		}
		
		return water;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
