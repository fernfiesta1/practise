package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis2 {

	public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        //backtrack(ans, "", 0, 0, n);
        backtrack(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
    
    public void backtrack(List<String> ans, StringBuffer cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(new String(cur.toString()));
            return;
        }

        if (open < max){
        	cur.append('(');
        	open = open +1;
            backtrack(ans, new StringBuffer(cur), open, close, max);
            cur.deleteCharAt(cur.length()-1);
            open = open -1;
        }
        if (close < open){
        	cur.append(')');
        	close = close +1;
            backtrack(ans, new StringBuffer(cur), open, close, max);
            cur.deleteCharAt(cur.length()-1);
            close = close -1;
        }
    }
    
	
	public static void main(String[] args) {
		Parenthesis2 p2 = new Parenthesis2();
		System.out.println(p2.generateParenthesis(3));

	}

}
