package com.ferncircle.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	private class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start == o2.start){
				return 0;
			}else if(o1.start < o2.start){
				return -1;
			}else{
				return 1;
			}			
		}

	}

	private class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
		
		
	}
	
    public List<Interval> merge(List<Interval> intervals) {
     
    	Collections.sort(intervals, new IntervalComparator());
    	List<Interval> result = new ArrayList<>();
    	
    	int start = intervals.get(0).start;
    	int end = intervals.get(0).end;
    	for(Interval i: intervals){
    		if(i.start <= end){
    			end = Math.max(end, i.end);
    		}else{    						
    			Interval interval = new Interval(start, end);
    			result.add(interval);
    			start = i.start;
    			end = i.end;
    		}
    	}
    	
    	Interval interval2 = new Interval(start, end);
    	result.add(interval2);
    	
    	return result;
    	
    }

	public static void main(String[] args) {
		
		List<Interval> input = new ArrayList<>();
		MergeIntervals mi = new MergeIntervals();
		input.add(mi.new Interval(1, 3));
		input.add(mi.new Interval(2, 6));
		input.add(mi.new Interval(8, 10));
		input.add(mi.new Interval(15, 20));
		input.add(mi.new Interval(6,8));
		
		for(Interval i: mi.merge(input)){
			System.out.println(i);
		}
		

	}

}
