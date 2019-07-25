package com.ferncircle.arrays;

public class NextPermutation {
	
public void nextPermutation(int[] nums) {
        
        int length = nums.length;
        boolean flag= false;
        
        for(int i=length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                int index = getLargeIndex(nums, i);
                swap(nums, i, index);
                reverse(nums,i+1);
                flag=true;
                break;
            }
        }  
        
        if(!flag){
            reverse(nums, 0);
        }       
        
    }
    
    private int getLargeIndex(int[] nums, int index){
        
    	
        for(int i=nums.length-1; i>index; i--){
            if(nums[i] > nums[index]){
                return i;
            }
        }
        
        return 0;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i){
        int j = nums.length -1;
        
        while(i< j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

	public static void main(String[] args) {

		
		NextPermutation np = new NextPermutation();
		
		int[] input = new int[] {3,2,1};
		np.nextPermutation(input);
		for(int i: input) {
			System.out.println(i);
		}
	}

}
