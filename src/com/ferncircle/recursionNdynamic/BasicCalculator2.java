package com.ferncircle.recursionNdynamic;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5

 * 
Use a char to store the last seen operator before a number, default is '+' since no negative number.
parse consecutive digits into one number.
when last seen operator is: 
'+' : add the number to stack and reset num to zero
'-' : add negative of the number (-num) and reset num to zero
'*' : multiply num and number on top of stack, then save to the same place, reset num to 0
'/' : divide the number on top of stack by num, then save to the same place, reset num to 0

In this way we can ensure '*' and '/' are performed before '+' and '-'.
Then return the sum of all numbers in the stack.

 * @author dbrit00s
 *
 */

public class BasicCalculator2 {

	public int calculate(String s1) {

		int num = 0;
		char op = '+';
		
		String s = s1.replace(" ", "");
		Stack<Integer> temp = new Stack<>();

		for(int i=0; i< s.length(); i++){
			
			//Create an integer of the numbers around operators.
			while(i< s.length() && Character.isDigit(s.charAt(i))){
				num = num * 10 + (Integer.valueOf(s.charAt(i))) - 48; 
				i++;
			}

			//perform the function
			switch (op) {
			case ('+'):{
				temp.push(num);
				num =0;
				break;
			}
			case ('-'):	{
				temp.push(-num);
				num =0;
				break;
			}

			case ('*'):{
				temp.push(temp.pop()*num);
				num=0;
				break;
			}

			case('/'):{
				temp.push(temp.pop()/num);
				num=0;
				break;
			}

			default:{
				break;
			}

			}

			//update the operator
			if(i<s.length()){				
				op = s.charAt(i);
			}

		}

		int result =0;
		while(!temp.isEmpty()){
			result = result + temp.pop();
		}
		return result;
	}

	public static void main(String[] args) {

		BasicCalculator2 bc = new BasicCalculator2();
		System.out.println(bc.calculate("13 + 2*2"));

	}
}
