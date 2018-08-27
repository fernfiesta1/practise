package com.ferncircle.recursionNdynamic;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		if(s.isEmpty() || s.length() == 1){
			return s;
		}
		 int N = s.length();
	        int centers = 2*N -1;
	      
	        //Explore each center
	        int i=0;
	        int j=0;
	        int length=0;
	        for(int center=0; center < centers; center++){
	        	
	        	int left = center/2;
	        	int right =left;
	        	if(center%2 != 0){        		
	        		right = left +1;
	        	}
	        	
	        	while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
	        		int lengthOfSubSring = (right - left) +1;
	        		if(length < lengthOfSubSring){
	        			i = left;
	        			j = right;
	        			length = lengthOfSubSring;
	        		}
	        		
	        		left--;
	        		right++;
	        	}
	        }
	        
	        
		return s.substring(i, j+1);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring ps = new LongestPalindromicSubstring();
		System.out.println(ps.longestPalindrome("ab"));

	}

}
