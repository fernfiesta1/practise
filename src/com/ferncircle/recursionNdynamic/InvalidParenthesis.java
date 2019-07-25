package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InvalidParenthesis {
	
	public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        
        int[] count = getInvalidCount(s);
        StringBuffer sb = new StringBuffer();
        List<String> result = new ArrayList<>();
        helper(s,0,count[0], count[1], count[2], count[3], sb, result);
        
        return result;
        
    }
    
    private void helper(String s, int i, int lcount, int rcount, int lRem, int rRem, 
                        StringBuffer sb, List<String> result){
        
        if(i == s.length() -1){
            if(validate(sb.toString())){
                result.add(sb.toString());
            }
            return;
        }
        
        if(Character.isAlphabetic(s.charAt(i))){
            sb.append(s.charAt(i));
            helper(s, i++, lcount, rcount, lRem, rRem, sb, result);
        }else        
       if((s.charAt(i) == '(' && lRem > 0) || (s.charAt(i) == ')' && rRem > 0)){
           helper(s, i++, lcount, rcount, 
                s.chatAt(i) == '('? lRem-1:lRem,
                 s.chatAt(i) == ')'? rRem-1:rRem, 
                		 sb, result);
       }else if(s.charAt(i) == '(' && lcount >0){
           sb.append(s.charAt(i));
           helper(s, i++, lcount-1, rcount, lRem, rRem, sb, result);
       }else{
           sb.append(s.charAt(i));
           helper(s, i++, lcount, rcount-1, lRem, rRem, sb, result);
       } 
          
        //backtrack
          sb.deleteCharAt(sb.length()-1);
          
    }
    
    private boolean validate(String s){
    	
    	Stack<String> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(")");
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;   
                }else{
                    stack.pop();
                }
            }          
            
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    
    private int[] getInvalidCount(String s){
        
        Stack<String> stack = new Stack<>();
        int invOpen =0;
        int invClose =0;
        int open=0;
        int close=0;
        
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push("(");
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    invClose++;   
                }else{
                    stack.pop();
                    open++;
                    close++;
                }
            }
        }
        
        invOpen = stack.size();
        
        int[] result = new int[4];
        result[0] = open;
        result[1] = close;
        result[2] = invOpen;
        result[3] = invClose;
        
        return result;
        
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
