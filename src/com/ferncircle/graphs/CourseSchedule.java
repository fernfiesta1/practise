package com.ferncircle.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author dbrit00s
 *
 *There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

 */
public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] weight = new int[numCourses];
		Map<Integer, List<Integer>> graph = createGraph(prerequisites, weight, numCourses);

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i< weight.length;i++){
			if(weight[i] == 0){
				q.add(i);
			}
		}

		while(!q.isEmpty()){
			int current = q.poll();
			for(int i=0; i< graph.get(current).size(); i++){				
				weight[graph.get(current).get(i)]--;
				if(weight[graph.get(current).get(i)] <= 0){
					q.add(graph.get(current).get(i));
				}
			}

		}

		for(int i=0; i< weight.length;i++){
			if(weight[i] > 0){
				return false;
			}
		}
		return true;
	}

	private Map<Integer, List<Integer>> createGraph(int[][] edges, int[] weight, int numCources){

		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for(int i=0; i< numCources; i++){
			graph.put(i, new ArrayList<Integer>());
		}

		for(int i=0; i< edges.length; i++){
			int course = edges[i][0];
			int dependency = edges[i][1];
			graph.get(dependency).add(course);
			weight[course]++;

		}
		return graph;
	}

	public static void main(String[] args){

		int vertex = 2;
		int[][] edges = new int[1][2];

		edges[0][0] = 0;
		edges[0][1] = 1;
		
		
		CourseSchedule sc = new CourseSchedule();
		System.out.println(sc.canFinish(vertex, edges));

	}


}
