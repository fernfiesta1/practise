package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintLeaves {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result);
        return result;
        
    }
    
    private int helper(TreeNode root, List<List<Integer>> result){
        if(root == null){
            return -1;
        }
        
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        
        int current = Math.max(left, right) + 1;
        
        
        //Important snippet.
        if(result.size() < current +1){
            List<Integer> l = new ArrayList<>();
            result.add(l);
        }
        
        result.get(current).add(root.val);
        
        return current;
        
    }
    
    public static void main(String[] args) {
    	TreeNode root  = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(11);
		root.left.right = new TreeNode(5);
		
		PrintLeaves pl = new PrintLeaves();
		System.out.println(pl.findLeaves(root));
    }

}
