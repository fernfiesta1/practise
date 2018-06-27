package com.ferncircle.recursionNdynamic;

public class MagicIndexII {
	
	public static int findIndex(int[] input, int startIndex, int endIndex){
		
		if(startIndex > endIndex){
			return -1;
		}
		
		int mid = (startIndex + endIndex)/2;
		if(input[mid] == mid){
			return mid;
		}
		
		//Recurse through left subtree
		int leftEndIndex = Math.min(input[mid], mid-1);
		int result =findIndex(input, startIndex, leftEndIndex);
		
		if(result > 0){
			return result;
		}
		
		//Recurse through right subtree
		int rightStartIndex = Math.max(input[mid], mid+1);
		return findIndex(input, rightStartIndex, endIndex);
		
		
	}
	
	public static void main(String[] args){
		
		int[] input = new int[]{-30,1,1,1,3,5,8,9};
		System.out.println(findIndex(input, 0, input.length-1));
		
		int[] input2 = new int[]{-30,2,3,5,5,5};
		System.out.println(findIndex(input2, 0, input2.length-1));
	}

}
