package com.ferncircle.math;

import junit.framework.Assert;

public class ReverseInteger {

	public int reverse1(int x) {

		boolean ispositive = false;
		if(x>=0){
			ispositive = true;
		}		
		String input = String.valueOf(x);			
		StringBuffer sb;
		String output = null;
		if(ispositive){
			sb = new StringBuffer(input).reverse();
			output = sb.toString();
		}else{
			sb = new StringBuffer(input.substring(1)).reverse();
			output = "-"+sb.toString();
		}
		
	
		return Integer.parseInt(output);
	}
	
	public int reverse2(int x) {
		
		long input = x;
		
		if(input == 0){
			return 0;
		}
		
		boolean isNegative=false;
		
		if(input < 0){
			isNegative = true;
			input = 0-input;
		}
		
		long output=0;
		while(input > 0){
			
			output = (output*10) + (input%10);
			input = input/10;	
		}
		
		
		if(output>Integer.MAX_VALUE || output < Integer.MIN_VALUE){
			output = 0;
		}else if(isNegative){
			output = 0-output;
		}		
		
		return (int) output;

	}
	
		
	
	

	public static void main(String[] args) {
		
		ReverseInteger ri = new ReverseInteger();
		Assert.assertEquals(123, ri.reverse2(321));
		Assert.assertEquals(-546, ri.reverse2(-645));
		Assert.assertEquals(0, ri.reverse2(0));
		Assert.assertEquals(55444, ri.reverse2(44455));
	
				
		System.out.println("Test Successfull");
		
		
		

	}

}
