package com.ferncircle.ds.linkedlist.single;

public class SingleLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public SingleLinkedList() {
		head = null;
		tail = null;

	}

	public boolean isEmpty(){
		if(head == null && tail == null){
			return true;
		}else{
			return false;
		}
	}

	public void insertTail(int value){
		size++;
		Node n = new Node(value);
		n.next = null;
		if(head == null){
			head = n;
			tail = n;	

		}else{			
			tail.next = n;
			tail = n;

		}
	}

	public void insertHead(int value){
		size++;
		Node n = new Node(value);
		n.next = null;
		if(head == null){
			head = n;
			tail = n;	

		}else{
			n.next = head;
			head = n;			
		}
	}	

	public SingleLinkedList reverse(){

		SingleLinkedList reverse = new SingleLinkedList();
		Node pointer = head;

		while(pointer != null){
			reverse.insertHead(pointer.data);
			pointer = pointer.next;
		}
		return reverse;

	}	
	
	public Node reverse(Node n){
		
		Node head = null;
		Node temp = null;
		Node ptr = n;
		
		while(ptr != null){
			temp = ptr.next;
			ptr.next =head;
			head = ptr;
			ptr = temp;
		}
		
		return head;
	}
	
	public Node get(int position){

		if(position > size -1){
			throw new RuntimeException("Size of the list is smaller than position requested.");
		}
		if(position == 0){
			return head;
		}

		Node result = head;
		for(int i=0; i<position; i++){
			result = result.next;
		}


		return result;
	}

	public int size(){		
		return size;
	}

	public void print(){

		Node n = head;
		while(n.next!=null){
			System.out.print(n.data + " , ");
			n = n.next;
		}
		System.out.print(n.data + System.lineSeparator());
	}
	
	public void print(Node n){
		Node temp = n;
		
		while(temp.next!=null){
			System.out.print(temp.data + " , ");
			temp = temp.next;
		}
		System.out.print(temp.data + System.lineSeparator());
	}


	//TODO: BUG 1.0: This method wont delete the last node.
	public void delete(Node n){

		if(n.next!= null){
			n.data = n.next.data;
			n.next = n.next.next;
		}

	}



	public static void main(String[] args) {

		SingleLinkedList sll2 = new SingleLinkedList();
		sll2.insertTail(1);
		sll2.insertTail(2);
		sll2.insertTail(3);
		sll2.insertTail(4);
		sll2.insertTail(5);
		sll2.insertTail(6);
		System.out.println("After inserting at the tail : ");
		System.out.println("Size is : " + sll2.size());
		System.out.println("position 0 : " + sll2.get(0).data);
		System.out.println("position 1 : " + sll2.get(1).data);
		System.out.println("position 2 : " + sll2.get(2).data);
		System.out.println("position 3 : " + sll2.get(3).data);
		System.out.println("position 4 : " + sll2.get(4).data);
		System.out.println("position 5 : " + sll2.get(5).data);
		sll2.print();		

		System.out.println("-------------------------------------");	
		SingleLinkedList sll3 = new SingleLinkedList();
		sll3.insertHead(1);
		sll3.insertHead(2);
		sll3.insertHead(3);
		sll3.insertHead(4);
		System.out.println("After inserting at the head : ");
		System.out.println("Size is : " + sll3.size());
		sll3.print();

		System.out.println("---------------------------------");
		System.out.println("List after reversing");
		SingleLinkedList reverse = sll3.reverse();
		reverse.print();

		System.out.println("---------------------------------------------");
		System.out.println("After delete");
		sll3.delete(sll3.get(2));
		sll3.print();
		
		System.out.println("Practising inplace reversing the linkedlist: ");
		SingleLinkedList sll4 = new SingleLinkedList();
		sll4.insertTail(1);
		sll4.insertTail(2);
		sll4.insertTail(3);
		sll4.insertTail(4);
		sll4.insertTail(5);
		sll4.insertTail(6);
		System.out.println("Before reversing : ");
		sll4.print();
		System.out.println("After reversing : ");
		sll4.head = sll4.reverse(sll4.head);
		sll4.print();
		
		
		
		


	}

}
