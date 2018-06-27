package com.ferncircle.graphs;

import java.util.LinkedList;

public class BreadthFirstTraversal {
	
	public void bfs(GraphAdjecencyList g, int vertex){
		
		Boolean[] visited = new Boolean[g.vertex];
		for(int i=0; i< visited.length; i++){
			visited[i] = false;
		}
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(vertex);
		visited[vertex] = true;
		System.out.println(vertex);
		
		Integer currentVertex;
		while(!ll.isEmpty()){
			currentVertex = findNxtNonVisitedVertex(ll.peek(), g, visited);
			
			if(currentVertex == null){
				ll.remove();
			}else{
				ll.add(currentVertex);
				visited[currentVertex] = true;
				System.out.println(currentVertex);
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
		
		BreadthFirstTraversal bfs = new BreadthFirstTraversal();
		bfs.bfs(g, 0);

	}

}
