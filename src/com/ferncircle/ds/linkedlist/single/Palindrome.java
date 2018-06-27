package com.ferncircle.ds.linkedlist.single;

import java.util.Stack;

import junit.framework.Assert;



/**
 * @author dbrit00s
 * 
 * Solution 1:
 * Reverse the List and check if the input list is same as Reversed list. If yes, its a Palindrome.
 * Time : O(n)
 * Space : O(n)
 * 
 * Solution 2:
 * 
 * Get to the middle of the list, and move the rest of the elements to the start of the list.
 * Then compare the first half of the list with the second half of the list.
 * looks too dirty.
 * 
 * Time : O(n)
 * Space : O(1)
 * 
 * Solution 3:
 * 
 * Push the elements into stack till you reach the middle of the list.
 * For the remaining list, pop the elements and compare . 
 * 
 * Time : O(n)
 * Space : O(n)
 *
 */
public class Palindrome {
	
	
	public boolean isPalindrome1(SingleLinkedList l1){
		
		SingleLinkedList l2 = l1.reverse();
		Node h1 = l1.head;
		Node h2 = l2.head;
		
		while(h1.next != null){
			if(h1.data != h2.data){
				return false;
			}
			h1 = h1.next;
			h2 = h2.next;
		}	
		
		return true;
	}
	
	public boolean isPalindrome2(SingleLinkedList l1){
		
		
		Node fast = l1.head;
		Node slow = l1.head;
		Node head = l1.head;
		
		while(fast.next != null){
			fast = fast.next.next;			
			if(fast == null){
				break;
			}
			slow = slow.next;
		}
		
		Node reverse = l1.reverse(slow.next);
		while(reverse != null){
			if(reverse.data != head.data){
				return false;
			}
			
			reverse = reverse.next;
			head = head.next;
		}		
		
		return true;
	}
	
	public boolean isPalindrome3(SingleLinkedList l1){
		
		Node fast = l1.head;
		Node slow = l1.head;
		
		Stack<Integer> temp = new Stack<Integer>();
		
		//Get to the middle of the list
		while(fast.next != null){
			fast = fast.next.next;
			temp.push(slow.data);
			slow = slow.next;	
			
			if(fast == null){
				break;
			}
		}
		
		//If fast is null, Its an even list else its odd
		if(fast != null){
			slow = slow.next;
		}
		
		while(slow.next != null){
			if(slow.data != temp.pop()){
				return false;
			}
			
			slow = slow.next;
		}
		return true;
		
	}
	

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		
		SingleLinkedList l1 = new SingleLinkedList();
		l1.insertTail(0);
		l1.insertTail(1);
		l1.insertTail(2);
		l1.insertTail(3);
		l1.insertTail(2);
		l1.insertTail(1);
		l1.insertTail(0);
		Assert.assertTrue(p.isPalindrome1(l1));
		Assert.assertTrue(p.isPalindrome2(l1));		
		//Assert.assertTrue(p.isPalindrome3(l1));	
		
		SingleLinkedList l2 = new SingleLinkedList();
		l2.insertTail(0);
		l2.insertTail(1);
		l2.insertTail(2);
		l2.insertTail(3);
		l2.insertTail(2);
		l2.insertTail(1);
		Assert.assertFalse(p.isPalindrome1(l2));
		Assert.assertFalse(p.isPalindrome2(l2));
		//Assert.assertFalse(p.isPalindrome3(l2));
		
		SingleLinkedList l3 = new SingleLinkedList();
		l3.insertTail(0);
		l3.insertTail(1);
		l3.insertTail(2);
		l3.insertTail(2);
		l3.insertTail(1);
		l3.insertTail(0);
		Assert.assertTrue(p.isPalindrome1(l3));
		Assert.assertTrue(p.isPalindrome2(l3));
		//Assert.assertTrue(p.isPalindrome3(l3));
		
		SingleLinkedList l4 = new SingleLinkedList();
		l4.insertTail(1);
		l4.insertTail(1);
		l4.insertTail(2);
		l4.insertTail(1);
		Assert.assertFalse(p.isPalindrome2(l4));
		
		SingleLinkedList l5 = new SingleLinkedList();
		l5.insertTail(1);
		l5.insertTail(2);
		
		Assert.assertFalse(p.isPalindrome2(l5));
		
		
			
	
		
		
		

	}

}
