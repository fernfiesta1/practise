package com.ferncircle.graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphAdjecencyList {

	int vertex;
	LinkedList[] edges;

	public GraphAdjecencyList(int v){
		vertex = v;
		edges = new LinkedList[vertex];
		for(int i=0; i< v; i++){
			edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int startVertex, int endVertex){

		edges[startVertex].add(endVertex);		
	}
	
	public void printEdges(int vertex){
		while(!edges[vertex].isEmpty()){
			System.out.println(edges[vertex].remove());
		}
	}

	public static void main(String[] args){

		int noOfVertexes = 5;
		GraphAdjecencyList g = new GraphAdjecencyList(noOfVertexes);
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
