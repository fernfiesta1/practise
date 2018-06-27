package com.ferncircle.ds.linkedlist.doub;

public class DoubleLinkedList {

	private Node first;
	private Node last;
	private int size;

	//LinkList constructor
	public DoubleLinkedList() {
		size =0;

	}
	
	public boolean isEmpty(){
		if(size == 0) 
			return true;
		else
			return false;
	}
	
	public int getSize(){
		return size;
	}	
	
	public void insertFirst(double data){
		
		Node n = new Node(data);
		if(first == null && last == null){
			n.prevNode = first;
			n.nextNode = last;		
		}else{
			n.nextNode = first;
			n.prevNode = null;
		}
		
		first = n;		
		size++;
		
		
	}
	
	public void insertLast(){
		
	}
	
	public void removefirst(){
		
	}
	
	public void removelast(){
		
	}
	
	public void printForward(){
		
		Node tmp = first;
		System.out.println("Printing values forward: ");
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.nextNode;
		}
		
	}
	
	public void printBackward(){
		
		Node tmp = last;
		System.out.println("Printing values backward: ");
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.prevNode;
		}
	}
	
	public static void main(String[] args){
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.insertFirst(1.1);
		dll.insertFirst(2.1);
		dll.insertFirst(3.1);
		dll.insertFirst(4.1);
		
		dll.printForward();
		dll.printBackward();
		
				
		
	}

}
