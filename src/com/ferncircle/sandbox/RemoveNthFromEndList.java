package com.ferncircle.sandbox;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Definition for singly-linked list.
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthFromEndList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode result = head;
		ListNode prev = head;
		int delFlag = 0;
		while(head.next != null){
			head = head.next;
			
			if(delFlag >= n){
				result = prev;
				prev = prev.next;
			}
		}
		
		result.next = prev.next;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		ListNode _1=new ListNode(1);
		ListNode _2=new ListNode(2);
		ListNode _3=new ListNode(3);
		ListNode _4=new ListNode(4);
		ListNode _5=new ListNode(5);
		
		ListNode head=_1;
		_1.next=_2;_2.next=_3;_3.next=_4;_4.next=_5;
		
		RemoveNthFromEndList test=new RemoveNthFromEndList();
		
		assertThat(test.removeNthFromEnd(head, 10).next.next.val, is(3));
		assertThat(test.removeNthFromEnd(head, 3).next.next.val, is(4));
		assertThat(test.removeNthFromEnd(head, 3).next.next.val, is(5));
		
		System.out.println("All test successful");
	}
	
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}


}
