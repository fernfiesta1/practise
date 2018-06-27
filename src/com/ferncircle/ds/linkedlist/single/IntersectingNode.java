package com.ferncircle.ds.linkedlist.single;

public class IntersectingNode {

	public static Node solution(Node headA, Node headB){

		if(headA == null || headB == null){
			return null;
		}     


		int waitA =0;
		int waitB =0;

		Node a = headA;
		Node b = headB;
		while(a.next != null || b.next != null){

			if(a.next == null && b.next != null){				
				waitA++;
				b = b.next;
			}else if(a.next != null && b.next == null){
				waitB++;
				a = a.next;
			}else{
				a = a.next;
				b = b.next;
			}		

		}

		if(a.data != b.data){
			return null;
		}

		a = headA;
		b = headB;
		if(waitA != 0){
			while(waitA > 0){
				b = b.next;
				waitA--;
			}

		}


		if(a.data != b.data){
			return null;
		}

		a = headA;
		b = headB;
		if(waitA != 0){
			while(waitA > 0){
				b = b.next;
				waitA--;
			}

		}

		if(waitB != 0){
			while(waitB > 0){
				a = a.next;
				waitB--;
			}

		}

		while(a != null){
			if(a.data == b.data){
				return a;
			}

			a = a.next;
			b = b.next;
		}


		return null;
	}




	public static void main(String[] args) {

		SingleLinkedList sll1 = new SingleLinkedList();
		sll1.insertTail(1);
		sll1.insertTail(2);
		sll1.insertTail(3);
		sll1.insertTail(4);
		sll1.insertTail(5);

		SingleLinkedList sll2 = new SingleLinkedList();
		sll2.insertTail(6);
		sll2.insertTail(7);
		sll2.insertTail(8);
		sll2.insertTail(9);
		sll2.tail.next = sll1.get(2);

		sll1.print();
		sll2.print();

		Node n = solution(sll1.head, sll2.head);
		System.out.println(n.data);


	}

	/*public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}*/

}
