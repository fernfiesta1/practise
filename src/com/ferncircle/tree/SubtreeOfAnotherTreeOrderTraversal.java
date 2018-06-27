package com.ferncircle.tree;

public class SubtreeOfAnotherTreeOrderTraversal {
	
	public boolean isSubtree(TreeNode s, TreeNode t){
		
		if(s == null && t == null){
			return false;
		}
		
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		StringBuffer s3 = new StringBuffer();
		StringBuffer s4 = new StringBuffer();
		
		String inOrderOfs = getInorderTraversal(s, s1);
		String inOrderOft = getInorderTraversal(t, s2);
		String preOrderOfs = getPreorderTraversal(s, s3);
		String preOrderOft = getPreorderTraversal(t, s4);
		
		if(inOrderOfs.contains(inOrderOft) && preOrderOfs.contains(preOrderOft)){
			return true;
		}
		return false;
	}
	
	private String getInorderTraversal(TreeNode s, StringBuffer sb){
		
		if(s == null){
			return null;
		}
		
		getInorderTraversal(s.left, sb);
		sb.append(s.val);
		getInorderTraversal(s.right, sb);
		return sb.toString();
		
	}
	
	private  String getPreorderTraversal(TreeNode t, StringBuffer sb){
		
		if(t== null){
			return null;
		}
		
		sb.append(t.val);		
		getPreorderTraversal(t.left, sb);
		getPreorderTraversal(t.right, sb);
		
		return sb.toString();
	}
	
	


	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(4);
		bst.insert(2);
		bst.insert(8);
		bst.insert(1);
		bst.insert(3);
		
		
		SubtreeOfAnotherTreeOrderTraversal s = new SubtreeOfAnotherTreeOrderTraversal();
		StringBuffer sb = new StringBuffer();
		System.out.println("InOrder traversal : " + s.getInorderTraversal(bst.root, sb));
		
		StringBuffer sb2 = new StringBuffer();
		System.out.println("pre order traversal : " + s.getPreorderTraversal(bst.root, sb2));
		
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(2);
		bst1.insert(1);
		
		
		StringBuffer sb1 = new StringBuffer();
		System.out.println("InOrder traversal : " + s.getInorderTraversal(bst1.root, sb1));
		
		StringBuffer sb4 = new StringBuffer();
		System.out.println("pre order traversal : " + s.getPreorderTraversal(bst1.root, sb4));
		
		System.out.println(s.isSubtree(bst.root, bst1.root));

	}

}
