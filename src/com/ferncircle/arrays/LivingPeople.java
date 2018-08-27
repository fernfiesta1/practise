package com.ferncircle.arrays;

public class LivingPeople {

	/**
	 * This is a brute force solution. for each year check if there are any
	 * births. Increment the birth counter. update global living counter if it
	 * is less than the current live counter. decrement the living counter by
	 * the number of deaths in that year
	 * 
	 * Complexity is O(py) p --> number of people Y--> number of years
	 * 
	 * 
	 * @param birthYear
	 * @param deathYear
	 * @return
	 */
	public int getYear(int[] birthYear, int[] deathYear) {

		int globalYear = 1900;
		int alive = 0;

		int prevAlive = 0;

		int birthIdx = 0;
		int deathIdx = 0;

		for (int i = 1900; i <= 2000; i++) {

			// Count number of births + alive so far in a particular year
			int currAlive = 0;
			while (birthIdx <= birthYear.length - 1 && birthYear[birthIdx] == i) {
				currAlive++;
				birthIdx++;
			}
			currAlive = currAlive + prevAlive;

			// Update the global year with the year that has max alive so far
			if (alive < currAlive) {
				alive = currAlive;
				globalYear = i;
			}

			// Decrement number of deaths from number of births in that year
			while (deathIdx <= deathYear.length - 1 && deathYear[deathIdx] == i) {
				currAlive--;
				deathIdx++;
			}

			prevAlive = currAlive;
		}

		return globalYear;
	}

	/**
	 * Birth year and death year are not sorted. create a temp array for all the
	 * years[Like an array]. Increement the birth year and decrement the death
	 * year + 1(coz even if the person was partially alive for that year we have
	 * to consider him alive for that year)
	 * 
	 * In the second pass, go through the array and cumulative count the number of people alive or a particular year and take the max.
	 * 
	 * @param birthYear
	 * @param deathYear
	 * @return
	 */

	public int getYear2(int[] birthYear, int[] deathYear) {

		// Assuming births and deaths are between 1900 and 2000 inclusive
		int[] temp = new int[101];
		for (int i = 0; i < birthYear.length; i++) {
			int birthIdx = birthYear[i] - 1900;
			temp[birthIdx]++;
			int deathIdx = deathYear[i] - 1900;
			temp[deathIdx + 1]--;
		}

		int globalYear = 1900;
		int globalAlive = 0;

		int tempAlilve = 0;
		for (int i = 0; i < temp.length; i++) {
			tempAlilve += temp[i];
			if (tempAlilve > globalAlive) {
				globalAlive = tempAlilve;
				globalYear = 1900 + i;
			}
		}
		return globalYear;
	}

	public static void main(String[] args) {

		LivingPeople lp = new LivingPeople();
		int[] births = new int[] { 1900, 1901, 1902, 1902 };
		int[] deaths = new int[] { 1901, 1901, 1903, 1903 };

		System.out.println(lp.getYear2(births, deaths));

	}

}
