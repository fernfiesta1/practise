package com.ferncircle.arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author dbrit00s
 * 
 * link: https://leetcode.com/problems/move-zeroes/#/description
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 *
 */
public class MoveZeroes {	

	public int[] solution(int[] nums) {
		
		int i = 0;
		int j = 0;
		if(nums.length==0) {
			 return nums;
		}
		
		while(i<nums.length && j < nums.length) {
			if(nums[i] == 0) {
				if(nums[j] == 0) {
					j++;
				}else {
					nums[i] = nums[j];
					nums[j] = 0;
					i++;
					j++;
				}
			}else {
				i++;
				j++;
			}
		}
		

		return nums;
		
	}
	
	public static void main(String[] args) {
		
		assertThat(new MoveZeroes().solution(new int[] {0,0}), is(new int[]{0,0}));
		assertThat(new MoveZeroes().solution(new int[] {0,1}), is(new int[]{1,0}));
		assertThat(new MoveZeroes().solution(new int[] {0,1,0,3,12}), is(new int[]{1,3,12,0,0}));
		assertThat(new MoveZeroes().solution(new int[] {0,0,0,3,12}), is(new int[]{3,12,0,0,0}));
		assertThat(new MoveZeroes().solution(new int[] {1,1,0,3,12}), is(new int[]{1,1,3,12,0}));
		assertThat(new MoveZeroes().solution(new int[] {1}), is(new int[]{1}));
		assertThat(new MoveZeroes().solution(new int[] {0}), is(new int[]{0}));
		
		System.out.println("Test successful");
				
	}

}
