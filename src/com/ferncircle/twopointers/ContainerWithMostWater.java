package com.ferncircle.twopointers;


public class ContainerWithMostWater {

	public int maxArea(int[] height) {

		int i = 0;
		int j = height.length-1;
		int result = 0;
		while(i<j){
			int h = Math.min(height[i], height[j]);
			int l = j-i;
			
			result = Math.max(result, getVolume(l, h));
			if(height[i] <= height[j]){
				i++;
			}else{
				j--;
			}
			
		}
		
		
		return result;
	}
	
	private int getVolume(int length, int height){
		return length * height;
	}
}
