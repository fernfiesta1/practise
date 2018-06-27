package com.ferncircle.ds.linkedlist.single;

/**
 * @author dbrit00s
 * 
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7 -> 1 -> 6) + (5 -> 9 -> 2)
Output: 2 -> 1 -> 9 (That is 912)
 *
 */
public class SumList1 {

	public static SingleLinkedList add(Node node1, Node node2){

		SingleLinkedList result = new SingleLinkedList();

		int digit1 =0, digit2=0, carry = 0;
		while(node1 != null || node2!= null){


			if(node1 != null && node2 != null){
				digit1 = (int)node1.data;
				digit2 = (int)node2.data;
			}else if(node1 !=null && node2 == null){
				digit1 = (int)node1.data;
				digit2 = 0;
			}else if(node1==null && node2!=null){
				digit1 = 0;
				digit2 = (int)node2.data;
			}

			int outDigit = digit1 + digit2 + carry;
			if(outDigit > 10){
				carry = outDigit/10;
				outDigit = outDigit%10;

			}

			result.insertTail(outDigit);
			if(node1!=null){
				node1 = node1.next;
			}
			if(node2!=null){
				node2 = node2.next;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertTail(7);
		list1.insertTail(1);
		list1.insertTail(6);

		SingleLinkedList list2 = new SingleLinkedList();
		list2.insertTail(5);
		list2.insertTail(9);
		list2.insertTail(2);

		SingleLinkedList result = add(list1.head, list2.head);
		result.print();


	}

}
