package com.ferncircle.ds.linkedlist.single;

public class Node {

	public int data;
	public Node next;

	//Link constructor
	public Node(int d) {
		data = d;
	}

	//Print Link data
	public void printLink() {
		System.out.print("{" + data +  "} ");
	}
}
