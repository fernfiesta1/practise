package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

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
		
		if(intervals.length == 1){
			return 1;
		}
		
		//Sort the intervals by the start of the meeting
		Arrays.sort(intervals, new IntervalComparator());
		List<Stack<Interval>> result = new ArrayList<>();		
		
		//for each interval get the room which is available.
		//schedule that meeting in the room that is being returned.
		//USing a stack here because we want to know what is the end time of the previous meeting
		for(Interval i : intervals){
			int index = getRoomIndex(result, i);
			if(index == -1){
				Stack<Interval> stack = new Stack<>();
				stack.add(i);
				result.add(stack);
			}else{
				result.get(index).add(i);
			}			
		}
		
		return result.size();
	}
	
	private int getRoomIndex(List<Stack<Interval>> rooms, Interval interval){
		for(int i=0; i< rooms.size(); i++){
			if(rooms.get(i).peek().end <= interval.start){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		MeetingRooms mr = new MeetingRooms();
		
		Interval i1 = mr.new Interval(0, 30);
		Interval i2 = mr.new Interval(5, 40);
		Interval i3 = mr.new Interval(5,15);
		Interval i4 = mr.new Interval(15, 20);
		
		Interval[] intArr = new Interval[]{i1,i2,i3, i4};
		System.out.println(mr.minMeetingRooms(intArr));

	}
	
	public class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval i1, Interval i2) {
			if(i1.start == i2.start){
				return 0;
			}
			
			if(i1.start < i2.start){
				return -1;
			}
			
			if(i1.start > i2.start){
				return 1;
			}
			return 0;
		}
		
		
	}
	
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
