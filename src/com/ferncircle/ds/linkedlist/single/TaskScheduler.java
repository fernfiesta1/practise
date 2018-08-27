package com.ferncircle.ds.linkedlist.single;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {

		int count =0; 
		if(tasks.length == 0){
			return count;
		}
		
		if(tasks.length == 1){
			return 1;
		}
		//create a count array of the input tasks
		int[] taskCount = new int[26];
		for(char task: tasks){
			taskCount[task - 65] +=1;
		}
		
		//Create a priority Queue, so that it retuns the largest element in the collection.
		//By default Priority queue returns the natural ordering(smallest element). Hence, do the reverse order.
		PriorityQueue<Integer> taskQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i: taskCount){
			if(i > 0){
				taskQueue.add(i);
			}
		}
		
		Queue<Integer> temp = new LinkedList<>();
		int waitTime = n+1;
		
		while(!taskQueue.isEmpty()){
			while(waitTime > 0){
				if(!taskQueue.isEmpty()){
					int executedTask = taskQueue.remove();
					if(executedTask-1 >0){
						temp.add(executedTask-1);						
					}
					waitTime--;
					count++;
				}else if(taskQueue.isEmpty() && temp.isEmpty()){
					return count;
				}else{
					count++;
					waitTime--;
				}				
								
			}
			
			while(!temp.isEmpty()){
				taskQueue.add(temp.remove());
			}
			waitTime = n+1;
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		TaskScheduler ts = new TaskScheduler();
		System.out.println(ts.leastInterval(new char[]{'A','A','A','A','A'}, 2));

	}

}
