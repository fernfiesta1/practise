package com.ferncircle.recursionNdynamic;

import java.util.Arrays;

public class PaintFill {

	public void paintfill(int[][] screen, int x, int y, int oldColor, int newColor){

		if(x < 0 || y < 0 || x > screen.length-1 || y > screen[0].length-1){
			return;
		}

		if(screen[x][y] != oldColor){
			return;
		}

		screen[x][y] = newColor;
		paintfill(screen, x+1, y, oldColor, newColor);
		paintfill(screen, x-1, y, oldColor, newColor);
		paintfill(screen, x, y+1, oldColor, newColor);
		paintfill(screen, x, y-1, oldColor, newColor);		
		

	}

	public static void main(String[] args) {
		int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 1, 0, 1, 1},
				{1, 2, 2, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 2, 2, 0},
				{1, 1, 1, 1, 1, 2, 1, 1},
				{1,	1, 1, 1, 1, 2, 1, 1}};
		
		PaintFill pf = new PaintFill();
		pf.paintfill(screen, 4, 4, 2, 3);
		System.out.println(Arrays.deepToString(screen));
	}
}

