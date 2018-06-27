package com.ferncircle.math;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {

		int output=0;
		int input =x;
		while(x>0){
			
			output = (output*10) + (x%10);
			x = x/10;	
			
		}
		
		if(input == output){
			System.out.println(output);
			return true;
		}else{
			return false;
		}
		
		
	}

	public static void main(String[] args) {

		PalindromeNumber pn = new PalindromeNumber();
		if(pn.isPalindrome(0)){
			System.out.println("Test Successfull");
		}
		
		

	}

}
