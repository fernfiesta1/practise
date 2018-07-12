package com.ferncircle.arrays;

import java.util.Arrays;

public class MergeArrays {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m-1;
		int j = n-1;
		int k = nums1.length-1;
		
		while(k>=0){
			if(j< 0){
				break;
			}
			
			if(i >= 0 && nums1[i] > nums2[j]){
				nums1[k] = nums1[i];
				i--;
			}else{
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
	}

	public static void main(String[] args) {

		
		int[] nums1 = new int[]{2,8,10,12,0};
		int[] nums2 = new int[]{1};
		
		MergeArrays ma = new MergeArrays();
		ma.merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
		for(int i=0; i<nums1.length; i++){
			System.out.println(nums1[i] + ",");
		}

	}

}
