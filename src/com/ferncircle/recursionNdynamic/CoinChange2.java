package com.ferncircle.recursionNdynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dbrit00s * 
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

NOTE: If asked number of combinations(only going forward), then for bottom up outer loop is coins and inner loop is amount.

 *
 */
public class CoinChange2 {

	Map<Integer, Map<Integer,Integer>> cache = new HashMap<>();		
	public int change(int amount, int[] coins) {		
		return calc(amount, coins, 0);

	}

	public int calc(int amount, int[] coins, int pos) {	

		if(amount == 0){
			return 1;
		}

		if(amount < 0){
			return 0;
		}

		if(cache.containsKey(amount)){
			if(cache.get(amount).containsKey(pos)){
				return cache.get(amount).get(pos);
			}
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

	public int changeBottomUp(int amount, int[] coins){

		int[] result = new int[amount+1];

		result[0] = 1;

		for(int j=0; j<coins.length; j++){
			for(int i=1; i<result.length; i++){
				int temp = i-coins[j];
				if(temp>=0){
					result[i] += result[temp];
				}
			}
		}

		return result[amount];

	}

	public static void main(String[] args){
		CoinChange2 cc = new CoinChange2();
		System.out.println(cc.change(5, new int[]{1,2,5}));
		System.out.println("Bottom up : " + cc.changeBottomUp(5, new int[]{1,2,5}));


	}



}
