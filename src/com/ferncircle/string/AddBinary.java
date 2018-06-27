package com.ferncircle.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.ferncircle.arrays.MoveZeroes;

/**
 * @author dbrit00s
 * 
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

0+0 = 0
0+1 = 1
1+0 = 1
1+1 = 0 carry 1
1+1+1 = 1 carry 1

Hints:
Binary means 2. In these kind of problems always check if you can do <num>%2 or <num>/2

Logic:
Sum= ai + bi + carry
Res. Append(sum%2)
Carry=sum/2
Just think how you add regular numbers
They are base 10 (0.....9)
E.g. 9+5
14 % 10
Carry= 14/10


 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {

		StringBuffer result = new StringBuffer();
		int carry = 0;

		int i = a.length();
		int j= b.length();
		while(i>0 && j >0) {
			int sum = Integer.parseInt("" +a.charAt(i-1)) + Integer.parseInt("" + b.charAt(j-1)) + carry;			
			result.append(sum%2);
			carry = sum/2;	

			i--;
			j--;

		}

		while(i > 0) {

			int sum = Integer.parseInt("" +a.charAt(i-1)) + carry;			
			result.append(sum%2);
			carry = sum/2;	

			i--;

		}

		while(j > 0) {

			int sum = Integer.parseInt("" + b.charAt(j-1)) + carry;			
			result.append(sum%2);
			carry = sum/2;	

			j--;
		}
		
		if(carry == 1) {
			result.append(carry);
		}

		return result.reverse().toString();
	}
	
	public String addBinaryWithout2while(String a, String b) {
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
		int maxLen = Math.max(a.length(), b.length());
		StringBuilder res = new StringBuilder(maxLen);
		int ia, ib, carry = 0;
		for (int i = 0; i <= maxLen; i++) {
			ia = (i < a.length() ? Integer.parseInt(a.charAt(i) + "") : 0);
			ib = (i < b.length() ? Integer.parseInt(b.charAt(i) + "") : 0);
			int sum = ia + ib + carry;
			carry = sum >= 2 ? 1 : 0;
			if (i != maxLen || sum != 0) res.append(sum % 2);
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {

		assertThat(new AddBinary().addBinary("000", "111"), is("111"));
		assertThat(new AddBinary().addBinary("11", "1"), is("100"));
		assertThat(new AddBinary().addBinary("111", "111"), is("1110"));
		assertThat(new AddBinary().addBinary("0", "11"), is("11"));
		
		System.out.println("Test Successful");

	}

}
