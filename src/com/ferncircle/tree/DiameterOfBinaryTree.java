package com.ferncircle.tree;

/**
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 * @author dbrit00s
 *
 */
public class DiameterOfBinaryTree {

	int noOfNodes = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 0;
		}
		depth(root);
		//since we want to return the number of edges between two nodes, subtract 1.
		return noOfNodes -1;

	}

	private int depth(TreeNode root){
		if(root == null){
			return 0;
		}

		//Get the dpeth of left Node
		int depthOfLeftNode = depth(root.left);
		//Get the depth of right Node
		int depthOfRightNode = depth(root.right);

		//Calculate the number of nodes to the left and right of the Node including the Node
		int maxNodesBetweenLNR = depthOfLeftNode + depthOfRightNode + 1;
		noOfNodes = Math.max(noOfNodes, maxNodesBetweenLNR);

		int depth = Math.max(depthOfLeftNode, depthOfRightNode) + 1;
		return depth;
	}

	public static void main(String[] args){
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);

		DiameterOfBinaryTree test = new DiameterOfBinaryTree();
		test.diameterOfBinaryTree(node);

	}
}
