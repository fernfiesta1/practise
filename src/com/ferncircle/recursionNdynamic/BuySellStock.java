package com.ferncircle.recursionNdynamic;

public class BuySellStock {

	public int maxProfit(int[] prices) {

		int buy = prices[0];
		int sell = prices[0];
		int profit = buy - sell;
		
		int currentBuy = buy;
		for(int i=1; i<prices.length; i++){
			int tempProfit = prices[i] - currentBuy;
			if(tempProfit<0){
				currentBuy = prices[i];
			}else{
				if(tempProfit>profit){
					sell = prices[i];
					profit = tempProfit;
					buy = currentBuy;
				}
			}
		}
		
		return profit;
		
	}	
	
	public int maxProfit1(int[] prices){
		if(prices.length == 0){
			return 0;
		}
		
		int profit = 0;
		
		int buy = prices[0];
		for(int i=1; i< prices.length; i++){
			buy = Math.min(buy, prices[i]);
			profit = Math.max(profit, prices[i] - buy);
		}
		
		return profit;
	}
	

	public static void main(String[] args) {
		

	}

}
