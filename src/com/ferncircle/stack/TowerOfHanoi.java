package com.ferncircle.stack;

import java.util.Stack;

public class TowerOfHanoi {
	
	Stack<Integer> input;
	Stack<Integer> buffer;
	Stack<Integer> destination;
	int disks;
	
	public TowerOfHanoi(int _disks){
		disks = _disks;
		input = new Stack<Integer>();
		buffer = new Stack<Integer>();
		destination = new Stack<Integer>();
	}
	
	public void createTower(){
		for(int i = disks;i>0;i--){
			input.push(i);
		}
	}
	
	public void moveToDestination(){
		while(!input.isEmpty()){
			getStack().push(input.pop());
		}
	}
	
	public Stack<Integer> getStack(){
		
		if(buffer.isEmpty()){
			return buffer;
		}else if(destination.isEmpty()){
			return destination;
		}else if(buffer.peek() < destination.peek()){
			moveElements(buffer, destination);
			return buffer;			
		}else if(buffer.peek() > destination.peek()){
			moveElements(destination, buffer);
			return destination;
		}
		return null;
	}
	
	public void moveElements(Stack<Integer> from, Stack<Integer> to){
		while(!from.isEmpty()){
			to.push(from.pop());
		}
	}
	
	public static void main(String[] args){
		
		TowerOfHanoi toh = new TowerOfHanoi(5);
		toh.createTower();
		System.out.println("Before move : ");
		System.out.println(toh.input);
		System.out.println(toh.buffer);
		System.out.println(toh.destination);
		
		toh.moveToDestination();
		
		System.out.println("After move : ");
		System.out.println(toh.input);
		System.out.println(toh.buffer);
		System.out.println(toh.destination);
		
	}

}


