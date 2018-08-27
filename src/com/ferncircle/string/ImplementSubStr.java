package com.ferncircle.string;

public class ImplementSubStr {

	public int strStr(String haystack, String needle) {

		if(haystack == null || needle == null){
			return -1;
		}
		if(needle.length() > haystack.length()){
			return -1;
		}
		if( haystack.isEmpty() || needle.isEmpty()){
			return 0;
		}	

		for(int i=0; i< haystack.length(); i++){	
			
			for(int j=0; j< needle.length(); j++){
				if(i+j>haystack.length()-1){
					return -1;
				}
				if(haystack.charAt(i+j) != needle.charAt(j)){
					break;
				}
				if(j == needle.length()-1 && needle.charAt(j) == haystack.charAt(i+j)){
					return i;
				}
			}
			
		}		

		return -1;
	}

	public static void main(String[] args){
		ImplementSubStr ss = new ImplementSubStr();
		String haystack = "mississippi";		
		String needle = "issippi";
		System.out.println(ss.strStr(haystack, needle));
	}
}
