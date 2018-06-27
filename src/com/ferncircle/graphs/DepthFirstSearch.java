package com.ferncircle.graphs;

import java.util.Stack;

public class DepthFirstSearch {

	public void dfs(GraphAdjecencyList g, int startVertex){

		Boolean[] visited = new Boolean[g.vertex];
		for(int i=0; i< visited.length; i++){
			visited[i] = false;
		}
		Stack<Integer> s = new Stack<Integer>();

		visited[startVertex] = true;
		s.push(startVertex);
		System.out.println(startVertex);
	
		Integer currentVertex;
		while(!s.isEmpty()){
			currentVertex = findNxtNonVisitedVertex(s.peek(), g, visited);
			if(currentVertex != null){
				visited[currentVertex] = true;			
				System.out.println(currentVertex);
				s.push(currentVertex);
			}else{
				s.pop();		

			}
		}

	}

	private Integer findNxtNonVisitedVertex(int vertex, GraphAdjecencyList g, Boolean[] visited){


		while(!g.edges[vertex].isEmpty()){
			int next =  (Integer) g.edges[vertex].remove();
			if(!visited[next]){
				return next;
			}
		}

		return null;

	}


	public static void main(String[] args) {
		int noOfVertexes = 6;
		GraphAdjecencyList g = new GraphAdjecencyList(noOfVertexes);


		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);

		DepthFirstSearch d  = new DepthFirstSearch();
		d.dfs(g, 0);

	}

}
