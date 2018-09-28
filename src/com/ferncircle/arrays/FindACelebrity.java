package com.ferncircle.arrays;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * @author dbrit00s
 *
 */
public class FindACelebrity {

	public int findCelebrity(int n) {

		int celebrityIdx = 0;
		for(int i=1; i< n; i++){
			//If person at knows the person at celebrityIdx, than the person at celebrity index is not a celebrity.
			if(knows(celebrityIdx, i)){
				celebrityIdx = i;
			}
		}

		//By this point we have a potential candidate who could be a celebrity.

		for(int i=0; i< n; i++){
			if(celebrityIdx != i && (knows(celebrityIdx, i) || !knows(i, celebrityIdx))){
				return -1;
			}

		}
		return celebrityIdx;
	}

	private boolean knows(int a, int b){
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
