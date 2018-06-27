/**
 * 
 */
package com.ferncircle.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SFargose
 *
 */
public class FirstNonRepeatingCharacter {

	//return '0' if not found e.g. 'aaa'
	public Character firstChar(String s){
		
		return '0';
	}
	
	public static void main(String[] args) {
		
		assertThat(new FirstNonRepeatingCharacter().firstChar("dpcggaefwefkviwkerpwalwdejfvghkeqoffvnajfvafaefawdpc"), is('i'));
		
		assertThat(new FirstNonRepeatingCharacter().firstChar("aaa"), is('0'));
		assertThat(new FirstNonRepeatingCharacter().firstChar("dcda"), is('c'));
		assertThat(new FirstNonRepeatingCharacter().firstChar("dpcggwdpc"), is('w'));

		assertThat(new FirstNonRepeatingCharacter().firstChar("dpcggaefwefkviwkerpwalwdejfvghkeqoffvnajfvafaefawdpc"), is('i'));
		System.out.println("all cases passed");

	}

}
