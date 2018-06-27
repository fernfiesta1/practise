package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

/**
 * @author dbrit00s
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Better approach:(Doesnt retain the order.

public int removeElement(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
        if (nums[i] == val) {
            nums[i] = nums[n - 1];
            // reduce array size by one
            n--;
        } else {
            i++;
        }
    }
    return n;
}

 *
 */

//Retains the order.
public class RemoveElements {

	public int removeElement(int[] nums, int val) {

		int i=0;
		int result = 0;
		int curr = 0;
		int prev = 0;
		
		while(i<nums.length) {
			
			if(nums[prev] == val) {
				while(curr < nums.length) {
					if(nums[curr] == val) {
						curr++;
					}else {
						nums[prev] = nums[curr];
						nums[curr] = val;
						prev++;
						curr++;
						result++;
						break;
					}
				}
			}else {
				prev++;
				curr++;
				result++;
				
			}
			
			if(curr > nums.length) {
				break;
			}else {
				i++;
			}
		}
		
		System.out.println(Arrays.toString(nums));
		return result;
	}

	public static void main(String[] args) {
		
		RemoveElements re =  new RemoveElements();
		assertThat(re.removeElement(new int[]{6,7,8,9}, 6), is(new Integer(3)));
		assertThat(re.removeElement(new int[]{3,2,2,3}, 3), is(new Integer(2)));
		assertThat(re.removeElement(new int[]{3,3,3,3,3}, 3), is(new Integer(0)));
		assertThat(re.removeElement(new int[]{6,1,2,4,5,6}, 6), is(new Integer(4)));
		assertThat(re.removeElement(new int[]{3,3,3,3,3}, 7), is(new Integer(5)));
		assertThat(re.removeElement(new int[]{3}, 7), is(new Integer(1)));
		assertThat(re.removeElement(new int[]{3}, 3), is(new Integer(0)));
		System.out.println("Test successfull");
	}

}
