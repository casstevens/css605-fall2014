package edu.gmu.rcasstev.week02.assignment;

import java.util.Arrays;

/**
 * Here is your assignment for Week 2:
 * 
 * DUE: September 8th at noon
 *
 * TASK 1: Copy Week2.java and Week2Test.java to your own package following the
 * same pattern as used above (i.e., replace rcasstev with your username).
 * 
 * TASK 2: Implement the averageElements and squareElements methods.
 *
 * TASK 3: Make several calls to these methods in the main method to make sure
 * they are calculating the results correctly and output the results to standard
 * out (i.e., System.out).
 *
 * TASK 4: Run the unit tests in Week2Test.java to ensure your methods are
 * correct.
 * 
 * TASK 5: Email your version of Week2.java to rcasstev@gmu.edu
 * 
 */
public class Week2Solution {

	/**
	 * Take the average of all the elements in the array.
	 * 
	 * @param nums
	 * @return
	 */
	public static double averageElements(double[] nums) {

		double sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}

		return sum / nums.length;
	}

	/**
	 * Square each of the elements and return the values in an array.
	 * 
	 * @param nums
	 * @return
	 */
	public static double[] squareElements(double[] nums) {

		// Create space for the return value
		double[] squaredNums = new double[nums.length];

		for (int i = 0; i < nums.length; i++) {
			squaredNums[i] = nums[i] * nums[i];
		}

		return squaredNums;
	}

	public static void main(String[] args) {

		double[] someNums = new double[] { 1, 2, 4, 8, 16, 32, 64 };

		System.out.println("Average of elements: " + averageElements(someNums));
		System.out.println("Elements squared: "
				+ Arrays.toString(squareElements(someNums)));
	}
}
