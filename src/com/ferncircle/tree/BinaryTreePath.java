package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
	
	public List<String> binaryTreePaths(TreeNode root){		
		
		StringBuffer path = new StringBuffer();
		List<String> lst = new ArrayList<String>();
		helper(root, path, lst);
		return lst;
	}
	
	private void helper(TreeNode root, StringBuffer path, List<String> result){
		
		if(root == null){
			return;
		}
		path.append(root.val + "->");
		if(root.left == null && root.right == null){			
			result.add(path.substring(0, path.length()-2));
		}else{
			helper(root.left, new StringBuffer(path), result);
			helper(root.right, new StringBuffer(path), result);
		}
				
		
	}
	

	public static void main(String[] args) {
		TreeNode root  = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		
		root.right.right.right = new TreeNode(1);	
		
		BinaryTreePath btp = new BinaryTreePath();
		List<String> result = btp.binaryTreePaths(root);
		System.out.println(result);

	}

}
