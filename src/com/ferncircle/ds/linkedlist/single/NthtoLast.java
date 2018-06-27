package com.ferncircle.ds.linkedlist.single;

import junit.framework.Assert;

/**
 * @author dbrit00s
 * 
 * Nth to last means Nth from last. For example if n =5, then return 5th node from end of the List.
 * Implement an algorithm to find the nth to last element of a singly linked list.
 *
 */
public class NthtoLast {
	
	public static Node solution(Node head, int n){
		
		if(head == null || head.next == null){
			return head;
		}
		
		Node fast = head;
		Node slow = head;
		
		for(int i=0; i<n-1; i++){
			if(fast.next == null){
				return slow;
			}
			fast = fast.next;
		}
		
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		SingleLinkedList sll2 = new SingleLinkedList();
		sll2.insertTail(1);
		sll2.insertTail(2);
		sll2.insertTail(3);
		sll2.insertTail(1);
		sll2.insertTail(8);
		sll2.insertTail(5);
		sll2.print();
		
		//Node result = solution(sll2.first, 2);
		Assert.assertEquals(1.8,  solution(sll2.head, 2).data);
		Assert.assertEquals(1.1,  solution(sll2.head, 10).data);
		
		SingleLinkedList s3 = new SingleLinkedList();
		s3.insertTail(1);
		Assert.assertEquals(1.1, solution(s3.head, 5).data);
		

	}

}
