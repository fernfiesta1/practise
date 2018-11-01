package com.ferncircle.sortingNSearching;

public class SortColors {
	
	public void sortColors(int[] nums){		
		
		int begin = -1;
		int end = nums.length;
		
		int i=0;
		while(i<end){			
			if(nums[i] == 0){
				begin = begin+1;
				sort(nums, begin, i);
				i++;
			}else if(nums[i] == 2){
				end = end -1;
				sort(nums, end, i);
			}else{
				i++;
			}
			
		}
		
	}
	
	private void sort(int[] input, int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {

		int[] input = new int[]{1,0,2,1,0,2,1,0,1};
		SortColors sc = new SortColors();
		sc.sortColors(input);
		
		for(int i=0; i< input.length; i++){
			System.out.println(input[i] + ",");
		}
	}

}
