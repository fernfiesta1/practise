package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 * @author dbrit00s
 *
 */

//TODO understand the recursive way
public class ValidateBST {


	List<Integer> nodes = new ArrayList<>();
	public boolean isValidBST(TreeNode root) {
		getNodesInOrder(root);
		if(nodes.isEmpty() || nodes.size() == 1){
			return true;
		}
		
		for(int i=1; i< nodes.size(); i++){
			if(nodes.get(i) <= nodes.get(i-1)){
				return false;
			}
		}		
		return true;		
	}
	
	
	private void getNodesInOrder(TreeNode root){
		if(root == null){
			return;
		}		
		getNodesInOrder(root.left);
		nodes.add(root.val);
		getNodesInOrder(root.right);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
