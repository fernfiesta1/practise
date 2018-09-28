package com.ferncircle.tree;

/**
 * 
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
 * @author dbrit00s
 *
 */
public class MaximumBinaryTree {


	public TreeNode constructMaximumBinaryTree(int[] nums) {

		if(nums.length == 0){
			return null;
		}		
		TreeNode root = helper(nums, 0, nums.length-1);
		return root;
	}
	
	private TreeNode helper(int[] nums, int lo, int hi){
		
		if(lo > hi){
			return null;
		}
		
		int largestIdx = getLargestIndex(nums, lo, hi);
		TreeNode node = new TreeNode(nums[largestIdx]);
		node.left = helper(nums, lo, largestIdx-1);
		node.right = helper(nums, largestIdx+1, hi);
		
		return node;
		
	}
	
	private int getLargestIndex(int[] nums, int lo, int hi){
		
		int max = Integer.MIN_VALUE;
		int idx =0;
		for(int i=lo; i<= hi; i++){
			if(max < nums[i]){
				max = nums[i];
				idx = i;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) {

		MaximumBinaryTree mbt = new MaximumBinaryTree();
		mbt.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
		
	}

}
