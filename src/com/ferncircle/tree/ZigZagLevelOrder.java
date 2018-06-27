package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();	
		if(root == null){
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int depth =0;
		while(!queue.isEmpty()){
			
			int elementsInLevel = queue.size();
			
			List<Integer> elements = new LinkedList<Integer>();
			while(elementsInLevel > 0){
				TreeNode current = queue.poll();
				
				if(current.left != null){
					queue.add(current.left);				
				}
				if(current.right != null){
					queue.add(current.right);
				}
				if(depth%2 != 0){
					elements.add(0, current.val);
				}else{
					elements.add(current.val);
				}
				
				elementsInLevel--;
			}
			
			result.add(elements);
			depth++;			
		}
		
		

		return result;
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
