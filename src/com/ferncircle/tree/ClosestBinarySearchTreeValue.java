package com.ferncircle.tree;

/**
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

 * @author dbrit00s
 *
 */
public class ClosestBinarySearchTreeValue {

	
	public int closestValue(TreeNode root, double target) {		
		int ret = root.val;   
	    while(root != null){
	        if(Math.abs(target - root.val) < Math.abs(target - ret)){
	            ret = root.val;
	        }      
	        root = root.val > target? root.left: root.right;
	    }     
	    return ret;
		
	}
	
	 public int result=0;
	    public double minDiff = Double.MAX_VALUE;
	    
	    public int closestValue1(TreeNode root, double target) {
	        
	        if(root == null){
	            return 0;
	        }
	        
	        double currDiff = Math.abs(root.val - target);
	        if(minDiff > currDiff){
	            minDiff = currDiff;
	            result = root.val;
	        }
	        
	        if(root.val > target){
	            closestValue(root.left, target);
	        }else{
	            closestValue(root.right, target);
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(4);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(5);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(3);
		
		ClosestBinarySearchTreeValue test = new ClosestBinarySearchTreeValue();
		System.out.println(test.closestValue(tn, 3.1));

	}

}
