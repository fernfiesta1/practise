package com.ferncircle.twopointers;

import java.util.Arrays;

public class SmallestDifference {
	
	public int smallestDiff(int[] a, int[] b){
		
		int result = Integer.MAX_VALUE;
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int i=0;
		int j=0;
		
		while(i< a.length && j< b.length){
			
			int diff = Math.abs(a[i] - b[j]);
			//Return if differnce is 0. As there cant be a difference lesser than this.
			if(diff == 0){
				return diff;
			}
			
			//Update the result with the minimum difference
			result = Math.min(result, diff);
			
			//increment the pointer of the smaller element.
			if(a[i] < b[j]){
				i++;
			}else{
				j++;
			}		
			
		}
		
		return result;
		
	}
	

	public static void main(String[] args) {
		int[] a = new int[]{1,3,15,11,2};
		int[] b = new int[]{23,127,235,19,8};
		
		SmallestDifference sd = new SmallestDifference();
		System.out.println(sd.smallestDiff(a, b));

	}

}
