package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<>();		
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
		
			//Add the rightmost element to the result.
			result.add(queue.peek().val);
			
			//Count the number of elements at the level.
			int itemsAtLevel = queue.size();
			while(itemsAtLevel != 0){
				TreeNode current = queue.remove();
				if(current.right != null){
					queue.add(current.right);
				}
				
				if(current.left != null){
					queue.add(current.left);
				}
				
				//Decreement the items at level, since you already processed one item
				itemsAtLevel--;
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		

	}

}
