package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {

	public List<String> removeInvalidParentheses(String s) {

		List<String> temp = new ArrayList<String>();
		String st = new String();
		helper(2,2,0,1,st, temp, s, 0);
		System.out.println(temp);
		return temp;

	}

	public void helper(int open, int close, int openRem, int closeRem, String temp, List<String> result, String s, int idx) {

		if(open == 0 && close == 0 && openRem == 0 && closeRem == 0) {
			result.add(temp);
			return;
		}

		if(s.charAt(idx) == '(') {
			if(openRem > 0) {
				helper(open, close, openRem -1, closeRem, temp, result, s, idx + 1);

			}else if(open > 0){
				temp = temp + '(';
				helper(open -1, close, openRem, closeRem, temp, result, s, idx+1);

			}
		}else {
			if(closeRem > 0) {
				helper(open, close, openRem, closeRem-1, temp, result, s, idx +1);

			}else if (close > open) {
				temp = temp + ")";
				helper(open, close-1, openRem, closeRem, temp, result, s, idx + 1);
			}
		}



	}
	public static void main(String[] args) {
		RemoveInvalidParenthesis rm = new RemoveInvalidParenthesis();
		rm.removeInvalidParentheses("(()))");

	}

}
