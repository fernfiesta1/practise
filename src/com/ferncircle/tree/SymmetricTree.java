package com.ferncircle.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * @author dbrit00s
 *
 */
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null || (root.left == null && root.right == null)){
			return true;
		}
		
		queue .add(root.left);
		queue.add(root.right);
		
		while(!queue.isEmpty()){
			
			TreeNode t1 = queue.poll();
			TreeNode t2 = queue.poll();
			if(t1 == null && t2 != null) return false;
			if(t1 != null && t2 == null) return false;
			if(t1 == null && t2 == null) continue;
			if(t1.val != t2.val) return false;
			queue.add(t1.left);
			queue.add(t2.right);
			queue.add(t1.right);
			queue.add(t2.left);
			
		}
		
		return true;
	}
	
	public boolean isSymmetricRecursion(TreeNode root){
	
		if(root == null || root.left == null && root.right == null)
			return true;
		return isMirror(root.left, root.right);
	}
	
	
	private boolean isMirror(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 != null) return false;
		if(t1 != null && t2 == null) return false;
		if(t1 == null && t2 == null) return true;
		if(t1.val != t2.val) return false;
		
		return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
