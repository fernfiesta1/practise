package com.ferncircle.ds.linkedlist.doub;

public class Node {
	
	public double data;
	public Node nextNode;
	public Node prevNode;

	//Link constructor
	public Node(double d) {
		data = d;
	}

	//Print Link data
	public void printLink() {
		System.out.print("{" + data +  "} ");
	}

}
