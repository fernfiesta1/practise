package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class RootToLeafSum {

	public int sumNumbers(TreeNode root) {

		if(root == null){
			return 0;
		}

		/*
		 * List<String> result = new ArrayList<String>(); helper3(root, new
		 * StringBuffer(), result);
		 */

		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		helper1(root, temp, res);
		//helper3(root, temp, res)

		
		int sum =0;
		for(int i=0; i<res.size(); i++){
			System.out.println(res.get(i));
			//sum = sum + Integer.parseInt(res.get(i));
		}
		
		System.out.println(sum);
		return sum;
	}

	public void helper(TreeNode root, StringBuffer num, List<String> paths){

		if(root == null){
			return;
		}

		num.append(root.val);
		if(root.left == null && root.right == null){
			paths.add(num.toString());
		}

		helper(root.left, new StringBuffer(num), paths);
		helper(root.right, new StringBuffer(num), paths);

	}

	public void helper1(TreeNode root, List<Integer> temp, List<List<Integer>> result){
		if(root == null){
			return;
		}

		temp.add(root.val);
		if(root.left == null && root.right == null){
			result.add(new ArrayList<>(temp));
		}		

		helper1(root.left, temp, result);		
		helper1(root.right, temp, result);
		temp.remove(temp.size()-1);
		//temp.remove(temp.size()-1);

	}

	private void helper3(TreeNode root, StringBuffer temp, List<String> result){

		if(root == null){
			if(!temp.toString().isEmpty()){
				result.add(temp.toString());
			}
			return; 
		}   


		temp.append(root.val);        
		helper(root.left, new StringBuffer(temp), result);
		helper(root.right, new StringBuffer(temp), result);

	}


	/*
	 * public int sumNumbers(TreeNode root) {
	return sum(root, 0);
}

public int sum(TreeNode n, int s){
	if (n == null) return 0;
	if (n.right == null && n.left == null) return s*10 + n.val;
	return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
}
	 */
	public static void main(String[] args) {

		TreeNode root  = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		/*root.left.left = new TreeNode(11);
		root.left.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
*/
		RootToLeafSum r = new RootToLeafSum();
		r.sumNumbers(root);
	}

}
