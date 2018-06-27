package com.ferncircle.ds.linkedlist.single;

/**
 * @author dbrit00s
 * 
 * Variation of SumList1.
 * Suppose the two digits are stored in forward order rather than reverse order.
 * 
 * Algorithm:
 * 
 * Reverse both the lists first
 * then add and append the result to the head of the list rather than tail.
  
 *
 */

//TODO There is a recursive solution for this. Try to understand that.
public class SumList2 {
	
	public SingleLinkedList add(SingleLinkedList n1, SingleLinkedList n2){
		
		SingleLinkedList l1 = n1.reverse();
		SingleLinkedList l2 = n2.reverse();
		
		SingleLinkedList result = new SingleLinkedList();

		int digit1 =0, digit2=0, carry = 0;
		while(l1.head != null || l2.head!= null){


			if(l1.head != null && l2.head != null){
				digit1 = (int)l1.head.data;
				digit2 = (int)l2.head.data;
			}else if(l1.head !=null && l2.head == null){
				digit1 = (int)l1.head.data;
				digit2 = 0;
			}else if(l1.head==null && l2.head!=null){
				digit1 = 0;
				digit2 = (int)l2.head.data;
			}

			int outDigit = digit1 + digit2 + carry;
			if(outDigit > 10){
				carry = outDigit/10;
				outDigit = outDigit%10;

			}

			result.insertHead(outDigit);
			if(l1.head!=null){
				l1.head = l1.head.next;
			}
			if(l2.head!=null){
				l2.head = l2.head.next;
			}
		}

		return result;
		
	}
	
	

	
	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertTail(6);
		list1.insertTail(1);
		list1.insertTail(7);

		SingleLinkedList list2 = new SingleLinkedList();
		list2.insertTail(2);
		list2.insertTail(9);
		list2.insertTail(5);
		
		SumList2 sl2 = new SumList2();
		SingleLinkedList res = sl2.add(list1, list2);
		res.print();

	}

}
