package com.ferncircle.queue;

import java.util.Stack;

class MyQueue {

	Stack<Integer> s1;
	Stack<Integer> s2;

	/** Initialize your data structure here. */
	public MyQueue() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {    	
		s1.push(x);

	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}

		return s2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}

		return s2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if(s1.isEmpty() && s2.isEmpty()){
			return true;
		}

		return false;
	}


	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */

	public static void main(String[] args){
		MyQueue obj = new MyQueue();
		obj.push(1);
		int param_2 = obj.pop();
		boolean param_3 = obj.empty();
		System.out.println("Pushed : " + 1);
		System.out.println("Popped : " + param_2);		
		System.out.println("is empty : " + param_3);
		
		
		obj.push(2);
		int param_4 = obj.peek();
		boolean param_5 = obj.empty();
		System.out.println("Pushed : " + 2);
		System.out.println("Peeked : " + param_4);		
		System.out.println("is empty : " + param_5);
	}

}
