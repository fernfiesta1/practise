package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



/**
 * @author dbrit00s
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 *
 */
public class MaxConsecutiveOnes {

	/*public int findMaxConsecutiveOnes(int[] nums) {

		int currentMax =0;
		int maxOnes =0;

		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				maxOnes+=1;
			}else {
				if(currentMax < maxOnes) {
					currentMax = maxOnes;					
				}
				maxOnes = 0;
			}
		}

		if(currentMax >= maxOnes) {
			return currentMax;
		}else {
			return maxOnes;
		}

	}*/

	public int findMaxConsecutiveOnes(int[] nums) {
		int max =0;
		int curMax =0;

		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 1) {
				curMax++;
				max=Math.max(max, curMax);				
			}else {
				curMax = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {

		MaxConsecutiveOnes mx = new MaxConsecutiveOnes();
		/*assertThat(mx.findMaxConsecutiveOnes(new int[]{1,1,1,0,0,0,1,0,1,1}), is(new Integer(3)));
		assertThat(mx.findMaxConsecutiveOnes(new int[]{0,0,0,0}), is(new Integer(0)));
		assertThat(mx.findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1,1,1}), is(new Integer(8)));	*/
		assertThat(mx.findMaxConsecutiveOnes(new int[]{1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1}), is(new Integer(9)));
		assertThat(mx.findMaxConsecutiveOnes(mx.getIntArray(2840)), is(new Integer(2840)));

		System.out.println("Test successfull");


	}


	private int[] getIntArray(int num) {

		int[] arr = new int[num];
		for(int i=0; i< num; i++) {
			arr[i] = 1;
		}

		System.out.println(arr.length);

		return arr;
	}

}
