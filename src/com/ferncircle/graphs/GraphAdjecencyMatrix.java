package com.ferncircle.graphs;

import java.util.Arrays;

public class GraphAdjecencyMatrix {
	
	int vertex;
	int[][] edges;
	
	public GraphAdjecencyMatrix(int v){
		vertex = v;
		edges = new int[vertex][vertex];
		
	}
	
	public void addEdge(int vStart, int vEnd){
		
		edges[vStart][vEnd] = 1;
		edges[vEnd][vStart] =1;
		
	}
	
	public void printEdges(int vertex){
		for(int i=0; i< edges.length; i++){
			if(edges[vertex][i] != 0){
				System.out.println(i + ",");
				
			}
		}
	}
	
	public static void main(String[] args){
		
		int noOfVertexes = 5;
		GraphAdjecencyMatrix g = new GraphAdjecencyMatrix(noOfVertexes);
		g.addEdge(0, 4);
		g.addEdge(0, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		System.out.println(Arrays.deepToString(g.edges));
		
		for(int i=0; i< noOfVertexes; i++){
			System.out.println("Edges starting at vertex : " + i);
			g.printEdges(i);
		}
		
		
	}

}
