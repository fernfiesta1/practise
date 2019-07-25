package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateTrees {

	List<TreeNode> resultList = new ArrayList<>();
	Map<String, Integer> count = new HashMap<>();
			
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		helper(root);
		return resultList;
	}
	
	private String helper(TreeNode root) {
		
		if(root == null) {
			return "#";
		}		
		
		String v = helper(root.left) + helper(root.right) + root.val;
		
		
		int c = count.getOrDefault(v, 0) + 1;
		count.put(v, c);
		if(c > 1) {
			resultList.add(root);
		}
		
		return v;
	}
	
	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
		DuplicateTrees dt = new DuplicateTrees();
		dt.findDuplicateSubtrees(node);
	}
}
