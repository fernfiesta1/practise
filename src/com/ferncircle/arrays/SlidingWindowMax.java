package com.ferncircle.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

	public int[] maxSlidingWindow(int[] nums, int k) {

		if(nums.length == 0 || k ==1){
			return nums;
		}
		
		int size = nums.length;
		int[] result = new int[size -k +1];
		int r = 0;
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		for(int i=0; i< size; i++){
			
			//Remove elements from head of the Queue which are out of range;
			while(!queue.isEmpty() && queue.peekFirst()< (i-k+1)){
				queue.pollFirst();
			}
			
			//Remove elements from the tail of the Queue untill the current elemnt is greater than the element in the queue
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
				queue.pollLast();
			}
			
			queue.addLast(i);
			
			//Put the max element in the array
			if(i>=k-1){
				result[r] = nums[queue.peekFirst()];
				r++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		SlidingWindowMax swm = new SlidingWindowMax();
		swm.maxSlidingWindow(new int[]{1, 3,-1,-3,5,3,6,7}, 3);

	}

}
