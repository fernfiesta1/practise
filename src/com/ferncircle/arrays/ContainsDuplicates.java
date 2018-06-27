package com.ferncircle.arrays;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

/**
 * @author dbrit00s
 * 
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 *Space Complexity - O(n)
 *Time Complexity - O(n)
 *
 *to do this without using extra space refer to FindDuplicateNumbers.java
 */
public class ContainsDuplicates {

	public boolean containsDuplicate(int[] nums) {

		Set<Integer> elements = new HashSet<Integer>();
		
		for(int i: nums) {
			if(elements.contains(i)) {
				return true;
			}else {
				elements.add(i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		ContainsDuplicates cd = new ContainsDuplicates();
		Assert.assertEquals(true, cd.containsDuplicate(new int[] {1,2,3,1}));
		Assert.assertEquals(false, cd.containsDuplicate(new int[] {1,2,3,4}));
		
		System.out.println("Test successful");

	}

}
