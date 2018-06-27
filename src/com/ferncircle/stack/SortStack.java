package com.ferncircle.stack;

import java.util.Stack;

public class SortStack {
	
	public static Stack<Integer> sort(Stack<Integer> input){
		
		Stack<Integer> output = new Stack<Integer>();
		
		while(!input.isEmpty()){
			int temp = input.pop();
			while(!output.isEmpty() && output.peek() < temp){
				input.push(output.pop());
			}
			output.push(temp);
			
		}
		
		return output;
	}
	
	public static void main(String[] args){
		
		Stack<Integer> input = new Stack<Integer>();
		input.push(8);
		input.push(11);
		input.push(1);
		input.push(9);
		input.push(21);
		
		System.out.println("Before sorting :" + input);
		System.out.println("After sorting :" + sort(input));
		
	}

}
