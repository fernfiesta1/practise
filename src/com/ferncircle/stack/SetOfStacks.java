package com.ferncircle.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
	
	Stack<Integer> current;
	int threshold;
	
	List<Stack<Integer>> _setOfStack = new ArrayList<Stack<Integer>>();
	
	public SetOfStacks(int _threshold){
		current = new Stack<Integer>();
		threshold = _threshold;
	}
	
	public void push(Integer item){
		
		if(current.size() == threshold){
			_setOfStack.add(current);
			current = new Stack<Integer>();			
		}
		current.push(item);
	}
	
	public Integer pop(){
		
		if(current.isEmpty() && !_setOfStack.isEmpty()){
			current = _setOfStack.remove(_setOfStack.size() -1);			
		}
		
		if(current.isEmpty() && _setOfStack.isEmpty()){
			throw new EmptyStackException();
		}
		return current.pop();
	}
	
	

	public static void main(String[] args) {
		
		SetOfStacks _set = new SetOfStacks(2);
		
		_set.push(1);
		_set.push(2);
		_set.push(3);
		_set.push(4);
		_set.push(5);
		
		System.out.println("Total stacks in array is :" + _set._setOfStack.size());
		System.out.println(_set.pop());
		_set.push(6);
		_set.push(9);
		System.out.println(_set.pop());
		System.out.println(_set.pop());
		System.out.println(_set.pop());
		System.out.println(_set.pop());
		System.out.println(_set.pop());
		
		
		
	}

}
