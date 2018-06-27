package com.ferncircle.recursionNdynamic;

/**
 * 
 * Magic Index in an array A[1 --n-1] is defined to be an indes such that A[i] = i.
 * Given a sorted array of distinct integers write a method to find a magic index if one exists.
 */

public class MagicIndex {
	
	public static int findIndex(int[] input, int startIndex, int endIndex){
		
		if(startIndex > endIndex){
			return -1;
		}
		
		int mid = (startIndex + endIndex)/2;
		if(input[mid] == mid){
			return mid;
		}
		
		if(input[mid] < mid){
			return findIndex(input, mid +1, endIndex);
		}else{
			return findIndex(input, startIndex, mid-1);
		}	
		
	}

	public static void main(String[] args) {
		
		int[] input = new int[]{-30,-20,-10,1,3,5,8,9};
		System.out.println(findIndex(input, 0, input.length-1));
		
		int[] input2 = new int[]{-30,1,3,5,9,8};
		System.out.println(findIndex(input2, 0, input2.length-1));

	}

}
