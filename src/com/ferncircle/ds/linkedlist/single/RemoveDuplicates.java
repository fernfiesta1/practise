package com.ferncircle.ds.linkedlist.single;

import java.util.HashSet;



/**
 * @author dbrit00s
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Solution 1: for Unsorted List

Time Complexity : O(n)
Space Complexity : O(n)

check if the element exists in the set. If yes, move the fast pointer.
else, point the slow to fast and insert the element in the set and move the pointers.

Solution2: For Sorted list
Time Complexity : O(n)
Space Complexity : O(1)

Move fast pointer until, slow is not equal to fast. then point slow to fast.

 *
 */
public class RemoveDuplicates extends SingleLinkedList{
	
	public static SingleLinkedList removeDuplicates(SingleLinkedList sll2){
		
		if(sll2.isEmpty()){
			return sll2;
		}
		
		if(sll2.head.next == null){
			return sll2;
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		Node current = sll2.head;
		Node previous = sll2.head;
		while(current.next != null){
			if(set.contains(current.data)){
				previous.next = current.next;
				current = current.next;
			}else{
				set.add(current.data);
				previous = current;
				current = current.next;
			}
		}
		
		return sll2;
	}
	
	public static Node removeDuplicates(Node head){
		if(head == null || head.next == null){
            return head;
        }
        
		Node fast = head.next;
        Node slow = head;       
        
        while(fast != null){
            if(fast.data != slow.data){
                slow.next = fast;
                slow = slow.next;
            }
            
            fast = fast.next;            
        }
        slow.next = null;
        
        return head;
	}
	

	public static void main(String[] args) {
		
		SingleLinkedList sll2 = new SingleLinkedList();
		sll2.insertTail(1);
		sll2.insertTail(2);
		sll2.insertTail(3);
		sll2.insertTail(1);
		sll2.insertTail(2);
		sll2.insertTail(5);
		System.out.println("Input: ");
		sll2.print();
		
		SingleLinkedList output = removeDuplicates(sll2);
		System.out.println("Solution 1: After removing duplicates:");
		output.print();
		
		SingleLinkedList sll3 = new SingleLinkedList();
		sll3.insertTail(1);
		sll3.insertTail(1);
		sll3.insertTail(2);
		sll3.insertTail(3);
		sll3.insertTail(3);
		
		System.out.println("Input: ");
		sll3.print();
		Node head = removeDuplicates(sll3.head);
		System.out.println("Solution 2:");
		while(head != null){
			
			System.out.print(head.data + ",");
			head = head.next;
		}

	}

}
