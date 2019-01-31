package com.ferncircle.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 * @author dbrit00s
 *
 */
public class MeetingRooms {


	public int minMeetingRooms(Interval[] intervals) {

		if(intervals.length == 0){
			return 0;
		}

		//Sort the intervals by their start dates
		Arrays.sort(intervals, (i1, i2) -> 
		i1.start - i2.start
				);        


		//Create Priority Queue to find meeting that will get over soonest
		//PriorityQueue<Integer> minHeap = new PriorityQueue(intervals.length, (a,b) -> a-b);
		Queue<Interval> minHeap = new PriorityQueue(intervals.length,  new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});

		minHeap.add(intervals[0]);
		
		for(int i=1; i< intervals.length; i++) {
			
			//If there is a meeting that ends before this one starts, remove it and add the new 
			//Meeting
			if(minHeap.peek().end <= intervals[i].start) {
				minHeap.poll();
			}
			
			minHeap.add(intervals[i]);
		}
		
		return minHeap.size();
	}



	public static void main(String[] args) {

		MeetingRooms mr = new MeetingRooms();

		Interval i1 = mr.new Interval(0, 30);
		Interval i2 = mr.new Interval(31, 40);
		Interval i3 = mr.new Interval(31,40);
		

		Interval[] intArr = new Interval[]{i1,i2,i3};
		System.out.println(mr.minMeetingRooms(intArr));

	}

	/*
	 * public class IntervalComparator implements Comparator<Interval>{
	 * 
	 * @Override public int compare(Interval i1, Interval i2) { if(i1.start ==
	 * i2.start){ return 0; }
	 * 
	 * if(i1.start < i2.start){ return -1; }
	 * 
	 * if(i1.start > i2.start){ return 1; } return 0; }
	 * 
	 * 
	 * }
	 */

	public class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}

}
