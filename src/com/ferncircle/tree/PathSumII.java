package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dbrit00s
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 *
 */
public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<Integer> pathsofar = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, pathsofar, result, sum);
		return result;
		
	}
	
	public void helper(TreeNode root, List<Integer> pathSoFar, List<List<Integer>> result, int sum){
		
		if(root == null){
			return;
		}
		pathSoFar.add(root.val);
		if(root.left == null && root.right == null && sum - root.val == 0){
			result.add(pathSoFar);
		}else{
			helper(root.left, new ArrayList<Integer>(pathSoFar), result, sum - root.val);
			helper(root.right, new ArrayList<Integer>(pathSoFar), result, sum - root.val);
			
		}
		
	}
	
	

	public static void main(String[] args){
		
		TreeNode root  = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		PathSumII ps = new PathSumII();
		List<List<Integer>> r = ps.pathSum(root, 22);
		System.out.println(r.size());
		for(List<Integer> l: r){
			System.out.println(l);
		}
		
	}
}
