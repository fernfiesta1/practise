package com.ferncircle.ds.linkedlist.single;

import junit.framework.Assert;

public class CircularLinkedList {

	public static boolean isCircular(Node head){

		if(head.next == null){
			return false;
		}


		Node fast = head;
		Node slow = head;

		while(fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			if(fast == null){
				break;
			}
			if(slow.next == fast.next){
				break;
			}

		}

		if(fast == null || fast.next == null){
			return false;
		}		
		return true;

	}

	public static Node getStart(Node head){

		Node fast = head;
		Node slow = head;

		while(fast.next != slow.next){
			slow = slow.next;
			fast = fast.next.next;
		}



		if(slow.data == head.data || slow.data == head.next.data){
			return slow;
		}
		slow = head;

		while(slow.next != fast.next){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		SingleLinkedList sll = new SingleLinkedList();
		sll.insertTail(1);
		sll.insertTail(2);
		sll.insertTail(3);		
		Assert.assertFalse(isCircular(sll.head));

		SingleLinkedList s2 = new SingleLinkedList();
		s2.insertTail(1);		
		Assert.assertFalse(isCircular(s2.head));

		SingleLinkedList s3 = new SingleLinkedList();
		s3.insertTail(1);
		s3.insertTail(2);
		Assert.assertFalse(isCircular(s3.head));

		SingleLinkedList s4 = new SingleLinkedList();
		s4.insertTail(1);
		s4.insertTail(2);
		s4.insertTail(3);
		s4.insertTail(4);
		s4.insertTail(5);
		s4.insertTail(6);
		s4.insertTail(7);
		s4.insertTail(8);
		s4.insertTail(9);
		s4.insertTail(10);
		s4.tail.next = s4.get(6);
		Assert.assertTrue(isCircular(s4.head));

		Node start = getStart(s4.head);
		System.out.println(start.data);

	}

}
