package com.ferncircle.ds.linkedlist.doubl;

public class DoubleLinkedList {
	
	public Node head;
	public Node tail;
	public int size;
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public void insertLast(int data){
		Node n = new Node(data);
		if(!isEmpty()){
			n.next = null;
			n.previous = tail;
			tail.next = n;
			tail = n;
			
			if(head.next == null){
				head.next = n;
			}
		}else{
			n.next = null;
			n.previous = null;
			head = n;
			tail = n;
		}
		
		size++;
		
	}
	
	public boolean isEmpty(){
		if(head == null && tail == null){
			return true;
		}
		
		return false;
	}
	
	public void insertFirst(int data){
		
		Node n = new Node(data);
		if(!isEmpty()){
			
			n.next = head;
			n.previous = null;
			head.previous = n;
			head = n;
			if(tail.previous == null){
				tail.previous = n;
			}			
			
		}else{
			n.next = null;
			n.previous = null;
			head = n;
			tail = n;
		}
		
		size++;
	}
	
	public void insertAt(int data, int index){
		Node nodeAtIndex = get(index);
		Node n = new Node(data);
		n.previous = nodeAtIndex.previous;
		n.next = nodeAtIndex;
		nodeAtIndex.previous.next = n;
		nodeAtIndex.previous = n;
	}
	
	public Node get(int position){
		
		if(position > size-1){
			throw new RuntimeException("Index is greater that size of the list.");
		}		
		
		int index =0;
		Node result = null;
		Node pointer = head;
		while(pointer.next != null){
			if(index == position){
				result = pointer;
				break;
			}
			pointer = pointer.next;
			index++;
		}
		
		return result;
	}
	
	public void delete(Node n){
		
		n.previous.next = n.next;
		
	}	
	
	public void print(){
		
		Node parser = head;
		if(!isEmpty()){
			while(parser.next != null){
				System.out.print(parser.data + ",");
				parser = parser.next;
			}
			System.out.println(parser.data);
		}
		
	}
	
	public static void main(String[] args){
		
		//Insert last and print
		System.out.println("Insert last : ");
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.insertLast(1);
		dll.insertLast(2);
		dll.insertLast(3);
		dll.insertLast(4);
		dll.print();		
		System.out.println("tail.next = " + dll.tail.next);
		System.out.println("tail.data = "  + dll.tail.data);
		System.out.println("tail.previous = " + dll.tail.previous.data);
		System.out.println("head.next = " + dll.head.next.data);
		System.out.println("head.data = " + dll.head.data);
		System.out.println("head.previous = " + dll.head.previous);
		System.out.println("Size of list is : " + dll.size);
		System.out.println("-----------------------------------");
				
		//Insert first and print		
		System.out.println("Insert first : ");
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.insertFirst(1);
		dll2.insertFirst(2);
		dll2.insertFirst(3);
		dll2.insertFirst(4);
		dll2.insertFirst(5);
		dll2.insertFirst(6);
		dll2.print();		
		System.out.println("tail.next = " + dll2.tail.next);
		System.out.println("tail.data = "  + dll2.tail.data);
		System.out.println("tail.previous = " + dll2.tail.previous.data);
		System.out.println("head.next = " + dll2.head.next.data);
		System.out.println("head.data = " + dll2.head.data);
		System.out.println("head.previous = " + dll2.head.previous);
		System.out.println("Size of the list is : " + dll2.size);
		System.out.println("-----------------------------------");
		
		//Get at a given index
		Node output = dll.get(2);
		System.out.println("Data at index 2 is " + output.data);
		dll.insertAt(10, 2);
		dll.print();
		System.out.println("-----------------------------------");
		
		//Delete a node
		System.out.println("Delete a Node at Index 2");
		Node n = dll.get(2);
		dll.delete(n);
		dll.print();
		
	}

}
