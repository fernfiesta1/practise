package com.ferncircle.string;

public class ShortestWordDistance {
	
	 public int shortestDistance(String[] words, String word1, String word2) {
	        
	        int w1Idx = -1;
	        int w2Idx = -1;
	        
	        int min = -1;
	        int sameMin = -1;
	        for(int i=0; i< words.length; i++){
	            if(words[i].equals(word1)){
	            	
	            	if(w1Idx != -1){
                        sameMin = (sameMin != -1)? Math.min(sameMin, i-w1Idx): i-w1Idx;
                    }
	                w1Idx = i;
	            }
	            
	            if(words[i].equals(word2)){
	                w2Idx = i;
	            }
	            
	            if(w1Idx > -1 && w2Idx > -1){
	               int dif = (w1Idx > w2Idx) ? w1Idx - w2Idx : w2Idx - w1Idx;
	               min = (min > -1) ? Math.min(min, dif) : dif;
	            }
	            
	        }
	        
	        return (word1 == word2)? sameMin: min;
	    }

	public static void main(String[] args) {
		
		String[] input = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistance swd = new ShortestWordDistance();
		System.out.println(swd.shortestDistance(input, "makes", "makes"));

	}

}
