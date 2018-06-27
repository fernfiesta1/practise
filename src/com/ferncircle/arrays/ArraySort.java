package com.ferncircle.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

public class ArraySort {

	public int[] sort(int[] a){
		if(a==null || a.length<2)
			return a;
		
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));	
		return a;
	}
	public static void main(String[] args) {
		
		
		assertThat(new ArraySort().sort(new int[]{6,23,12,5}), is(new int[]{5,6,12,23}));
		
		System.out.println("All test cases passed");
		
	}

}
