package com.ferncircle.queue;

public class Queue {
	
	Node head;
	Node tail;
	
	public Queue(){
		head = null;
		tail = null;
	}
	
	public void enqueue(int data){
		
		Node n = new Node(data);
		if(isEmpty()){
			n.next = null;
			tail = n;
			head = n;
		}else{			
			n.next = null;
			tail.next = n;
			if(head.next == null){
				head.next = tail;
			}
			tail = n;
			
		}
		
	}
	
	public Node dequeue(){
		
		if(head == null || head.next == null){
			return head;
		}
		
		Node output = head;
		head = head.next;
		return output;
	}
	
	public boolean isEmpty(){
	
		if(head == null){
			return true;
		}
		
		return false;
	}

	public void print(){
		
		Node ptr = head;
		while(ptr!= null){
			System.out.print(ptr.data + ",");
			ptr = ptr.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.print();
		
		q.dequeue();
		q.print();

	}

}
