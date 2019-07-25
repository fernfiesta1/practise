package com.ferncircle.recursionNdynamic;

import java.util.Arrays;

/**
 * 
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * Example 1: Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4 Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums.
 * 
 * @author dbrit00s
 *
 */
public class PartitionKEqualSets {

	public boolean canPartitionKSubsets(int[] nums, int k) {

		if (nums.length == 0) {
			return true;
		}

		int sum = getSum(nums);
		int target = sum / k;
		if (sum % k != 0) {
			return false;
		}

		/*
		 * int count = 0; boolean[] visited = new boolean[nums.length];
		 * Arrays.sort(nums); while(count < k){ if(!helper(nums, visited, target,
		 * nums.length-1)){ return false; } count++; }
		 * 
		 * return true;
		 */
		return helper(nums, new boolean[nums.length], target, nums.length - 1);

	}

	private boolean helper(int[] nums, boolean[] visited, int target, int idx) {
		if (idx < 0)
			return false;
		if (target == 0) {
			return true;
		}
		if (target < 0) {
			return false;
		}
		boolean result = false;
		for (int i = idx; i >= 0; i--) {
			if (visited[i] == true) {
				continue;
			}
			visited[i] = true;

			result = helper(nums, visited, target - nums[i], i - 1) || helper(nums, visited, target, i - 1);

			visited[i] = false;

		}

		return result;
	}

	private int getSum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		PartitionKEqualSets pes = new PartitionKEqualSets();
		System.out.println(pes.canPartitionKSubsets(new int[] { 3, 2, 5 }, 2));
	}
}
