package com.ferncircle.arrays;

public class InfiniteSortedArray {

	public int search(int[] input, int element){
		
		int low = 0;
		int high = 1;
		
		while(input[high] != -1 && input[high] < element){
			low = high;
			high = high*2;
		}		
		return binarySearch(input, low, high, element);
	}
	
	private int binarySearch(int[] arr, int lo, int hi, int element){
		
		if(lo > hi){
			return -1;
		}
		
		int mid = (lo + hi)/2;	
		
		if(arr[mid] == element){
			return mid;
		}
		
		if(arr[mid] == -1){
			return binarySearch(arr, lo, mid-1, element);
		}else{
			if(arr[mid] > element){
				return binarySearch(arr, lo, mid-1, element);
			}else{
				return binarySearch(arr, mid+1, hi, element);
			}
		}		 
		
	}
	
	public static void main (String[] args) {
		
		int[] input = new int[]{1,1,1,2,2,3,4,5,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
		InfiniteSortedArray isa = new InfiniteSortedArray();
		System.out.println(isa .search(input, 7));
	}
}
