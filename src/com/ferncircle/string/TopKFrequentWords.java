package com.ferncircle.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count = new HashMap();
		for (String word: words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}
		List<String> candidates = new ArrayList(count.keySet());
		Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
				w1.compareTo(w2) : count.get(w2) - count.get(w1));

		return candidates.subList(0, k);

	}

	public List<String>  topKFrequent2(String[] words, int k) {
		Map<String, Integer> count = new HashMap();
		for (String word: words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<Entry<String, Integer>> queue = new PriorityQueue<>(new QueueComparator());

		for(Entry<String, Integer> entry: count.entrySet()){
			queue.add(entry);
		}
		
		List<String> result = new ArrayList<>();
		
		while(k > 0){
			result.add(queue.poll().getKey());
			k--;
		}

		return result;


	}
	
	public static void main(String[] args){
		String[] input = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		TopKFrequentWords t = new TopKFrequentWords();
		System.out.println(t.topKFrequent(input, 4));
		System.out.println(t.topKFrequent2(input, 4));
	}

	public class QueueComparator implements Comparator<Entry<String, Integer>>{

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			return o1.getValue().equals(o2.getValue())? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
		}

	}
}






