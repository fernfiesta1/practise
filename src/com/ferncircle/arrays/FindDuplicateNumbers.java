package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dbrit00s
 *
 *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

Algorithm:
1st parse --> Mark elements as negative at the location of the input element. 
2nd parse --> Go through the array and location whose elemts are positive. 
return location +1


 */
public class FindDuplicateNumbers {

	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i< nums.length;i++){
			int temp = Math.abs(nums[i]);
			if(nums[temp-1] > 0){
				nums[temp-1] = -nums[temp-1];
			}else{
				result.add(temp);
			}
		}
		
		
		return result;
	}


	public static void main(String[] args) {
		FindDuplicateNumbers fn = new FindDuplicateNumbers();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
		System.out.println(fn.findDuplicates(nums));
	}

}
