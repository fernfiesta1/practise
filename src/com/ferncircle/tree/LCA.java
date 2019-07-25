package com.ferncircle.tree;

public class LCA {
	
	public TreeNode lca(TreeNode p, TreeNode q, TreeNode root) {
		
		if(root == null) {
			return null;
		}
		
		if(root.val == p.val || root.val == q.val) {
			return root;
		}
		
		TreeNode l = lca(p, q, root.left);
		TreeNode r = lca(p, q, root.right);
		
		if(l != null && r != null) {
			return root;
		}
		
		if(l != null) {
			return l;
		}
		
		if(r != null) {
			return r;
		}
		
		return null;
		
		
	}

	public static void main(String[] args) {

		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(4);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(6);
		tn.right.left = new TreeNode(7);
		tn.right.right = new TreeNode(8);
		
		LCA lca = new LCA();
		System.out.println(lca.lca(new TreeNode(3), new TreeNode(9), tn).val);

	}

}
