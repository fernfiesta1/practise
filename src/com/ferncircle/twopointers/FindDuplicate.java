package com.ferncircle.twopointers;

public class FindDuplicate {

	public static int findDuplicate(int[] nums) {

		int fast = nums[nums[0]];
		int slow = nums[0];
		
		
		while(fast!=slow){
			fast = nums[nums[fast]];
			slow = nums[slow];			
		}
		
		fast =0;
		while(fast != slow){
			fast = nums[fast];
			slow = nums[slow];
		}
		
		return fast;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{8,7,5,4,2,1,5,3,6};
		int result = findDuplicate(nums);
		System.out.println(result);
	}

}
