package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dbrit00s
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Solution:

Moore's voting algorithm:
Finding a Candidate:
The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.

findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]

NOTE:
It is used for problems where you're given a list of 'N' values and you know that a particular VALUE OCCURS MORE THAN 'N/2' times;
Else, we cannot determine the maximum occurring element in linear time with constant extra space.
 *
 */
public class MajorityElelment {

	public int majorityElement(int[] nums) {

		int max_index = 0;
		int count =0;

		for(int i=0; i< nums.length; i++) {
			if(nums[max_index] == nums[i]) {
				count++;
			}else {
				count--;
			}

			if(count == 0) {
				max_index = i;
				count = 1;
			}
		}

		return nums[max_index];
	}
	

	public static void main(String[] args) {
		MajorityElelment me = new MajorityElelment();
		assertThat(me.majorityElement(new int[]{1,1,1,0,0}), is(new Integer(1)));
		assertThat(me.majorityElement(new int[] {2,2,3,5,2,2,6}), is(new Integer(2)));
		

		System.out.println("Test successful");

	}
}
