package com.ferncircle.ds.linkedlist.doubl;

public class DoubleLinkedListFromBST {

	Node previous = null;
	public Node treeToDoublyList(Node root) {

		if(root == null){
			return null;
		}
		Node dummy = new Node();
		previous = dummy;

		helper(root);
		previous.right = dummy.right;
		dummy.right.left = previous;

		return dummy.right;
	}

	private void helper(Node root){

		if(root == null){
			return;
		}

		helper(root.left);
		previous.right = root;
		root.left = previous;
		previous = root;
		helper(root.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {}

	public Node(int _val,Node _left,Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
};
