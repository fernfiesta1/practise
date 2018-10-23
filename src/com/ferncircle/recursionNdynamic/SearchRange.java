package com.ferncircle.recursionNdynamic;


/**
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * @author dbrit00s
 * 
 * Solution:
 * 
 * Do binary search on the left side to find the start index
 * Do binary search on the right side to find the end index
 * 
 * didnt understand: why we do hi = arr.length
 * and return hi -1;
 *
 */
public class SearchRange {

public int[] searchRange(int[] nums, int target) {
		
		int[] result = new int[]{-1, -1};
       if(nums.length == 0){
			return result;
		}
		//Get the leftmost index
		int lo = helper(nums, target, true);
	
		//Check if the returned index contains the target element.
		if(lo >= nums.length || nums[lo] != target){
			return result;
		}
		//Get the rightmost index
		int hi = helper(nums, target, false);
		result[0] = lo;
		result[1] = hi-1;
		
		return result;

	}
	
	private int helper(int[] nums, int target, boolean leftSide){
		
		int lo = 0;
		int hi = nums.length;
		
		while(lo < hi){
			int mid = (lo + hi)/2;
			
			if(nums[mid] > target || (leftSide && nums[mid] == target)){
				hi = mid;
			}else{
				lo = mid + 1;
			}
		}
		
		return lo;
	}

	public static void main(String[] args) {
		
		SearchRange sr = new SearchRange();
		int[] result = sr.searchRange(new int[]{2,2}, 3);
		System.out.println(result[0] + "," + result[1]);

	}

}
