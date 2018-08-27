package com.ferncircle.math;

/**
 * Swap a number in place without using temperory variable.
 * @author dbrit00s
 *
 */
public class NumberSwapper {
	
	public void swap(int a, int b){
		
		System.out.println("values of a and b befor swap : " + a + ", " + b);
		b = a+b; 
		a = b-a;
		b = b-a;
		
		System.out.println("values of a and b after swap : " + a + ", " + b);
		
	}

	public static void main(String[] args) {
		
		NumberSwapper ns = new NumberSwapper();
		ns.swap(30, 20);

	}

}
