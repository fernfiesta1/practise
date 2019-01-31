package com.ferncircle.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ferncircle.tree.TreeNode;

public class SerializeDeserialize {

	public String serialize(TreeNode root) {

		return helper(root, new StringBuffer());
	}

	private String helper(TreeNode root, StringBuffer sb){
		if(root == null){
			sb.append("null,");
			return sb.toString();
		}

		sb.append(root.val + ",");
		helper(root.left, sb);
		helper(root.right, sb);

		return sb.toString();

	}

	// Decodes your encoded data to tree.

	public TreeNode deserialize(String data) {
		String[] e = data.substring(0, data.length()-1).split(",");
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, e);
		return helper(list);
		
	}
	
	private TreeNode helper(List<String> elements) {
		if(elements == null || elements.size() == 0) {
			return null;
		}
		
		if(elements.get(0).equals("null")) {
			elements.remove(0);
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.parseInt(elements.get(0)));
		elements.remove(0);
		root.left = helper(elements);
		root.right = helper(elements);
		
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);

		SerializeDeserialize sd = new SerializeDeserialize();
		String data = sd.serialize(root);
		sd.deserialize(data);


	}


}
