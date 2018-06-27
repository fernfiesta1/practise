package com.ferncircle.string;

public class ReplaceCharacter {
	
	public String solution(String in){
		char[] inArr = in.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		for(char c: inArr){
			if(c == ' '){
				sb.append("%20");
			}else{
				sb.append(c);
			}
				
		}
		
		return sb.toString();
 	}

	public static void main(String[] args) {
		ReplaceCharacter rc = new ReplaceCharacter();
		String out = rc.solution("This is my       String");
		System.out.println(out);

	}

}
