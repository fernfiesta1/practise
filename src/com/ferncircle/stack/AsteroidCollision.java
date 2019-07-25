package com.ferncircle.stack;

import java.util.Stack;

public class AsteroidCollision {

	public static int[] asteroidCollision(int[] asteroids) {

		Stack<Integer> stack = new Stack<>();        

		for(int i=0; i< asteroids.length; i++){
			if(asteroids[i] > 0 || stack.isEmpty()){
				stack.push(asteroids[i]);
				continue;
			}

			while(true){
				
				if(-asteroids[i] < stack.peek()){
					break;
				}

				if(-asteroids[i] > stack.peek()){
					stack.pop();
					if(stack.isEmpty()){
						stack.push(asteroids[i]);
						break;
					}
				}

				if(Math.abs(asteroids[i]) == stack.peek()){
					stack.pop();
					break;
				}
			}
		}


		int[] res = new int[stack.size()];
		for(int i=res.length-1; i>=0; i--){
			res[i] = stack.pop();
		}

		return res;
	}
	
	public static void main(String[] args) {
		
		int[] in = new int[] {8,-8};
		System.out.println(asteroidCollision(in));
	}
}
