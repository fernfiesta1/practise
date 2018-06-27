package com.ferncircle.stack;

public class MinStack1 {
	
	public Node top;
		
	public MinStack1(){
		top = null;
	}
	
	public void push(int data){
		
		Node n = new Node(data);
		if(top == null){
			n.min = data;
		}else{
			n.min = Math.min(top.min, data);
		}
		n.next = top;
		top = n;	
		
	}
	
	public Integer pop(){
		
		Integer output = null;
		if(top != null){
			output =  top.data;
			top = top.next;
			
		}
		return output;
	}	
	
	public int top(){
		
		Integer output = null;
		if(top != null){
			output =  top.data;			
			
		}
		return output;
	}
	
	public Integer getMin(){
		
		if(!isEmpty()){
			return top.min;
		}
		
		return null;
		
	}
	
	
	public boolean isEmpty(){
		if(top == null){
			return true;
		}
		return false;
	}
	
	public void print(){
		
		Node point = top;
		
		StringBuffer output = new StringBuffer();
		while(point.next!=null){
			output.append(point.data + ",");
			point = point.next;
		}
		output.append(point.data);
		System.out.println("Stack is : ");
		System.out.println(output.toString());
		
	}
	
	public class Node {

		public int data;
		public Node next;
		public int min;
		
		public Node(int data){
			this.data = data;
		}
		
	}

	public static void main(String[] args) {
		
		MinStack1 s = new MinStack1();
		
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(1);
		
		s.print();
		
		System.out.println("Minimun element is : " +s.getMin());
		
		System.out.println("Pop 1: " + s.pop());
		System.out.println("Pop 2: " + s.pop());
		System.out.println("top 1: " + s.top());
		s.print();
		System.out.println(s.getMin());
		

	}

}
