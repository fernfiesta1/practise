package com.ferncircle.stack;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> valueStack;
	Stack<Integer> minStack;

	 /** initialize your data structure here. */
    public MinStack() {
    	valueStack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	
    	valueStack.push(x);
    	if(x <= getMin()){
    		minStack.push(x);
    	}
        
    }
    
    public void pop() {
        if(valueStack.peek().intValue() == minStack.peek().intValue()){
        	minStack.pop();
        }
        
        valueStack.pop();
    }
    
    public int top() {
        return valueStack.peek();
    }
    
    public int getMin() {
    	if(minStack.isEmpty()){
    		return Integer.MAX_VALUE;
    	}else{
    		return minStack.peek();
    	}   	
        
    }
    
    public static void main(String[] args){
    	MinStack obj = new MinStack();
    	obj.push(512);
    	obj.push(-1024);
    	obj.push(-1024);
    	obj.push(512);
    	System.out.println(obj.minStack);
    	obj.pop();
    	System.out.println(obj.getMin());
    	
    	System.out.println(obj.minStack);
    	obj.pop();
    	System.out.println(obj.getMin());
    	
    	System.out.println(obj.minStack);
    	obj.pop();
    	System.out.println(obj.getMin());
    }
}
