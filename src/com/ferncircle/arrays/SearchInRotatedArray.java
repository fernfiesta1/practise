package com.ferncircle.arrays;


/**
 * @author dbrit00s
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
 *
 */
public class SearchInRotatedArray {

	public int search(int[] nums, int target) {

		if(nums.length == 0){
			return -1;
		}
		return helper(nums, 0, nums.length-1, target);
	}
	
	private int helper(int[] nums, int lo, int hi, int target){
		if(lo > hi){
			return -1;
		}
		
		int mid = (lo + hi)/2;
		if(nums[mid] == target){
			return mid;
		}	
		
		//check if left half is sorted
		if(nums[lo] <= nums[mid]){
			if(nums[lo] <= target && target <= nums[mid]){
				return helper(nums, lo, mid-1, target);
			}else{
				return helper(nums,mid+1,hi, target);
			}
		//if right half is sorted
		}else{
			if(nums[mid] <= target && target <= nums[hi]){
				return helper(nums,mid+1,hi, target);
			}else{
				return helper(nums, lo, mid-1, target);
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		SearchInRotatedArray s = new SearchInRotatedArray();
		System.out.println(s.search(new int[]{4,1,3}, 3));

	}

}
