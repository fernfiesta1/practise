package com.ferncircle.sortingNSearching;

public class MergeSort {
	
	public void sort(int[] arr) {
		
		helper(arr, 0, arr.length-1);
		
	}

	private void helper(int[] arr, int low, int high) {
		
		if(low < high) {
			int mid = (low + high)/2;
			helper(arr, low, mid);
			helper(arr, mid+1, high);
			merge(low, mid, high, arr);
		}
	}
	
	private void merge(int low, int mid, int high, int[] arr) {
		
		int[] temp = new int[(high - low) + 1];
		
		int i = low;
		int ilen = low + ((mid - low) + 1);
		int j = mid + 1;
		int jLen = mid + ((high - mid)) + 1;
		int k=0;
		
		while(i<ilen && j < jLen) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i<ilen) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		
		while(j<jLen) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		
		for(int t =0; t< temp.length; t++) {
			arr[low] = temp[t];
			low++;
		}
	}
	
	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		int[] input = new int[] {4};
		ms.sort(input);
		for(int i=0; i< input.length; i++) {
			System.out.println(input[i]);
		}
	}
}
