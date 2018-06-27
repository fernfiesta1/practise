package com.ferncircle.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedulell {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] result = new int[numCourses];
		int[] weights = new int[numCourses];
		
		Map<Integer, List<Integer>> graph = createGraph(prerequisites, numCourses, weights);
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i< weights.length; i++){
			if(weights[i] == 0){
				q.add(i);
			}
		}
		
		int k=0;
		while(!q.isEmpty()){
			int current = q.poll();
			result[k] = current;
			
			for(int i=0; i< graph.get(current).size(); i++){
				weights[graph.get(current).get(i)]--;
				if(weights[graph.get(current).get(i)] <= 0){
					q.add(graph.get(current).get(i));
				}
			}
			k++;
		}
		
		for(int i: weights){
			if(i>0){
				return new int[0];
			}
		}
		
		return result;
	}
	
	private Map<Integer, List<Integer>> createGraph(int[][] edges, int vertexes, int[] weights){
		
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<vertexes; i++){
			graph.put(i, new ArrayList<Integer>());
		}
		
		for(int j=0; j<edges.length; j++){
			int prereq = edges[j][1];
			int course = edges[j][0];
			
			graph.get(prereq).add(course);
			weights[course]++;
		}
		return graph;
	}

	public static void main(String[] args) {
		int vertex = 2;
		int[][] edges = new int[1][2];

		edges[0][0] = 1;
		edges[0][1] = 0;
		
		
		CourseSchedulell sc = new CourseSchedulell();
		for(int i: sc.findOrder(vertex, edges)){
			System.out.println(i);
		}
		

	}

}
