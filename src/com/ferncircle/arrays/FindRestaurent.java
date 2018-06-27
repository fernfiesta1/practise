package com.ferncircle.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class FindRestaurent {

	public static String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		
		for(int i=0; i<list1.length; i++){
			indexMap.put(list1[i], i);
		}
		
		int leastSum = list1.length + list2.length;
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i< list2.length; i++){
			if(indexMap.containsKey(list2[i])){
				int sum = i + indexMap.get(list2[i]);
				if(leastSum >= sum){
					if(leastSum == sum){
						result.add(list2[i]);
					}else{
						leastSum = sum;
						result = new ArrayList<String>();
						result.add(list2[i]);
					}
					
				}
			}
		}
		
		String[] out = new String[result.size()];
		for(int i=0; i<out.length; i++){
			out[i] = result.get(i);
		}
		return out;
	}

	public static void main(String[] args) {
		
		String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		String[] result = findRestaurant(list1, list2);
		Assert.assertEquals(1, result.length);
		Assert.assertEquals("Shogun", result[0]);
		
		list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		list2 = new String[]{"KFC", "Shogun", "Burger King"};
		
		result = findRestaurant(list1, list2);
		Assert.assertEquals(1, result.length);
		Assert.assertEquals("Shogun", result[0]);
		
		list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
		list2 = new String[]{"Tapioca Express", "Shogun", "Burger King"};
		
		result = findRestaurant(list1, list2);
		Assert.assertEquals(2, result.length);
		Assert.assertEquals("Tapioca Express", result[0]);
		Assert.assertEquals("Shogun", result[1]);
		

	}

}
