package com.ferncircle.string;

public class OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {

		if(s.isEmpty() && t.isEmpty()){
			return false;
		}
		
		if(s.equals(t)){
			return false;
		}
		
		int sLen = s.length();
		int tLen = t.length();
		
		if(Math.abs(Math.subtractExact(sLen, tLen)) > 1){
			return false;
		}
		
		int i=0;
		while(i<sLen && i<tLen){
			if(s.charAt(i) != t.charAt(i)){
				break;
			}
			i++;
		}
		
		if(i == sLen || i == tLen){
			return true;
		}
		if(sLen == tLen){
			return s.substring(i+1).equals(t.substring(i+1));
		}else if(sLen < tLen){
			return s.substring(i).equals(t.substring(i+1));
		}else{
			return s.substring(i+1).equals(t.substring(i));
		}
		
	}

}
