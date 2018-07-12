package com.ferncircle.twopointers;

import java.util.ArrayList;
import java.util.List;



/**
 * @author dbrit00s
 * 
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 *
 */
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
