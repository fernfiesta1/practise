package com.ferncircle.string;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class ZigZag {

	public String convert(String s, int numRows) {

		int start = 0;
		int end = numRows -1;
		Map<Integer, StringBuffer> result = new HashMap<Integer, StringBuffer>();

		for(int i=0; i<numRows; i++){
			StringBuffer sb = new StringBuffer();
			result.put(i, sb);
		}
		for(int i=0; i<s.length(); i++){

			if(numRows == 1){
				return s;				
			}
			if(start != end){
				result.get(start).append(s.charAt(i));
			}else if (start == end && end != 0){
				result.get(start).append(s.charAt(i));
				start = start -1;
				end = 0;
				continue;
			}else if(start == end && end == 0){
				result.get(start).append(s.charAt(i));
				start = start +1;
				end = numRows -1;
				continue;
			}
			
			if(start < end){
				start ++;
			}else if (start > end){
				start --;
			}

		}
		
		StringBuffer r = new StringBuffer();
		
		for(int i=0; i<numRows; i++){
			r.append(result.get(i));
		}		
		return r.toString();

	}

	public static void main(String[] args){

		ZigZag z= new ZigZag();
		Assert.assertEquals("PAHNAPLSIIGYIR", z.convert("PAYPALISHIRING", 3));		
		Assert.assertEquals("AB", z.convert("AB", 1));
		
		System.out.println("Test successful");
				
	}

}
