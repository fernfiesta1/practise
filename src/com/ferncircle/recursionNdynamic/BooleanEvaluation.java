package com.ferncircle.recursionNdynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BooleanEvaluation {
	
	public int evaluateTopDown(String expression, boolean result, Map<String, Integer> cache){
				
		char[] expr = expression.toCharArray();
		if(expr.length == 1){
			if(expr[0] == 'T' && result){
				return 1;
			}else if(expr[0] == 'T' && !result){
				return 0;
			}else if(expr[0] == 'F' && result){
				return 0;
			}else {
				return 1;
			}
		}	
		
		
		if(cache.containsKey(expression+result)){
			return cache.get(expression+result);
		}
		
		int count = 0;
		for(int k=1; k<expr.length-1; k+=2){
			//Get count of true and false for left expression
			String lhs = expression.substring(0,k);
			int lhsCountTrue = evaluateTopDown(lhs, true, cache);
			int lhsCountFalse = evaluateTopDown(lhs, false, cache);
			
			//Get count of true and false for right expression
			String rhs = expression.substring(k+1);
			int rhsCountTrue = evaluateTopDown(rhs, true,cache);
			int rhsCountFalse = evaluateTopDown(rhs, false, cache); 
			
			int finalCountTrue = 0;
			int finalCountFalse = 0;
			int finalCount=0;
			if(result){
				if(expr[k] == '^'){
					finalCountTrue = (lhsCountTrue*rhsCountFalse) + (lhsCountFalse*rhsCountTrue);
				}else if(expr[k] == '&'){
					finalCountTrue = (lhsCountTrue * rhsCountTrue);
				}else if(expr[k] == '|'){
					finalCountTrue = (lhsCountTrue*rhsCountFalse) + (lhsCountFalse*rhsCountTrue) + (lhsCountTrue*rhsCountTrue);
				}
				finalCount =  finalCountTrue;
			}else{
				if(expr[k] == '^'){
					finalCountFalse = (lhsCountFalse*rhsCountFalse) + (lhsCountTrue*rhsCountTrue);
				}else if(expr[k] == '&'){
					finalCountFalse = (lhsCountTrue * rhsCountFalse) + (lhsCountFalse*rhsCountTrue) + (lhsCountFalse*rhsCountFalse);
				}else if(expr[k] == '|'){
					finalCountFalse = (lhsCountFalse*rhsCountFalse);
				}
				
				finalCount =  finalCountFalse;					
			}			
			
			count+=finalCount;
			cache.put(expression+result, count);
		}
		return count;
	}
	
	
	public int evaluateBottomUp(String expression, boolean result){
		
		char[] expr = expression.toCharArray();
		int length = expr.length;
		int[][] dpTrue = new int[length][length];
		int[][] dpfalse = new int[length][length];
		
		//Fill in the true and false dp arrays when chunk size is 1
		for(int i=0; i< expr.length; i+=2){
			if(result && expr[i] == 'T'){
				dpTrue[i][i] = 1;
			}
			if(!result && expr[i] == 'F'){
				dpfalse[i][i] = 1;
			}		
			
		}
		
		//chunk size denotes number of operands in the expression
		for(int chunk = 2; chunk < (length/2) +1; chunk++){
			for(int begin = 0; begin < length - chunk - (chunk -1) +1; begin+=2){
				int end = begin + chunk + (chunk-1) -1;				
				for(int k = begin +1; k< end ; k+=2){
					
					int lhsTrueCount = dpTrue[begin][k-1];
					int lhsFalseCount = dpfalse[begin][k-1];
					int rhsTrueCount = dpTrue[k+1][end];
					int rhsFalseCount = dpfalse[k+1][end];
					
					if(expr[k] == '^'){
						dpTrue[begin][end] = (lhsTrueCount * rhsFalseCount) + (rhsTrueCount * lhsFalseCount);
						dpfalse[begin][end] = (lhsTrueCount * rhsTrueCount) + (lhsFalseCount * rhsFalseCount);
						
					}else if(expr[k] == '|'){
						dpTrue[begin][end] = (lhsTrueCount * rhsFalseCount) + (lhsFalseCount * rhsTrueCount) + (lhsTrueCount * rhsTrueCount);
						dpfalse[begin][end] = (lhsFalseCount * rhsFalseCount);
						
					}else if(expr[k] == '&'){
						dpTrue[begin][end] = (lhsTrueCount * rhsTrueCount);
						dpfalse[begin][end] = (lhsFalseCount * rhsTrueCount) + (lhsTrueCount * rhsFalseCount) + (lhsFalseCount * rhsFalseCount);
					}
				}
			}
		}
		
		System.out.println("True array: ");
		for(int i=0; i< dpTrue.length; i++){			
			System.out.println(Arrays.toString(dpTrue[i]));
		}
		if(result){
			return dpTrue[0][length-1];
		}else{
			return dpfalse[0][length-1];
		}
	}
	

	public static void main(String[] args) {
		
		String input = "T^F&T";
		BooleanEvaluation be = new BooleanEvaluation();
		Map<String, Integer> cache = new HashMap<>();
		System.out.println("top Down : " + be.evaluateTopDown(input, true, cache));
		
		//System.out.println("Bottom up: " + be.evaluateBottomUp(input, true));

	}

}
