package com.ferncircle.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class ValidParanthesis {
	
	public boolean isValid(String s) {
		
		
		if(s.isEmpty() || s.length() == 1 || s.length() % 2 !=0){
			return false;
		}

		Map<Character, Character> paranthesisMap = getParanthesisMap();		
		
		Deque<Character> stack = new ArrayDeque<Character>();
		for(int i=0; i<s.length(); i++){
			
			//push in the stack if you find opening bracket
			if(paranthesisMap.containsKey(s.charAt(i))){
				stack.push(s.charAt(i));
			}else{
				if(stack.isEmpty()){
					return false;
				}
				char openingbracket = stack.pop();
				char closingbracket = s.charAt(i);
				if(paranthesisMap.get(openingbracket).equals(closingbracket)){
					continue;
				}else{
					return false;
				}
			}
		}
		
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}	
		
		
	}

	public static void main(String[] args) {

		ValidParanthesis vp = new ValidParanthesis();
		Assert.assertFalse(vp.isValid(""));
		Assert.assertFalse(vp.isValid("{"));
		Assert.assertFalse(vp.isValid("({"));		
		Assert.assertFalse(vp.isValid("(]"));
		Assert.assertFalse(vp.isValid("([)]"));
		Assert.assertFalse(vp.isValid("([)"));
		Assert.assertFalse(vp.isValid("([]"));
		Assert.assertFalse(vp.isValid("){"));
		
		Assert.assertTrue(vp.isValid("()"));
		Assert.assertTrue(vp.isValid("()[]{}"));
		Assert.assertTrue(vp.isValid("([])"));
		
		assertThat(new ValidParanthesis().isValid("()[]{}"), is(true));
		
		
		System.out.println("Test successful");

	}
	
	public Map<Character, Character> getParanthesisMap(){
		
		Map<Character, Character> paranthesisMap = new HashMap<Character, Character>();
				
		paranthesisMap.put('(', ')');
		paranthesisMap.put('[', ']');
		paranthesisMap.put('{', '}');
		
		return paranthesisMap;
	}

}
