package com.ferncircle.string;

import junit.framework.Assert;

public class LongestCommonPrefix {


	public String longestCommonPrefix(String[] strs) {

		
		if(strs==null || strs.length==0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		
		String curr = null;
		String pre = null;
		StringBuffer sb = null;
		for(int i=1; i<strs.length; i++){
			
			curr = strs[i];
			if (pre == null){				
				pre = strs[i-1];
			}
			
			int m=0;
			int n=0;		
			sb = new StringBuffer();
			while(m<curr.length() && n<pre.length()){
				if(curr.charAt(m) == pre.charAt(n)){
					sb.append(curr.charAt(m));
					m++;
					n++;
				}else{
					break;
				}
				
			}
			
			if(sb.length()==0){
				return "";
			}
			pre = sb.toString();
			
			
		}
		return sb.toString();
		
	}
	
	

	public static void main(String[] args) {


		LongestCommonPrefix lcp = new LongestCommonPrefix();	
		
		Assert.assertEquals("", lcp.longestCommonPrefix(new String[]{"a","ab", "x"}));
		Assert.assertEquals("a", lcp.longestCommonPrefix(new String[]{"a","ab", "a"}));
		Assert.assertEquals("s", lcp.longestCommonPrefix(new String[]{"steffi","stany", "steve", "sally"}));
		Assert.assertEquals("", lcp.longestCommonPrefix(new String[]{"a","steffi","ling","mona"}));	
		Assert.assertEquals("sf", lcp.longestCommonPrefix(new String[]{"sf"}));
		
		System.out.println("Test Successful");
		
	}

}
