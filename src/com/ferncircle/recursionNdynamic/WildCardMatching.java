package com.ferncircle.recursionNdynamic;

public class WildCardMatching {

	 public boolean isMatch1(String s, String p) {
		 
		 return helper(s,p,s.length()-1,p.length()-1);
	    }
	    
	    private boolean helper(String s, String p, int sIdx, int pIdx){
	        if(sIdx < 0 && pIdx < 0){
	            return true;
	        }
	        
	        if(pIdx < 0 || (p.charAt(pIdx) == '?' && sIdx < 0)){
	            return false;
	        }
	        
	        if(p.charAt(pIdx) == '?' || (sIdx >=0 && s.charAt(sIdx) == p.charAt(pIdx))){
	            return helper(s,p,sIdx-1, pIdx-1);
	        }else if(p.charAt(pIdx) == '*'){
	        	if(sIdx >=0) {
	        		return helper(s,p,sIdx-1,pIdx) || helper(s,p,sIdx, pIdx-1); 
	        	}else {
	        		return helper(s,p,sIdx, pIdx-1);
	        	}
	        }
	        
	        return false;
	    }
	    
	    private boolean isMatch(String s, String p) {
	    	
	    	boolean[][] dp = new boolean[p.length()+1][s.length()+1];
	    	
	    	dp[0][0] = true;
		
	    	
	    	for(int i=0; i< dp.length; i++) {
	    		for(int j=0; j< dp[0].length; j++) {		
	    				    			
	    			if(i==0) {
	    				continue;
	    			}
	    			
	    			if(p.charAt(i-1) == '*') {
	    				if(j == 0) {    					
	    					dp[i][j] = dp[i-1][j];
	    				}else {
	    					dp[i][j] = dp[i-1][j] || dp[i][j-1];
	    				}
	    			}else if((j>0 && s.charAt(j-1) == p.charAt(i-1)) || (j>0 && p.charAt(i-1) == '?')) {
	    				dp[i][j] = dp[i-1][j-1];
	    			}    			
				
	    		}
	    	}
	    	
	    	return dp[p.length()][s.length()];
	    }
	    
	    public static void main(String[] args) {
	    	WildCardMatching wcm = new WildCardMatching();
	    	System.out.println(wcm.isMatch("s", "?*"));

	    }
}
