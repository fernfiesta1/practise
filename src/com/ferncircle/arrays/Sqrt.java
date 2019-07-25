package com.ferncircle.arrays;

public class Sqrt {
	
	 public int mySqrt(int x) {
	        
	        if(x == 0){
	            return 0;
	        }
	        
	        if(x ==1){
	            return 1;
	        }      
	        
	        int start = 1;
	        int end = x/2;
	        while(start <= end){
	            int mid = (start + end)/2;
	            
	            if(mid * mid == x || (x > mid*mid && ((mid+1)*(mid+1) > x)))
	                return mid;
	            
	            if(mid * mid < x){
	                start = mid +1;
	            }else{
	                end = mid-1;
	            }
	        }
	       return 0;
	}
	 
	 public static void main(String[] args) {
		  Sqrt s = new Sqrt();
		  System.out.println(s.mySqrt(8));
	 }

}
