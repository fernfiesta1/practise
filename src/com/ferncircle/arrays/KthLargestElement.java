package com.ferncircle.arrays;

public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {

		return quickSelect(nums, 0, nums.length-1, k);				
		
	}
	
	private int quickSelect(int[] nums, int lo, int hi, int k){
		if(k > nums.length){
			return 1;
		}
		
		//Get the pivot index
		int index = getPivotIndex(nums,lo, hi);		
		
		int expectedPosOfPivot = nums.length -k;
		if(index == expectedPosOfPivot){
			return nums[index];
		}
		
		if(index > expectedPosOfPivot){
			//search left
			return quickSelect(nums, 0, index-1, k);
		}else{
			//search right
			return quickSelect(nums, index+1, hi, k);
		}
	}
	
	private int getPivotIndex(int[] nums, int lo, int hi){
		int pivot = nums[hi];
		int i = lo-1;
		int j = lo;
		
		while(j <nums.length-1){
			if(nums[j] < pivot){
				//swap the elements at i+1'th and j'th index 
				i = i+1;
				swap(nums, i, j);
			}
			j++;
		}
		swap(nums, ++i, hi);
		return i;
		
	}
	
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		KthLargestElement test = new KthLargestElement();
		System.out.println(test.findKthLargest(new int[]{1,1,5,3,4,8,7}, 3));

	}

}
