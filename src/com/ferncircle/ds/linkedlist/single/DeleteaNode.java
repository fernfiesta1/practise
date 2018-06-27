package com.ferncircle.ds.linkedlist.single;

public class DeleteaNode {


	public static boolean delete(Node input){		

		if(input == null || input.next == null){
			return false;
		}
		
		input.data = input.next.data;
		input.next = input.next.next;		
		return true;


	}

	public static void main(String[] args) {

		SingleLinkedList sll = new SingleLinkedList();
		sll.insertTail(1);
		sll.insertTail(2);
		sll.insertTail(3);
		sll.insertTail(4);
		sll.insertTail(5);

		sll.print();
		Node input = sll.get(3);
		delete(input);
		sll.print();
	}

}
