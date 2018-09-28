package com.ferncircle.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 * @author dbrit00s
 *
 *The best way to do this is Do inOrder traversal and then do twoSum.
 */
public class PathSum4 {

	public boolean findTarget(TreeNode root, int k) {

		Set<Integer> set = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null){
			return false;
		}
		
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			if(set.contains(current.val)){
				return true;
			}
			set.add(k-current.val);
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right!= null){
				queue.add(current.right);
			}
		}
		
		return false;
	}
}
