package com.ferncircle.sortingNSearching;

import com.ferncircle.ds.linkedlist.single.ListNode;

public class MergeSortOnLinkedList {

	public ListNode sortList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		while(fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
			if(fast == null){
				break;
			}
		}
		
		//Very important to have previous node. THis is to split the list in two. prev.next = null will end the left list.
		prev.next = null;
		ListNode leftL = head;
		ListNode rightL = slow;
		slow = null;
		
		ListNode l1 = sortList(leftL);
		ListNode l2 = sortList(rightL);		

		return merge(l1, l2);
	}
	
	private ListNode merge(ListNode l1, ListNode l2){
		
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				prev.next = l1;
				prev = l1;
				l1 = l1.next;
			}else{
				prev.next = l2;
				prev = l2;
				l2 = l2.next;
			}
		}
		
		if(l1 == null){
			prev.next = l2;
		}else{
			prev.next = l1;
		}
		return dummy.next;
	}
	
	public static void main(String[] args){
		MergeSortOnLinkedList mer = new MergeSortOnLinkedList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
	
		
		ListNode result = mer.sortList(head);
		
		while(result != null){
			System.out.println(result.val + "-->");
			result = result.next;
		}
	}

}
