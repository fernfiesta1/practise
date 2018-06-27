package com.ferncircle.string;

import junit.framework.Assert;

public class OneAway {

	public boolean solution(String s1, String s2){

		if(s1.equals(s2)){
			return true;
		}
		
		if(s2.length() > s1.length()+1 || s2.length()<s1.length()-1){
			return false;
		}
		
		
		int noOfEdits =0; 
		String smallerStr = null;
		String longerStr = null;
		
		if(s1.length() < s2.length()){
			smallerStr = s1;
			longerStr = s2;
		}else{
			smallerStr = s2;
			longerStr = s1;
		}
		
		int j=0;
		for(int i=0; i<longerStr.length(); i++){
			if(j == smallerStr.length() -1 && i< longerStr.length()-1){
				noOfEdits = noOfEdits+1;
				break;
			}
			if(smallerStr.length()!= j+1 && longerStr.charAt(i) == smallerStr.charAt(j)){
				j++;
			}else{
				noOfEdits++;
				if(longerStr.length() == smallerStr.length()){
					j++;
				}
			}
		}
		
		if(noOfEdits >1){
			return false;
		}else{
			return true;
		}
	}

	

	public static void main(String[] args) {
		
		OneAway oneAway = new OneAway();
		
		Assert.assertTrue(oneAway.solution("pale", "ple"));
		/*Assert.assertTrue(oneAway.solution("pale", "pales"));
		Assert.assertTrue(oneAway.solution("bale", "pale"));
		Assert.assertFalse(oneAway.solution("pale", "bike"));
		Assert.assertFalse(oneAway.solution("pale", "paleser"));
		Assert.assertFalse(oneAway.solution("pale", "p"));*/
		
		System.out.println("Test successful");
		

	}

}
