package com.ferncircle.arrays;


/**
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * @author dbrit00s
 * 
 * Intuition:
 * 
 * sum of first n integers is n(n+1)/2
 * so the result is difference between  sum of all the elements in the array and total sum.  
 *
 */
public class MissingNumber {

	public int missingNumber(int[] nums) {
		
		int arrLength = nums.length;
		int totalSum = (arrLength * (arrLength + 1))/2;
		
		int sum = 0;
		for(int i=0; i< arrLength; i++){
			sum+= nums[i];
		}
		
		return totalSum - sum;
	}

	public static void main(String[] args) {

		int[] in1 = new int[]{0,1,2};
		MissingNumber mn = new MissingNumber();
		System.out.println(mn.missingNumber(in1));
	}

}
