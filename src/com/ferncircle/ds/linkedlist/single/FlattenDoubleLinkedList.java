package com.ferncircle.ds.linkedlist.single;

import java.util.Stack;

public class FlattenDoubleLinkedList {
	
	 public Node flatten(Node head) {
	        if(head == null){
	            return null;
	        }
	        
	        Stack<Node> stack = new Stack();
	        stack.push(head);
	        Node prev = new Node();
	        
	        while(!stack.isEmpty()){
	            Node curr = stack.pop();
	             if(curr.next != null){
	                stack.push(curr.next);
	            }
	            
	            if(curr.child != null){
	                stack.push(curr.child);
	            }
	            
	            curr.next = null;
	            curr.child = null;
	            prev.next = curr;
	            curr.prev = prev;
	            prev = curr;
	        }
	        
	        return prev.next;
	    }
	 
	 class Node {
		    public int val;
		    public Node prev;
		    public Node next;
		    public Node child;

		    public Node() {}

		    public Node(int _val,Node _prev,Node _next,Node _child) {
		        val = _val;
		        prev = _prev;
		        next = _next;
		        child = _child;
		    }
		};

	public static void main(String[] args) {

		FlattenDoubleLinkedList ll = new FlattenDoubleLinkedList();
		
		
		
	}

}
