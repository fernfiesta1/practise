package com.ferncircle.recursionNdynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dbrit00s
 * 
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 *
 */
public class CoinChange2 {

	Map<Integer, Map<Integer,Integer>> cache = new HashMap<>();		
	public int change(int amount, int[] coins) {		
		return calc(amount, coins, 0);

	}

	public int calc(int amount, int[] coins, int pos) {		

		if(cache.containsKey(amount)){
			if(cache.get(amount).containsKey(pos)){
				return cache.get(amount).get(pos);
			}
		}

		if(amount == 0){
			return 1;
		}

		if(amount < 0){
			return 0;
		}

		int result =0;
		for(int i=pos; i<coins.length; i++){						
			result  += calc(amount - coins[i], coins, i);			
		}
		if(!cache.containsKey(amount)){
			cache.put(amount, new HashMap<>());
		}

		Map<Integer, Integer> temp = cache.get(amount);
		temp.put(pos, result);				
		return result;
	}

	//Memoized Solution
	Map<Integer, Map<Integer, Integer>> dp = new HashMap(); 
	int result=0;
	public int change1(int amount, int[] coins) {
		if(coins == null)
			return 0;
		return helper(amount, coins,0, 0);

	}
	private int helper(int amount, int[] coins, int runSum, int idx){
		if(runSum>amount)
			return 0;
		if(dp.containsKey(runSum) && dp.get(runSum).containsKey(idx))
			return dp.get(runSum).get(idx);
		if(amount == runSum){
			return 1;
		}    

		int result = 0;
		for( int i=idx; i<coins.length; i++){
			result += helper(amount, coins, runSum+coins[i], i);
		}
		if(!dp.containsKey(runSum)){
			dp.put(runSum, new HashMap());
		}
		Map<Integer, Integer> dp2 = dp.get(runSum);
		dp2.put(idx, result);
		return result;

	}

	public static void main(String[] args){
		CoinChange2 cc = new CoinChange2();
		System.out.println(cc.change(5, new int[]{1,2,5}));
		
		
	}



}
