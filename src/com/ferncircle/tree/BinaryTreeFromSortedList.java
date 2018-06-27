package com.ferncircle.tree;

public class BinaryTreeFromSortedList {
	
	

	public TreeNode sortedListToBST(ListNode head) {
		
		TreeNode root = createBT(head, getEnd(head));		
		return root;

	}
	
	private TreeNode createBT(ListNode start, ListNode end){
		
		if(start.val >= end.val){
			return null;
		}
		
		ListNode mid = getMid(start, end);		
		TreeNode root = new TreeNode(mid.val);
		
		root.left = createBT(start, mid);
		root.right = createBT(mid.next, end);
		
		return root;
	}
	
	private ListNode getMid(ListNode start, ListNode end){
		
		ListNode fast = start;
		ListNode slow = start;
		ListNode afterEnd=end.next;
		
		if(start == end){
			return start;
		}
		
		while(fast!=end && fast!=afterEnd ){
			slow = slow.next;
			
			fast = fast.next.next;
			
		}
		return slow;
	}
	
	private ListNode getEnd(ListNode start){
		
		while(start.next != null){
			start = start.next;
		}
		
		return start;
	}

	public static void main(String[] args) {

		ListNode n = new ListNode(0);
		n.next = new ListNode(1);
		n.next.next = new ListNode(2);
		n.next.next.next = new ListNode(3);
		n.next.next.next.next = new ListNode(4);
		n.next.next.next.next.next = new ListNode(5);
		
		
		BinaryTreeFromSortedList bst  = new BinaryTreeFromSortedList();
		bst.sortedListToBST(n);
		
		bst.displayInOrder(bst.sortedListToBST(n));

	}
	
	public void displayInOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		displayInOrder(root.left);
		System.out.print(root.val + ",");
		displayInOrder(root.right);
	}

	/**
	 * Definition for singly-linked list. */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	/**
	 * Definition for a binary tree node. */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
