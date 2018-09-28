package com.ferncircle.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 * @author dbrit00s
 *
 */
public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {

		//Create a Adjecency list from the input
		List<List<Integer>> graph = getAdjecencyList(n, edges);		

		boolean[] visited = new boolean[n]; 
		//Check if there is a cycle in the graph
		if(isCyclic(0, graph, -1, visited)){
			return false;
		}

		//Check if there are any unvisited vertexes in the graph
		for(boolean v: visited){
			if(v == false){
				return false;
			}
		}

		return true;
	}

	private boolean isCyclic(int start, List<List<Integer>> graph, int parent, boolean[] visited){


		if(visited[start] == true){
			return true;
		}

		visited[start] = true;
		List<Integer> list = graph.get(start);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			int next = (int)iterator.next();
			if(next == parent){
				continue;
			}
			if(isCyclic(next, graph, start, visited)){
				return true;
			}
			
		}
		return false;
	}

	private List<List<Integer>> getAdjecencyList(int vertexes, int[][] edges){

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i< vertexes; i++){
			List<Integer> list = new ArrayList<>();
			graph.add(list);
		}
		
		for(int i=0; i< edges.length; i++){
			int from = edges[i][0];
			int to = edges[i][1];
			graph.get(from).add(to);
			graph.get(to).add(from);
			
		}
		return graph;
	}


	public static void main(String[] args) {

		int[][] edges = new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}};


		GraphValidTree gft = new GraphValidTree();
		System.out.println(gft.validTree(5, edges));
	}



}
