package edu.gmu.rcasstev.week03.assignment;

import java.util.Arrays;

/**
 * Here is your assignment for Week 3:
 * 
 * DUE: September 15th at noon
 *
 * TASK 1: Copy Week3.java and Week3Test.java to your own package following the
 * same pattern as used above (i.e., replace rcasstev with your username).
 * 
 * TASK 2: Implement the sumRowElements, sumColumnElements, and stringToArray
 * methods.
 *
 * TASK 3: Make several calls to these methods in the main method to make sure
 * they are calculating the results correctly and output the results to standard
 * out (i.e., System.out).
 *
 * TASK 4: Run the unit tests in Week3Test.java to ensure your methods are
 * correct.
 * 
 * TASK 5: Email your version of Week3.java to rcasstev@gmu.edu
 * 
 */
public class Week3Solution {

	/**
	 * Sum the numbers in each of the rows of the two dimensional array given as
	 * input.
	 * 
	 * @param nums
	 *            the numbers to be summed
	 * @return the sum for each row
	 */
	public static double[] sumRowElements(double[][] nums) {

		// Create space for return value
		double[] rowSums = new double[nums.length];

		// Sum each of the rows
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				rowSums[r] = rowSums[r] + nums[r][c];
			}
		}

		return rowSums;
	}

	/**
	 * Sum the numbers in each of the columns of the two dimensional array given
	 * as input.
	 * 
	 * Note: This can be tricker because there could rows with different column
	 * lengths.
	 * 
	 * @param nums
	 *            the numbers to be summed
	 * @return the sum for each column
	 */
	public static double[] sumColumnElements(double[][] nums) {

		int maxNumColumns = 0;

		// Find the maximum number of columns from the input
		for (int r = 0; r < nums.length; r++) {
			if (maxNumColumns < nums[r].length) {
				maxNumColumns = nums[r].length;
			}
		}

		// Create space for return value
		double[] colSums = new double[maxNumColumns];

		// Sum each of the columns
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[r].length; c++) {
				colSums[c] = colSums[c] + nums[r][c];
			}
		}

		return colSums;
	}

	/**
	 * Convert the String input into an array of doubles. The numbers in the
	 * input String are separated with a comma (,).
	 * 
	 * @param numsString
	 *            the String that contains the numbers separated by a comma
	 * @return the array that contains the numbers as doubles
	 */
	public static double[] stringToArray(String numsString) {

		// Numbers of separated by commas, so split on comma
		String[] splitOnCommaStrs = numsString.split(",");

		// Create space for return value
		double[] numsFromStrs = new double[splitOnCommaStrs.length];

		// Convert each substring into a double
		for (int i = 0; i < splitOnCommaStrs.length; i++) {
			String curString = splitOnCommaStrs[i];
			numsFromStrs[i] = Double.parseDouble(curString);
		}

		return numsFromStrs;
	}

	public static void main(String[] args) {

		// Test input
		double[][] myNums = new double[][] { { 1, 2, 3 }, { 4, 5, 6, 7 } };

		// Calculate row and column sums
		double[] rowSums = sumRowElements(myNums);
		double[] colSums = sumColumnElements(myNums);

		// Print results from row and column sums
		System.out.println("Row sums are: " + Arrays.toString(rowSums));
		System.out.println("Column sums are: " + Arrays.toString(colSums));

		// String of numbers separated by commas
		String numberStr = "1,2,3,4";

		// Convert String to double array
		double[] numberArray = stringToArray(numberStr);

		// Print results of String to double array conversion
		System.out.println(Arrays.toString(numberArray));
		
	}
}
