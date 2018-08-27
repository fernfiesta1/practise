package com.ferncircle.arrays;

/**
 * 
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

 * @author dbrit00s
 *
 */
public class SubSort {

	public int findUnsortedSubarray(int[] nums) {


		int a = getStartBreakIndex(nums);
		//array is already sorted
		if(a == 0){
			return 0;
		}

		int b = getEndBreakIndex(nums);
		//array is already sorted
		if(b == nums.length-1){
			return 0;
		}	


		int min = Integer.MAX_VALUE;
		for(int i=a; i< nums.length; i++){
			min = Math.min(min, nums[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = b; i>=0; i--){
			max = Math.max(max, nums[i]);
		}


		//find location of the small and large element from step 3
		int i=0;
		while(nums[i] <= min){
			i++;
		}

		int j=nums.length-1;
		while(nums[j] >= max){
			j--;
		}

		int diff = (j-i) + 1;
		return diff;
	}

	//1 -- find the index of element that breaks the start chain
	private int getStartBreakIndex(int[] nums){

		int previous = nums[0];
		for(int i=1; i< nums.length; i++){
			if(previous > nums[i]){
				return i;
			}
			previous = nums[i];
		}

		return 0;
	}

	private int getEndBreakIndex(int[] nums){

		int previuos = nums[nums.length-1];
		for(int i=nums.length-2; i>=0; i--){
			if(previuos < nums[i]){
				return i;
			}
			previuos = nums[i];
		}

		return nums[nums.length-1];
	}


	public static void main(String[] args) {
		SubSort ss = new SubSort();
		System.out.println(ss.findUnsortedSubarray(new int[]{2,3,3,1,2,4,6}));

	}

}
