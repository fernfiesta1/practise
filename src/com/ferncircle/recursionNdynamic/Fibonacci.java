package com.ferncircle.recursionNdynamic;

public class Fibonacci {
	
	public int fibonacci(int n){
		if(n==0){
			return 0;
		}
		if(n == 1)
			return 1;
		if(n==2)
			return 1;
		if(n <0){
			return -1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
	
	public int fibonacciIterative(int n){
		
		if(n < 0){
			return -1;
		}
		
		if(n == 0){
			return 0;
		}
		
		int fiba = 1;
		int fibb =1;
		
		for(int i=3; i<=n;i++){
			int fibi = fiba + fibb;
			
			fiba = fibb;
			fibb = fibi;
		}
		return fibb;
	}

	public static void main(String[] args) {
		
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(6));
		System.out.println(f.fibonacciIterative(6));

	}

}
