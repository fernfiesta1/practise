package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {

		//Create a Map of elements and its frequency
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for(int i=0; i< nums.length; i++){

			frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);

		}

		//Create a bucket array to hold the elements who belong to that bucket
		List<Integer>[] bucket = new List[nums.length + 1];

		//Add empty list to the buckets
		for(int i=0; i< bucket.length; i++){
			bucket[i] = new ArrayList<>();
		}

		//add elements to the buckets
		for(int key: frequencyMap.keySet()){
			int value = frequencyMap.get(key);
			bucket[value].add(key);
		}


		//Go throught the buckets from the end, and return k elements.

		List<Integer> result = new ArrayList<>();
		for(int i = bucket.length-1; i>=0; i--){
			List<Integer> temp = bucket[i];
			result.addAll(temp);
			if(result.size() >= k){
				return result;
			}

		}

		return result;

	}

	public static void main(String[] args) {

		TopKFrequentElements te = new TopKFrequentElements();
		int[] input = new int[]{1};
		System.out.println(te.topKFrequent(input, 1));

	}

}
