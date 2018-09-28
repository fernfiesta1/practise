package com.ferncircle.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInNPre {

	int[] preorder = null;
	int [] inorder = null;
	Map<Integer, Integer> map = new HashMap<>();
    int preIn = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		for(int i=0; i< inorder.length; i++){
			map.put(inorder[i], i);
		}
		this.preorder = preorder;
		this.inorder = inorder;
		
		return helper(0, inorder.length-1);
	}
	
	private TreeNode helper(int inStart, int inEnd){
		
		if(inStart > inEnd || preIn >= preorder.length){
			return null;
		}
		
		int val = preorder[preIn];
        preIn++;
        
		int inIndex = map.get(val);
		TreeNode node = new TreeNode(val);
		node.left = helper(inStart, inIndex -1);
		
		node.right = helper(inIndex + 1, inEnd);
		
		return node;
	}

	public static void main(String[] args) {

		BinaryTreeFromInNPre test = new BinaryTreeFromInNPre();
		test.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
	}

}
