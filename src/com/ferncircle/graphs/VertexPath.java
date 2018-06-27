package com.ferncircle.graphs;

import java.util.Iterator;
import java.util.Stack;

public class VertexPath {
	
	public boolean pathExists(int a, int b, GraphAdjecencyList g){
		
		Boolean[] visited = new Boolean[g.vertex];
		for(int i=0; i< g.vertex; i++){
			visited[i] = false;
		}
		Stack<Integer> s = new Stack<Integer>();
		s.push(a);
		
		while(!s.isEmpty()){
			Integer next = getNextUnvisitedVertex(s.peek(), g, visited);
			
			if(next == null){
				s.pop();
			}else{
				s.push(next);
				if(next == b){
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	private Integer getNextUnvisitedVertex(int from, GraphAdjecencyList g, Boolean[] visited){
		
		Iterator<Integer> i = g.edges[from].iterator();
		while(i.hasNext()){
			int next = (Integer) i.next();
			
			if(!visited[next]){
				visited[next] = true;
				return next;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		
		GraphAdjecencyList g = new GraphAdjecencyList(5);
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		
		VertexPath p = new VertexPath();
		System.out.println("Does the path exist between 0 and 4: " + p.pathExists(0, 4, g));
		System.out.println("Does the path exist between 2 and 1: " + p.pathExists(2, 1, g));
		System.out.println("Does the path exist between 3 and 0: " + p.pathExists(3, 0, g));

	}
	

}
