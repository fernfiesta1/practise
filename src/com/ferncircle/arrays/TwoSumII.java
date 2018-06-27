package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

/**
 * @author dbrit00s
 * 
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 *
 */
public class TwoSumII {

	public int[] twoSum(int[] numbers, int target) {

		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i=0; i<numbers.length; i++) {
			int compliment = target - numbers[i];
			if(intMap.get(compliment) != null) {
				result[0] = intMap.get(compliment);
				result[1] = i+1;
			}	else {
				intMap.put(numbers[i], i+1);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		TwoSumII ts =  new TwoSumII();
		assertThat(ts.twoSum(new int[]{1,2,3,5,9}, 8), is(new int[] {3,4}));
		assertThat(ts.twoSum(new int[]{2, 7, 11, 15}, 9), is(new int[] {1,2}));
		System.out.println("Test successful");

	}

}
