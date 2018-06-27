package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

/**
 * @author dbrit00s
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {

		if(nums.length == 0)
			return 0;
		if(nums.length ==1) {
			return 1;
		}
		
		int j=1;
		int i=1;
		while(i<nums.length) {
			if(nums[i] == nums[j-1]) {
				i++;
			}else {
				nums[j] = nums[i];
				j++;
				i++;
			}
		}

		//System.out.println(Arrays.toString(nums));
		return j;



	}

	public static void main(String[] args) {

		RemoveDuplicates rd  = new RemoveDuplicates();
		assertThat(rd.removeDuplicates(new int[]{6,7,8,9}), is(new Integer(4)));
		assertThat(rd.removeDuplicates(new int[]{6}), is(new Integer(1)));
		assertThat(rd.removeDuplicates(new int[]{}), is(new Integer(0)));
		assertThat(rd.removeDuplicates(new int[]{6,6,12,12}), is(new Integer(2)));
		assertThat(rd.removeDuplicates(new int[]{6,6,6,8}), is(new Integer(2)));
		assertThat(rd.removeDuplicates(new int[]{6,6,6,6}), is(new Integer(1)));
		assertThat(rd.removeDuplicates(new int[]{6,6,7,8,9,9,9}), is(new Integer(4)));


		System.out.println("All test cases passed");

	}

}
