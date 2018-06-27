package com.ferncircle.string;

import junit.framework.Assert;

/**
 * @author dbrit00s

Assume you have a method isSubstring which checks if one word is a substring of another. 
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

 */
public class StringRotation {

	public boolean solution(String s1, String s2){

		if(s1.length() != s2.length()){
			return false;
		}

		String temp = s2 + s2;
		if(temp.contains(s1)){
			return true;
		}

		return false;

	}

	public static void main(String[] args) {

		StringRotation st = new StringRotation();
		Assert.assertTrue(st.solution("apple", "pplea"));
		Assert.assertTrue(st.solution("waterbottle", "bottlewater"));
		Assert.assertFalse(st.solution("orange", "rangea"));


	}

}
