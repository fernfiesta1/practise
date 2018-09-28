package com.ferncircle.ds.linkedlist.single;


/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 * @author dbrit00s
 *
 */
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1 == null){
			return l2;
		}
		
		if(l2 == null){
			return l1;
		}
		
		ListNode previous = new ListNode(-1);
		ListNode result = previous;
		while(l1 != null && l2!=null){
			if(l1.val < l2.val){
				previous.next = l1;
				l1 = l1.next;
			}else{
				previous.next = l2;
				l2 = l2.next;				
			}
			previous = previous.next;
		}
		
		if(l1 == null){
			previous.next = l2;
		}else{
			previous.next = l1;
		}
		
		return result.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
