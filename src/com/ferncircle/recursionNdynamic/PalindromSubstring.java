package com.ferncircle.recursionNdynamic;

public class PalindromSubstring {

	//Explore every center of a palindrome and expand in both directions to check if there is a palindrome with that center.
	//Total number of centers = 2N -1 where N is the length of the String.
	
	public int countSubstrings(String s) {
        int N = s.length();
        int centers = 2*N -1;
        int count = 0;
        //Explore each center
        for(int center=0; center < centers; center++){
        	
        	int left = center/2;
        	int right =left;
        	if(center%2 != 0){        		
        		right = left +1;
        	}
        	
        	while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
        		count++;
        		left--;
        		right++;
        	}
        }
        
        return count;
    }
	
	
	public static void main(String[] args) {

		PalindromSubstring ps = new PalindromSubstring();
		System.out.println(ps.countSubstrings("abccba"));

	}

}
