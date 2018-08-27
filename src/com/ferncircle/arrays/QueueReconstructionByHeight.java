package com.ferncircle.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

	
	public int[][] reconstructQueue(int[][] people) {
	    Arrays.sort(people, (p1, p2) -> p2[0] == p1[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
	    List<int[]> result = new LinkedList<>();
	    Arrays.stream(people).forEach(p -> result.add(p[1], p));
	    return result.toArray(people);
	}
	
	
	
	
	public static void main(String[] args) {
		QueueReconstructionByHeight qe = new QueueReconstructionByHeight();
		
		int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		qe.reconstructQueue(people);

	}

}
