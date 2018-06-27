package com.ferncircle.recursionNdynamic;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	HashMap<Integer, Integer> cache=new HashMap<Integer, Integer>();
	
	public int coinChange(int[] coins, int amount) {
		
		int min = backtrackBottomUp(coins, amount, cache);
		return min == Integer.MAX_VALUE?-1:min;
	}	

	private int backtrackBottomUp(int[] coins, int amt, Map<Integer, Integer> cache ){	

		if(cache.containsKey(amt)){
			return cache.get(amt);
		}
		
		if(amt == 0){
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++){
			if(coins[i] > amt){
				continue;
			}
			
			int currMin = backtrackBottomUp(coins, amt - coins[i], cache);
			min = Math.min(min, currMin);
		}
		
		min = (min == Integer.MAX_VALUE)? Integer.MAX_VALUE: min +1;
		cache.put(amt, min);
		return min;
	}
	
	private int topDown(int[] coins, int amt){
		
		//Initialize the integer array with the max value;
		int[] temp = new int[amt+1];
		temp[0]=0;
		for(int i=1; i< temp.length; i++){
			temp[i] = Integer.MAX_VALUE;
		}
		
		
		for(int i=1; i< amt+1; i++){
			for(int j=0; j< coins.length; j++){
				int diff = i - coins[j];
				if(diff >= 0){
					int curr = (temp[diff]== Integer.MAX_VALUE)? Integer.MAX_VALUE: temp[diff]+ 1;
					temp[i] = Math.min(temp[i], curr);
				}
			}
		}
		
		return temp[amt];
		
	}

	public static void main(String[] args) {
		int[] input = new int[]{2,5};
		CoinChange cc = new CoinChange();
		//System.out.println(cc.coinChange(input, 5));

		System.out.println("top down : "+ cc.topDown(input, 3));
	}

}
