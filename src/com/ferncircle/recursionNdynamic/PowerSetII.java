package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PowerSetII {

	public List<List<Integer>> subsets(int[] nums) {

		Map<Integer, Integer> elementCount = new TreeMap<>();
		// Count the number of unique Integers in the input array
		for (Integer i : nums) {
			elementCount.compute(i, (k, v) -> (v == null) ? 1 : (v + 1));
		}

		// Create input array of unique integers
		int[] input = new int[elementCount.size()];
		// Create count array of elements in the input array
		int[] count = new int[elementCount.size()];

		int i = 0;
		/*for (Entry<Integer, Integer> entry : elementCount.entrySet()) {
			input[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}*/
		
		for(Integer key: elementCount.keySet()){
			input[i] = key;
			count[i] = elementCount.get(key);
			i++;
		}

		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		backtrack(input, count, temp, result, 0);
		return result;

	}

	public void backtrack(int[] input, int[] count, List<Integer> temp, List<List<Integer>> result, int pos) {

		result.add(new ArrayList<Integer>(temp));

		for (int i = pos; i < input.length; i++) {
			if (count[i] == 0) {
				continue;
			}

			temp.add(input[i]);
			count[i]--;
			backtrack(input, count, new ArrayList<Integer>(temp), result, i);
			count[i]++;
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {

		PowerSetII ps = new PowerSetII();
		int[] input = new int[] { 1, 2, 3 };
		System.out.println(ps.subsets(input));

	}

}
