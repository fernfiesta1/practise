package com.ferncircle.sortingNSearching;


/*//check condition
int aP = 0;
int bP = 0;

while(aP < res1.length && bP < res2.length){
    if(res1[aP] > 2 * res2[bP]){
        result += (res1.length - aP);  
        bP++;
    }else{
         aP++;
 }
}*/

public class ReversePairs {
	  int result = 0;
	  

	    public int reversePairs(int[] nums) {
	        if(nums.length == 0){
	            return result;
	        }
	        helper(nums, 0, nums.length-1);
	        return result;
	    }
	    
	    private void helper(int[] nums, int i, int j){
	        if(i >= j){
	            return;
	        }
	        
	        int mid = i + (i+j) /2;
	        helper(nums, i, mid-1);
	        helper(nums, mid, j); 
	             
	        
	       
	    }
	
	    private void merge(int[] arr, int i, int j, int mid) {
	    	
	    	//Copy the elements from original array to temp array
	    	for(int k=0; k< temp.length; k++) {
	    		temp[k] = arr[i];
	    		i++;
	    	}
	    	
	    	int lowIdx = i;
	    	int highIdx = j;
	    	int midIdx = mid+1;
	    	int k =0;
	    	
	    	while(lowIdx <=mid && midIdx <= j) {
	    		if()
	    	}
	    	
	    	
	    	
	    	
	    }

	    public static void main(String[] args) {
	    	
	    	ReversePairs rp = new ReversePairs();
	    	System.out.println(rp.reversePairs(new int[] {2,4,3,5,1}));
	    }
}
