package com.ferncircle.tree;

public class BinaryTreeFromSortedArray {
	
	public Node addNode(int[] arr, int start, int end){
		
		if(start > end){
			return null;
		}
		
		int mid = (start + end)/2;
		Node n = new Node(arr[mid]);
		n.left = addNode(arr, start, mid-1);
		n.right = addNode(arr, mid + 1, end);
		
		return n;
	}

	public static void main(String[] args) {
		BinaryTreeFromSortedArray a = new BinaryTreeFromSortedArray();
		int[] arr = new int[]{0,1,2,3,4,5,6};
		Node root = a.addNode(arr, 0, arr.length -1);
		
		BinarySearchTree bst = new BinarySearchTree();
		a.displayInOrder(root);

	}
	
	public void displayInOrder(Node root){
		if(root == null){
			return;
		}
		
		displayInOrder(root.left);
		System.out.print(root.val + ",");
		displayInOrder(root.right);
	}
	
	public class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int val){
			this.val = val;
		}
	}

}
