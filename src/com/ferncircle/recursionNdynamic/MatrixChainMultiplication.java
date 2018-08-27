package com.ferncircle.recursionNdynamic;

public class MatrixChainMultiplication {

	public int matrixChainMultipyTopDown(int[] in, int start, int end){

		//Cost to multiply single matrix
		if(start == end){
			return 0;
		}

		int min = Integer.MAX_VALUE;

		//Break the input matrix into left and right sides.
		//K is the point of brealk
		for(int k = start; k< end; k++){
			//Minimum cost to calculate the LHS
			int minleft = matrixChainMultipyTopDown(in, start, k);

			//Minimum cost to calculate the RHS
			int minRight = matrixChainMultipyTopDown(in, k+1, end);

			//cost to calculate the final matrices
			int cost = in[start-1]*in[k]*in[end];

			int finalcost = minleft + minRight + cost;
			min = Math.min(min, finalcost);

		}

		return min;
	}
	
	public int matrixChainMultiplyBottomUp(int[] in){
		
		int dpLength = in.length-1;
		int[][] dp = new int[dpLength][dpLength];
		
		//Loop for creating the chunks.
		//we will have chunks from 1 to dpLength
		for(int chunkSize =1; chunkSize < dpLength; chunkSize++){
			
			for(int begin = 0; begin < dpLength-chunkSize;begin++){
				int end = begin + chunkSize;
				
				dp[begin][end] = Integer.MAX_VALUE;
				for(int k=begin; k<end ;k++){
					int lhsCost = dp[begin][k];
					int rhsCost = dp[k+1][end];
					int totalCost = lhsCost + rhsCost + (in[begin]*in[k+1]*in[end+1]);
					dp[begin][end] = Math.min(dp[begin][end], totalCost);
				}
			}
		}
		
		return dp[0][dpLength -1];
	}

	
	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4, 3};
		int n = arr.length;

		MatrixChainMultiplication mcm = new MatrixChainMultiplication();
		System.out.println("Minimum number of multiplications with top down approach is "+
				mcm.matrixChainMultipyTopDown(arr, 1, n-1));

		System.out.println("Minimum number of multiplications for bottom up apprach is " + mcm.matrixChainMultiplyBottomUp(arr));
		
	}

}
