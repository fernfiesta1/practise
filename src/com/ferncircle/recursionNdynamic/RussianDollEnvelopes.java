package com.ferncircle.recursionNdynamic;

import java.util.Arrays;

public class RussianDollEnvelopes {
	
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length ==0){
            return 0;
        }
        
        Arrays.sort(envelopes, (m1, m2) -> {
           
            if(m1[0] == m2[0]){
                return m2[1] - m1[1];
            }else{
                return m1[0] - m2[0];
            }
        });
        
        int[] dp = new int[envelopes.length+1];
        for(int i=0; i< envelopes.length; i++) {
        	
        	int max = 1;
        	for(int k=0; k<i; k++) {
        		int temp =0;
        		if(envelopes[k][1] < envelopes[i][1]) {
        			temp = 1 + dp[k+1];
        			max = Math.max(max,temp);
        		}
        	}
        	dp[i+1] = max;
        	
        }
        
        int result =0;
        for(int i=0; i< dp.length; i++) {
        	result = Math.max(result, dp[i]);
        }
        
        return result;
    }

	public static void main(String[] args) {


		RussianDollEnvelopes rd = new RussianDollEnvelopes();
		int[][] input = new int[][] {
			{46,89},{50,53},{52,68},{72,45},{77,81}
		};
		System.out.println(rd.maxEnvelopes(input));

	}

}
