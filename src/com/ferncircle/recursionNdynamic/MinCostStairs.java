package com.ferncircle.recursionNdynamic;

import java.io.ObjectOutputStream.PutField;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * @author dbrit00s
 *
 */
public class MinCostStairs {


	public int minCostClimbingStairs(int[] cost) {

		if(cost.length == 0){
			return 0;
		}
		
		if(cost.length ==1){
			return cost[0];
		}	
		
		int[] output = new int[cost.length];
		output[0] = cost[0];
		output[1] = cost[1];
		
		for(int i=2; i< cost.length; i++){
			output[i] = cost[i] + Math.min(output[i-1], output[i-2]); 
		}
		
		return Math.min(output[output.length-1], output[output.length-2]);
	}
	
	public static void main(String[] args) {
		MinCostStairs mcs = new MinCostStairs();
		System.out.println(mcs.minCostClimbingStairs(new int[]{0,0,1,1}));

	}

}
