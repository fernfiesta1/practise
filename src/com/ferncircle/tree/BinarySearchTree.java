package com.ferncircle.tree;

public class BinarySearchTree {
	
	public TreeNode root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void insert(int data){
		
		TreeNode n = new TreeNode(data);
		if(root == null){
			n.parent = null;
			root = n;
			
		}else{
			TreeNode current = root;
			TreeNode parent = null;
			
			while(current!=null){
				parent = current;
				if(current.val < data){
					current = current.right;				
				}else if(current.val >= data){
					current = current.left;
				}
			}
			n.parent = parent;
			if(parent.val < data){
				parent.right = n;
			}else{
				parent.left = n;
			}			
		}
	}
	
	public boolean find(int data){
		
		if(root == null){
			return false;
		}
		
		if(root.val == data){
			return true;
		}
		
		TreeNode current = root;
		while(current != null){
			if(current.val < data){
				current = current.right;
			}else if(current.val > data){
				current = current.left;
			}else{
				return true;
			}
		}		
		
		return false;
	}
	
	public boolean find(TreeNode root, int data){
		if(root == null){
			return false;
		}
		if(root.val == data){
			return true;
		}
		
		if(root.val < data){
			find(root.right, data);
		}else{
			find(root.left, data);
		}
		
		return false;
	}
	
	public ParentChild findNGetParent(TreeNode root, int data){
		
		ParentChild pc = new ParentChild();
		if(root == null){
			return pc;
		}
		
		TreeNode child = root;
		TreeNode parent = null;
		
		while(child != null){
			
			if(child.val == data){
				pc.child = child;
				pc.parent = parent;
				break;
			}
			
			parent = child;
			if(child.val < data){
				child = child.right;
			}else{
				child = child.left;
			}
		}
		
		return pc;
	}
	
	public void delete(int data){
		
		ParentChild pc = findNGetParent(root, data);
		if(pc.child == null && pc.parent == null){
			return;
		}
				
		if(pc.child.left == null && pc.child.right == null){
			deleteWithNoChild(pc.parent, pc.child);
		}else if((pc.child.left != null && pc.child.right == null) || (pc.child.left == null && pc.child.right!=null)){
			deleteWithOneChile(pc.parent, pc.child);
		}else{
			deleteWithTwoChildren(pc.parent, pc.child);
		}		
		
	}
	
	private void deleteWithNoChild(TreeNode parent, TreeNode toBeDeleted){
		
		if(parent == null){
			root = null;
			return;
		}
		if(parent.left.val == toBeDeleted.val){
			parent.left =null;
		}else{
			parent.right = null;
		}
	}
	
	private void deleteWithOneChile(TreeNode parent, TreeNode toBeDeleted){
		
		if(parent == null){
			root = toBeDeleted.left != null ? toBeDeleted.left : toBeDeleted.right;
			return;
		}
		
		if(parent.left.val == toBeDeleted.val){
			parent.left = parent.left.left != null? parent.left.left : parent.left.right;
		}else{
			parent.right = parent.right.left != null? parent.right.left : parent.right.right;
		}
	}
	
	private void deleteWithTwoChildren(TreeNode parent, TreeNode toBeDeleted){
		
		TreeNode smallest = getSmallest(toBeDeleted.right);
		
		toBeDeleted.val = smallest.val;		
		ParentChild pc = findNGetParent(toBeDeleted.right, smallest.val);		
		deleteWithNoChild(pc.parent, pc.child);		
		
	}
	
	private TreeNode getSmallest(TreeNode start){
		TreeNode parent = null;
		while(start != null){
			parent = start;
			start = start.left;			
		}
		return parent;
	}	
	
	public void displayInOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		displayInOrder(root.left);
		Integer parent = (root.parent == null? null: root.parent.val);
		System.out.print(root.val + "(parent = " + parent + "),");
		displayInOrder(root.right);
	}
	
	public void displayPreOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		Integer parent = (root.parent == null? null: root.parent.val);
		System.out.print(root.val + "(parent = " + parent + "),");
		displayPreOrder(root.left);
		displayPreOrder(root.right);
		
	}
	
	public void displayPostOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		displayPostOrder(root.left);
		displayPostOrder(root.right);
		Integer parent = (root.parent == null? null: root.parent.val);
		System.out.print(root.val + "(parent = " +parent + "),");
	}
	
	public static void main(String[] args){
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(35);
		bst.insert(4);
		bst.insert(15);
		bst.insert(60);
		bst.insert(1);
		bst.insert(5);
		bst.insert(40);
		bst.insert(65);
		
		System.out.println("Inorder : ");
		bst.displayInOrder(bst.root);
		System.out.println(System.lineSeparator());
		System.out.println("Pre order :");
		bst.displayPreOrder(bst.root);
		System.out.println(System.lineSeparator());
		System.out.println("Post order: ");
		bst.displayPostOrder(bst.root);
		
		System.out.println(System.lineSeparator());
		System.out.println("root if the tree is : " + bst.root.val);
		
		System.out.println("89 exists ? " + bst.find(89));
		System.out.println("89 exists ? " + bst.find(bst.root, 89));
		
		System.out.println("10 exists ? " + bst.find(10));
		System.out.println("10 exists ? " + bst.find(bst.root, 10));
		
		bst.delete(1);
		System.out.println("After deleting 1:");
		bst.displayInOrder(bst.root);
		bst.insert(1);
		
		bst.delete(4);
		System.out.println("After deleting 4:");
		bst.displayInOrder(bst.root);
		bst.insert(4);
		
		bst.delete(35);
		System.out.println("After deleting 35: ");
		bst.displayInOrder(bst.root);
		bst.insert(35);
		
		bst.delete(10);
		System.out.println("After deleting 10:");
		bst.displayInOrder(bst.root);	
		System.out.println(System.lineSeparator());
		
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(5);
		bst1.insert(9);
		bst1.insert(10);
		bst1.insert(8);
		bst1.displayInOrder(bst1.root);
		bst1.delete(5);
		System.out.println("After delete");
		bst.displayInOrder(bst1.root);
		
	}	

	public class ParentChild{
		
		TreeNode child;
		TreeNode parent;
		
		public ParentChild() {
			child = null;
			parent = null;
		}
	}
}


