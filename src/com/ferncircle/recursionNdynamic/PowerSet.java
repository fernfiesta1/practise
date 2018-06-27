package com.ferncircle.recursionNdynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

	public static List<List<Integer>> subsets1(int[] nums) {

		List<List<Integer>> out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>());
		for(int i=0; i< nums.length; i++){

			List<List<Integer>> temperory = new ArrayList<List<Integer>>();
			temperory.addAll(out);
			for(List<Integer> temp: temperory){
				List<Integer> t1 = new ArrayList<Integer>();
				t1.addAll(temp);
				t1.add(nums[i]);
				out.add(t1);
			}			
		}		
		return out;
	}
	
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	   // System.out.println("tempList -->" + tempList + ", nums[]-->" + nums + ", start --> " + start);
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}

	public static void main(String[] args) {
		
		int[] input = new int[]{1,2,3,4,5,6};
		//System.out.println(subsets1(input));
		
		PowerSet ps = new PowerSet();
		System.out.println(ps.subsets(new int[]{1,2,3}));

	}

}
