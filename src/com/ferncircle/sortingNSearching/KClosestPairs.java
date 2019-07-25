package com.ferncircle.sortingNSearching;

import java.util.Arrays;

public class KClosestPairs {

public int[][] kClosest(int[][] points, int K) {
        
        int mid = quickSelect(0, points.length-1, points);
        
        while(true){
            if(mid == K-1){
                break;
            }else if(mid < K){
                mid = quickSelect(mid+1, points.length-1, points);
            }else{
                mid = quickSelect(0, mid-1,points);
            }
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int quickSelect(int low, int high, int[][] points){
        
        int i = low-1;
        int j=low;
        
        double pivot = dist(points[high]);
        
        
        while(j < high){
          
            double current = dist(points[j]);
            if(current <= pivot){
                swap(++i, j, points);
            }
            j++; 
        }
        
        swap(++i, j, points);
        
        return i;
            
    }
    
    private double dist(int[] point){
        return Math.sqrt((point[0]*point[0]) + (point[1] * point[1])); 
    }
    
    private void swap(int i, int j, int[][] points){
        
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
	
	public static void main(String[] args) {
		
		int[][] input = new int[][] {{1,3}, {-2,2},{2,-2}};
		KClosestPairs kcp = new KClosestPairs();
		System.out.println(Arrays.deepToString(kcp.kClosest(input, 2)));

	}

}
