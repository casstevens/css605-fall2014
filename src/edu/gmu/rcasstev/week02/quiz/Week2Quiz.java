package edu.gmu.rcasstev.week02.quiz;

import java.util.Arrays;

public class Week2Quiz {

	/**
	 * This method shifts all of the elements to the left one index and moves
	 * the first element to the end.
	 * 
	 * @param intArray
	 * @return
	 */
	public static int[] someFunction(int[] intArray) {
		if (intArray.length == 0) {
			return intArray;
		}

		int firstElement = intArray[0];

		for (int i = 1; i < intArray.length; i++) {
			intArray[i - 1] = intArray[i];
		}

		intArray[intArray.length - 1] = firstElement;

		return intArray;
	}

	public static void main(String[] args) {

		//
		// Question 1
		//

		System.out.println("Answer to Question 1");

		int i = 1;

		while (i <= 5) {
			if (i % 5 == 0) {
				System.out.println("i % 5 == 0");
			} else if (i * i > 5) {
				System.out.println("i * i > 5");
			} else {
				System.out.println("else");
			}

			i = i + 2;
		}

		//
		// Question 2
		//

		System.out.println("");
		System.out.println("Answer to Question 2");

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		System.out.println(Arrays.toString(someFunction(nums)));
	}

}
