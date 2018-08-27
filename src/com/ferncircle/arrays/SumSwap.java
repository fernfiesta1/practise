package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two array of Integers, find a pair of values(one value from each array) that you can swap to give the two arrays the same sum.
 * 
 * 
 * @author dbrit00s
 *
 */
public class SumSwap {
	
	public List<Integer> getNumbers(int[] a, int[] b){
	
		List<Integer> result = new ArrayList<>();
		if(a.length == 0 && b.length==0){
			return result;
		}
		//Sort both the arrys
		Arrays.sort(a);
		Arrays.sort(b);
		
		//Get the sum of both the arrays
		int sumA = getSum(a);
		int sumB = getSum(b);
		int diff = Math.abs(sumA- sumB);
		
		int i=a.length-1;
		int j=0;
		while(i>=0 && j<b.length){
			int sum = a[i] + b[j];
			if(sum == diff){
				result.add(a[i]);
				result.add(b[j]);
				break;
			}else{
				if(sum < diff){
					j++;
				}else{
					i--;
				}
			}
		}
		
		return result;
	}
	
	private int getSum(int[] a){
		
		int sum =0;
		for(int in: a){
			sum+=in;
		}
		return sum;
	}

	public static void main(String[] args){
		int[] a= new int[]{4,5,2,3,1,2};
		int[] b = new int[]{3,6,3,3};
		
		SumSwap ss = new SumSwap();
		System.out.println(ss.getNumbers(a, b));
	}
}
