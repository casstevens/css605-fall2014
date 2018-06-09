package edu.gmu.rcasstev.week03.quiz;

import java.util.Arrays;

/**
 * Answers for the Week 3 Quiz.
 * 
 * @author randy
 *
 */
public class Week3Quiz {

	/**
	 * This method swaps the odd indices with the even indices.
	 * 
	 * @param intArray
	 * @return
	 */
	public static int[] someFunction(int[] intArray) {
		for (int i = 0; i < intArray.length - 1; i = i + 2) {
			int temp = intArray[i];
			intArray[i] = intArray[i + 1];
			intArray[i + 1] = temp;
		}

		return intArray;
	}

	public static void main(String[] args) {

		//
		// Question 1
		//

		System.out.println("Answer to Question 1");

		int x = 1;
		int y = 5;

		if (x > 0) {
			System.out.println("x > 0");
		} else if (y > 1) {
			System.out.println("y > 1");
		}

		//
		// Question 2
		//

		System.out.println();
		System.out.println("Answer to Question 2");

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };

		System.out.println(Arrays.toString(someFunction(nums)));
	}
}
