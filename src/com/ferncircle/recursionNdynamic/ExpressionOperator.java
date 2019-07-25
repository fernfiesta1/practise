package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;

public class ExpressionOperator {
	
	private String[] options = new String[] {"+", "-", "*", "/"};
	
	public void evaluate(int[] operands, int target) {
		
		List<String> result = new ArrayList<String>();
		helper(operands, result, 0, target);
	}
	
	private void helper(int[] operands, List<String> operators, int idx, int target) {
		
		if(operators.size() == operands.length -1) {
			/*
			 * int result = evaluate(operands, operators); if(result == target) { return
			 * getResult(operands, operators); }
			 */
			
			System.out.println(operators);
			return;
		}
		
		for(int i=0; i< options.length; i++) {
			operators.add(idx, options[i]);
			helper(operands, operators, idx+1, target);
			operators.remove(idx);
		}
		
	}
	
	private int evaluate(int[] operands, List<String> operator) {
		return 0;
	}
	
	private String getResult(int[] operands, List<String> operator) {
		return null;
	}

	public static void main(String[] args) {
		ExpressionOperator eo = new ExpressionOperator();
		int[] input = new int[] {2,3,4};
		eo.evaluate(input, 4);
		

	}

}
