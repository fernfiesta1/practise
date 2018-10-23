package com.ferncircle.recursionNdynamic;

import java.util.Arrays;

public class PerfectSquares {

	public int numSquares(int n) {
		if(n==0){
			return 0;
		}
		
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=1; i< dp.length; i++){
			for(int j=1; j*j < n; j++){
				if(j*j <= i){
					dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
				}
			}
		}	
		
		return dp[dp.length-1];

	}

	public static void main(String[] args) {
		
		PerfectSquares ps = new PerfectSquares();
		ps.numSquares(13);

	}

}
