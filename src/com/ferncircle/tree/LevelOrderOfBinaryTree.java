package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderOfBinaryTree {

	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> levelList = new ArrayList<List<Integer>>();
		if(root == null){
			return levelList;
		}		
		
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		
		while(!queue.isEmpty()){		
			
			int levelSize = queue.size();
			
			List<Integer> list = new ArrayList<Integer>();
			while(levelSize > 0){
				TreeNode current = queue.remove();
				list.add(current.val);
				
				if(current.left != null){
					queue.add(current.left);					
				}
				
				if(current.right != null){
					queue.add(current.right);
				}
				
				levelSize--;				
			}
			levelList.add(list);
		}	
	
		return levelList;

	}



	public static void main(String[] args) {
		

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
