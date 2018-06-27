package com.ferncircle.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {

	public Node root;

	public int getDepthIterative(Node root){

		if(root == null){
            return 0;
        }
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		int height =0;
		int levelsize=0;

		while(!q.isEmpty()){

			levelsize = q.size();		

			while(levelsize > 0){
				Node a = q.peek();
				q.remove();
				if(a.left != null){
					q.add(a.left);					
				}

				if(a.right != null){
					q.add(a.right);
				}

				levelsize--;
			}		

			height++;			
		}

		return height;
	}
	
	public int getDepthRecursive(Node root){
		
		if(root == null){
			return 0;
		}		
		
		int height = Math.max(getDepthRecursive(root.left), getDepthRecursive(root.right)) + 1;
		
		return height;
	}
	
	public boolean isBalanced(Node root){
		
	
		if(root == null){
			return true;
		}		
		
		int depthOfLeftSubtree = getDepthIterative(root.left);
		int depthOfRightSubTree = getDepthIterative(root.right);
		
		if(Math.abs(depthOfLeftSubtree - depthOfRightSubTree) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
			return true;
		}
		
		return false;
	}



	public static void main(String[] args) {
		DepthOfBinaryTree tree = new DepthOfBinaryTree();

		// Let us create a binary tree shown in above diagram
				
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.left.left = new Node(7);
		tree.root.right.left.left.left = new Node(8);
		
		//System.out.println("Height of tree is iteratively: " + tree.getDepthIterative(tree.root));
		//System.out.println("Height of tree recursively: " + tree.getDepthIterative(tree.root));
		System.out.println(tree.getDepthRecursive(tree.root.right));
		
		//System.out.println("Is tree balanced :" + tree.isBalanced(tree.root));
	}

	public static class Node{

		int val;
		Node left;
		Node right;

		public Node(int val){
			this.val = val;
		}
	}

}




