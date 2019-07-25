package com.ferncircle.ds.linkedlist.single;


/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 * @author dbrit00s
 *
 *Solution:
 *
 *Brute force:
 *Create a map of old node to new node. Every time check bofore creating a node, check if it exists in the map.
 *
 *Iterative solution: This is the  optimum solution
 *
 *Weave the old and new list. Then updata the pointers
 * Be carefull to handle nulls and pay special attention to Pass 3.
 */
public class DeepCopyLinkedList {

	public RandomListNode copyRandomList(RandomListNode head) {

		 if(head == null) {
				return null;
			}
			RandomListNode orgHead = head;
			//Pass 1. create a weaved list
			while(head != null) {
				RandomListNode node = new RandomListNode(head.label);
				node.next = head.next;
				head.next = node;
				
				head = node.next;
			}
			
			// Pass 2. Create random pointer
			RandomListNode curr = orgHead;
			while(curr != null) {
	            if(curr.random != null){
	                curr.next.random = curr.random.next;
	            }else{
	                curr.next.random = null;
	            }
				
				curr = curr.next.next;
			}
			
			//Pass 3: Unweave the list to get the old and new list
			RandomListNode curr_old = orgHead;		
	        RandomListNode curr_new = orgHead.next;
	        
	        RandomListNode result = orgHead.next;
	        
	        while(curr_old != null){
	           
	            curr_old.next = curr_old.next.next;
	            curr_new.next = (curr_new.next != null ? curr_new.next.next : null);
	            
	            curr_new = curr_new.next;
	            curr_old = curr_old.next;
	        }       
			
			
			return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

}
