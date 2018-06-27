package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;


/**
 * @author dbrit00s
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * Extend the Moore's voting Algorithm for this one
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 *
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {

		int maxIndex1 = 0;
		int count1 =0;
		int maxIndex2=0;
		int count2=0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == nums[maxIndex1]) {
				count1++;
			}else if(nums[i] == nums[maxIndex2]) {
				count2++;
			}else if(count1 ==0) {
				maxIndex1 = i;
				count1++;
			}else if(count2 == 0) {
				maxIndex2 = i;
				count2++;
			}else {
				count1--;
				count2--;
			}
			
			
		}
		
		count1=0;
		count2=0;
		
		for(int i=0; i< nums.length; i++) {
			if(nums[i] == nums[maxIndex1]) {
				count1++;
			}else if(nums[i] == nums[maxIndex2]) {
				count2++;
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		if(count1>nums.length/3) {
			result.add(nums[maxIndex1]);
		}
		if(count2>nums.length/3) {
			result.add(nums[maxIndex2]);
		}
		
		
		return result;
	}
	
	

	public static void main(String[] args) {
		
		MajorityElementII me = new MajorityElementII();
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		res.add(0);
		assertThat(me.majorityElement(new int[]{1,1,1,0,0}), is(res));
		
		System.out.println("Test Successful");

	}





}
