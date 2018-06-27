package com.ferncircle.tree;

import junit.framework.Assert;

public class InOrderSuccessor {
	
	public static TreeNode getSuccessor(TreeNode input){
		
		TreeNode successor = null;
		if(isLeafNode(input) || input.right == null){
			TreeNode parent = input.parent;
			while(input.val > parent.val ){
				parent = parent.parent;
			}
			successor = parent;
		}else{
			successor = getSmallest(input.right);
		}
		return successor;
	}

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(8);
		bst.insert(2);
		bst.insert(1);
		bst.insert(4);
		bst.insert(7);
		bst.insert(9);
		bst.insert(6);
		bst.insert(10);
		
		bst.displayInOrder(bst.root);
		
		Assert.assertEquals(6, getSuccessor(bst.root).val);
		Assert.assertEquals(5, getSuccessor(bst.root.left.right).val);

	}
	
	private static boolean isLeafNode(TreeNode input){
		
		if(input.left == null && input.right == null){
			return true;
		}
		return false;
	}
	
	private static TreeNode getSmallest(TreeNode input){		
		
		while(input.left != null){
			input = input.left;
		}
		
		return input;
	}
	
	
	
	

}
