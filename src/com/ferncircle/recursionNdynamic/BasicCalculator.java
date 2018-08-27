package com.ferncircle.recursionNdynamic;

/**
 * 
 * This implementation only works if the input digits are between 0-9.
 * For a better or correct approach please refer BasicCalculor2
 * @author dbrit00s
 *
 */
public class BasicCalculator {

	public int calculate(String s) {

		if(s.length() == 1){
			return Integer.parseInt(s);
		}
		
		//Remove whitespaces
		String s1 = s.replace(" ", "");
		
		String res1 = helperMultDivide(s1, 1);
		if(res1.length() == 1){
			return Integer.parseInt(res1);
		}
		
		String res2 = helperAddSub(res1, 1);
		return Integer.parseInt(res2);
	}
	
	public String helperMultDivide(String expre, int index){
		if(expre.length() == 1){
			return expre;
		}
		
		if(index >= expre.length()){
			return expre;
		}
		
		if(expre.charAt(index) == '*' || expre.charAt(index)== '/'){
			int result = 0;
			
			if(expre.charAt(index) == '*'){
				result = Integer.parseInt(String.valueOf(expre.charAt(index-1))) *  Integer.parseInt(String.valueOf(expre.charAt(index+1)));
			}else{
				result = Integer.parseInt(String.valueOf(expre.charAt(index-1))) /  Integer.parseInt(String.valueOf(expre.charAt(index+1)));
			}
			
			String ex = null;
			if(index>1){
				ex =  expre.substring(0, index-1) + String.valueOf(result) + expre.substring(index+2);
			}else{
				ex =  String.valueOf(result) + expre.substring(index+2);
				
			}
			return helperMultDivide(ex, index);
		}else{
			return helperMultDivide(expre, index+2);
		}
	}

	public String helperAddSub(String expre, int index){
		if(expre.length() == 1){
			return expre;
		}
		
		if(index > expre.length()){
			return expre;
		}
		
		int result = 0;
		if(expre.charAt(index) == '+'){
			result = Integer.parseInt(String.valueOf(expre.charAt(index-1))) +  Integer.parseInt(String.valueOf(expre.charAt(index+1)));
		}else{
			result = Integer.parseInt(String.valueOf(expre.charAt(index-1))) -  Integer.parseInt(String.valueOf(expre.charAt(index+1)));
		}
		String ex = String.valueOf(result) + expre.substring(index+2);
		return helperAddSub(ex, index);
	}
	
	public static void main(String[] args) {
		
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate("3 + 2*2"));

	}

}
