package com.ferncircle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalLevelOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> bucketQueue = new LinkedList<>();
		Map<Integer, List<Integer>> bucketMap = new TreeMap<>();
		
		queue.add(root);
		bucketQueue.add(0);
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			Integer bucket = bucketQueue.poll();
			
			if(!bucketMap.containsKey(bucket)){
				List<Integer> values = new ArrayList<>();
				values.add(current.val);
				bucketMap.put(bucket, values);
			}else{
				bucketMap.get(bucket).add(current.val);
			}
			
			if(current.left != null){
				queue.add(current.left);
				bucketQueue.add(bucket -1);
			}
			
			if(current.right != null){
				queue.add(current.right);
				bucketQueue.add(bucket + 1);
			}
		}
		
		bucketMap.values().forEach(v -> res.add(v));
		
		return res;
	}
	
	public static void main(String[] args) {


	}

}
