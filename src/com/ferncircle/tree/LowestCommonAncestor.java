package com.ferncircle.tree;


/**
 * @author dbrit00s
 * 
 * Time Complexity: O(n^2)
 *  to check if p exists --> O(n)
 *  to check if q exists --> O(n)
 *Checking complexity = O(2n) = O(n)
 *
 *to determine the ancestor O(n)
 *
 *Total = O(n^2)
 */
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root== null){
			return null;
		}
		
		if(root == p || root == q){
			return root;
		}
		
		Boolean pLeft = checkExists(root.left, p);
		Boolean qLeft = checkExists(root.left, q);
		
		if(pLeft != qLeft){
			return root;
		}
		
		TreeNode childSide = (pLeft == true? root.left : root.right);
		return lowestCommonAncestor(childSide, p, q);		
		
	}
	
	private Boolean checkExists(TreeNode root, TreeNode p){
		
		if(root == null){
			return false;
		}
		
		if(root == p){
			return true;
		}	
		
		return checkExists(root.left, p) || checkExists(root.right, p);
	}
	
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
		if(root == null){
			return null;
		}
		
		if(root.val > p.val && root.val > q.val){
			return lowestCommonAncestor1(root.left, p, q);
		}
		
		if(root.val < p.val && root.val < q.val){
			return lowestCommonAncestor1(root.right, p, q);
		}
		
		return root;
	}

	public static void main(String[] args) {
		

	}

}
