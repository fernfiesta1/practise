package com.ferncircle.arrays;

import junit.framework.Assert;


/**
 * @author dbrit00s
 * 
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0


Time Complexity : O(logn)
Space Complexity : O(1)

This is a Binary search example.

 *
 */
public class SearchInsert {

	
	public int searchInsert(int[] nums, int target) {

		int low = 0;
		int high = nums.length -1;
		
		if(nums[nums.length-1] < target) {
			return nums.length;
		}
		
		while(low <= high) {
			int guess = (low + high) /2;
			
			if(nums[guess]==target) {
				return guess;
			}
			
			if(nums[guess] < target) {
				low = guess +1;
			}else {
				high = guess -1;
			}
		}
		
		if(nums[low] < target) {
			return low+1;
		}else {
			return low;
		}	
		
	}

	public static void main(String[] args) {
		
		SearchInsert si = new SearchInsert();
		Assert.assertEquals(2, si.searchInsert(new int[] {1,3,5,6}, 5));
		Assert.assertEquals(1, si.searchInsert(new int[] {1,3,5,6}, 2));
		Assert.assertEquals(4, si.searchInsert(new int[] {1,3,5,6}, 7));
		Assert.assertEquals(0, si.searchInsert(new int[] {1,3,5,6}, 0));
		
		System.out.println("Test successful");

	}

}
