package com.ferncircle.twopointers;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public List<Integer> partitionLabels(String S) {
		
		int[] input = new int[26];
		
		char[] sArr = S.toCharArray();
		for(int i=0; i<sArr.length; i++){
			input[sArr[i] - 'a'] = i;
		}
		
		int max =0; int min =0;
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<sArr.length; i++){
			max = Math.max(max, input[sArr[i] - 'a']);
			
			if(max == i){
				int count = max - min +1;
				result.add(count);
				min = i+1;
			}
		}

		return result;
	}

	public static void main(String[] args) {


	}

}
