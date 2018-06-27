package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> levelList = new ArrayList<List<Integer>>();
		if(root == null){
			return levelList;
		}		


		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);


		while(!queue.isEmpty()){		

			int levelSize = queue.size();

			List<Integer> list = new ArrayList<Integer>();
			while(levelSize > 0){
				TreeNode current = queue.remove();
				list.add(current.val);

				if(current.left != null){
					queue.add(current.left);					
				}

				if(current.right != null){
					queue.add(current.right);
				}

				levelSize--;				
			}
			levelList.add(list);
		}	

		return levelList;

	}

	public List<Double> averageOfLevels(TreeNode root) {

		//List<List<Integer>> levelOrder = levelOrder(root);
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
		
		
		List<Integer> i0 = new ArrayList<Integer>();
		i0.add(3);
		
		List<Integer> i1= new ArrayList<Integer>();
		i1.add(9);
		i1.add(20);
		
		
		List<Integer> i2 = new ArrayList<Integer>();
		i2.add(15);
		i2.add(7);
		
		levelOrder.add(i0);
		levelOrder.add(i1);
		levelOrder.add(i2);
		
		List<Double> averageList = new ArrayList<Double>();

		for(int i=0; i< levelOrder.size(); i++){
			double sum = 0;
			List<Integer> levelNodes = levelOrder.get(i);
			for(Integer val: levelNodes){
				sum = sum + val;
			}
			double average = sum/levelNodes.size();
			averageList.add(i, average);			
		}

		return averageList;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args){
		AverageOfLevels l = new AverageOfLevels();
		List<Double> result = l.averageOfLevels(null);
	}

}
