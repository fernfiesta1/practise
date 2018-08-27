package com.ferncircle.string;

/**
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * @author dbrit00s
 *
 */
public class AddStrings {

	public String addStrings(String num1, String num2) {
		
		//Get the minimum of two string
		int min = Math.min(num1.length(), num2.length());	

		//prepend zeros to the smaller string
		if(num1.length() == min){
			for(int i=0; i<(num2.length() - min); i++){
				num1 = "0" +num1;
			}
		}else{
			for(int i=0; i<(num1.length() - min); i++){
				num2 = "0" + num2;
			}
		}

		int carry =0;
		StringBuffer result = new StringBuffer();
		int index = num1.length();
		while(index>0){
			
			//extract the integer value from the ASCII value if the char
			int a = num1.charAt(index-1) - 48;
			int b = num2.charAt(index -1) - 48;
			int sum = a +b + carry;
			if(sum/10>0){
				carry = sum/10;
				result.append(sum%10);	
			}else{
				carry = 0;
				result.append(sum);
			}
				
			index--;
		}		
		if(carry>0){
			result.append(carry);
		}

		return result.reverse().toString();
	}
	
	public static void main(String[] args){
		AddStrings as = new AddStrings();
		System.out.println(as.addStrings("1", "0"));
	}
}
