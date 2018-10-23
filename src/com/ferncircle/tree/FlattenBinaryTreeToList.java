package com.ferncircle.tree;

public class FlattenBinaryTreeToList {

	TreeNode prev = null;
	public void flatten(TreeNode root) {

		if(root == null){
			return;
		}
		
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
