package com.ferncircle.recursionNdynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dbrit00s
 *
 *You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Complexity:
Recursion = n!
Iterative = O(n)

 */

//TODO: How to calculate the complexity for Memoisation solution
public class ClimbingStairs {
	
	public int climb(int n){
		if(n == 1){
			return 1;
		}
		
		if(n == 2){
			return 2;
		}
		
		return climb(n-1) + climb(n-2);
	}
	
	public int climbStairs(int n){
		if(n == 1){
			return 1;
		}
		
		if(n == 2){
			return 2;
		}
		
		int temp1 = 1;
		int temp2 = 2;
		
		for(int i=3; i< n; i++){
			int temp3 = temp1 + temp2;
			
			temp1 = temp2;
			temp2 = temp3;
		}
		
		return temp2;
	}
	
	public int climbStairsMemo(int n){
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
		return helper(n, memo);
		
	}

	private int helper(int n, Map<Integer, Integer> memo){
		if(n == 1){
			return 1;
		}
		
		if(n == 2){
			return 2;
		}
		
		if(memo.get(n) != null){
			return memo.get(n);
		}
		
		int result = helper(n-1, memo) + helper(n-2, memo);
		memo.put(n, result);
		return result;
		
	}
}
