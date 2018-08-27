package com.ferncircle.arrays;

import java.util.Arrays;

public class WiggleSortWithDups {
	
public void wiggleSortWithDups(int[] nums) {
		
		Arrays.sort(nums);
		int mid = nums.length/2;
		if(nums.length%2!= 0){
			mid = mid+1;
		}
		for(int i=1; i< nums.length/2; i+=2){
			swap(nums, i, mid);
			mid = mid+2;
		}
		
		if(nums.length%2 !=0){
			if(nums[nums.length-2] < nums[nums.length-1]){
				swap(nums, nums[nums.length-2], nums[nums.length-1]);
			}
		}		
	}
	
	private void swap(int[] nums, int first, int second){
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public static void main(String[] args) {
		
		WiggleSortWithDups ws = new WiggleSortWithDups();
		int[] nums = new int[]{1,2,2,1,2,1,1,1,1,2,2,2};
		ws.wiggleSortWithDups(nums);
		for (int i : nums)
            System.out.print(i + " ");

	}

}
