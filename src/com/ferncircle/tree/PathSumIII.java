package com.ferncircle.tree;

/**
 * 
 * @author dbrit00s
 * 
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 *
 */

public class PathSumIII {

	public int pathSum(TreeNode root, int sum) {	
		
		int count =0;
		if(root == null){
			return 0;
		}
		
		count += helper2(root, sum) +		
		pathSum(root.left, sum) +
		pathSum(root.right, sum);
		
		return count;
		
		
	}
	
	private int helper2(TreeNode root, int sum){
		if(root == null){
			return 0;
		}		
		
		int count;
		if(sum - root.val == 0) {
			count++;
		}
		return (sum - root.val == 0 ? 1:0) + helper2(root.left, sum - root.val) + helper2(root.right, sum-root.val);
		
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
		
		PathSumIII ps = new PathSumIII();
		System.out.println(ps.pathSum(root, 8));

	}

}
