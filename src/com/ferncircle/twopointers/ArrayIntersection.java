package com.ferncircle.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayIntersection {
	
	public static int[] intersect(int[] nums1, int[]  nums2){
		
		int i =0;
		int j= 0;
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(i< nums1.length && j < nums2.length){
			if(nums1[i] == nums2[j]){
				result.add(nums1[i]);
				i++;
				j++;
			}else{
				if(nums1[i] < nums2[j]){
					i++;
				}else{
					j++;
				}
			}
		}
		
		int[] resu = new int[result.size()];
		for(int k=0; k< result.size(); k++){
			resu[k] = result.get(k);
		}
		
		return resu;
	}
	
	public static void main(String[] args){
		
		int[] a = new int[]{1,2,2,3,4};
		int[] b = new int[]{2,2,3,4};
		
		int[] result = intersect(a, b);
	}
	
	

}
