package com.ferncircle.string;


/**
 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

Examples:

Input : arr[] = {"for", "geeks", "", "", "", "", "ide", 
                      "practice", "", "", "", "quiz"}
          x = "geeks"
Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide", 
                      "practice", "", "", "", "quiz"}, 
          x = "ds"
Output : -1
 * @author dbrit00s
 *
 */
public class SparseSearch {

	
	public int search(String[] input, String in){
	
		if(in == null || in.isEmpty()){
			return -1;
		}
		return helper(input, 0, input.length-1, in);
		
	}
	
	private int helper(String[] input, int low, int high, String in){
		if (low > high){
			return -1;
		}
		
		int mid = (high - low)/2;		
		if(input[mid] == ""){
			
			int left = mid;
			int right = mid;
			while(true){
				
				if(left > low && input[left] != "") {					
					mid = left;
					break;
				}
				
				if(right < high && input[right] != "") {					
					mid = right;
					break;
				}
				
				left--;
				right++;
			}
		}
		
		if(input[mid].compareToIgnoreCase(in) == 0){
			return mid;
		}else if(input[mid].compareToIgnoreCase(in) < 0){
			return helper(input, mid+1, high, in);
		}else{
			return helper(input, low, mid-1, in);
		}
	}
	public static void main(String[] args) {
		
		SparseSearch ss = new SparseSearch();
		String[] input = new String[]{"cat","","","","bat","","","","","","","","","","","","","","","","","","","mat","","","","","","","","",""};
		System.out.println(ss.search(input, ""));

	}

}
