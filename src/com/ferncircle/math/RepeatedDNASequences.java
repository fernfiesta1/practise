package com.ferncircle.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {

		Set<Integer> words = new HashSet<>();
		Set<Integer> result = new HashSet<>();
		List<String> res = new ArrayList<>();
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 00);
		map.put('C', 01);
		map.put('G', 10);
		map.put('T', 11);

		int mask = 0b11111111111111111111; 

		int i=0;
		int j=0;
		int v =0;
		while(j<10){
			v = v << 2;
			v = v | map.get(s.charAt(j));			 
			j++;
		}  
		words.add(v);

		while(j < s.length()){
			v = v << 2;
			v = v | map.get(s.charAt(j));
			v = v & mask;

			if(!words.add(v)){
				if(result.add(v)){
					res.add(s.substring(i+1,j+1));
				}               
			}
			i++;
			j++;
		}

		return res; 


	}

	public static void main(String[] args) {
		
		String input = "GAGAGAGAGAGA";
		RepeatedDNASequences rs = new RepeatedDNASequences();
		System.out.println(rs.findRepeatedDnaSequences(input));
	}

}
