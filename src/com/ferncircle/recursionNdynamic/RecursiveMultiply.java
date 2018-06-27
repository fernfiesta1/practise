package com.ferncircle.recursionNdynamic;

public class RecursiveMultiply {
	
	public int multiply(int a, int b){
		
		if(a == 0 || b == 0){
			return 0;
		}
		
		if(a == 1){
			return b;
		}
		
		if(b == 1){
			return a;
		}
		
		return a + multiply(a, b-1);
		
	}

	public static void main(String[] args) {
		
		RecursiveMultiply rm = new RecursiveMultiply();
		System.out.println(rm.multiply(123, 456));

	}

}
