package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {
	
	 public boolean findTarget(TreeNode root, int k) {
	        
	        List<Integer> elements = new ArrayList<Integer>();
	        getInOrder(root, elements);
	        
	        int start = 0;
	        int end = elements.size() -1;
	        while(start < end){
	            int sum = elements.get(start) + elements.get(end);
	            if(sum == 0){
	                return true;
	            }
	            if(sum < k){
	                start++;
	            }else{
	                end--;
	            }
	        }
	        return false;
	        
	    }
	    
	    private void getInOrder(TreeNode root, List<Integer> result){
	        
	        if(root == null){
	            return;            
	        }
	        
	        getInOrder(root.left, result);
	        result.add(root.val);
	        getInOrder(root.right, result);
	    }

	    public static void main(String[] args) {
	    	
	    	TreeNode root  = new TreeNode(5);
			root.left = new TreeNode(3);
			root.right = new TreeNode(6);
			root.left.left = new TreeNode(2);
			root.left.right = new TreeNode(4);
			root.right.right = new TreeNode(7);
			/*root.right.left = new TreeNode(13);
			root.right.right = new TreeNode(4);
			root.right.right.left = new TreeNode(5);
			root.right.right.right = new TreeNode(1); */
			
			TwoSumBST ts = new TwoSumBST();
			ts.findTarget(root, 9);
	    }
}
