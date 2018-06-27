package com.ferncircle.tree;

public class SubtreeOfAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t){

		if(s == null && t == null){
			return true;
		}
		
		if(s == null && t!= null || s!= null && t == null){
			return false;
		}

		if(checkSame(s, t)){
			return true;
		}else{
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
		
	}
	
	public boolean checkSame(TreeNode s, TreeNode t){
		if(s == null && t == null){
			return true;
		}
		
		if(s == null && t!= null || s!= null && t == null){
			return false;
		}
		
		if(s.val == t.val && checkSame(s.left, t.left) && checkSame(s.right, t.right)){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(3);
		bst.insert(2);
		bst.insert(1);
		bst.insert(5);
		bst.insert(4);		

		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(3);
		bst1.insert(1);
		bst1.insert(5);
		
		SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();

		System.out.println(s.isSubtree(bst.root, bst1.root));

	}

}
