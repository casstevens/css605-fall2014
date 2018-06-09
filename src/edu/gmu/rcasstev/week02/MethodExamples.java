package edu.gmu.rcasstev.week02;

import java.util.Arrays;

/**
 * These examples brings together some of the other concepts from Week 2.
 * 
 * @author randy
 *
 */
public class MethodExamples {

	/**
	 * Calculates the percent change for each index in each of the two arrays.
	 * 
	 * The percent change is (newVal - oldVal) / oldVal * 100.0
	 * 
	 * @param oldVals
	 * @param newVals
	 * @return
	 */
	public static double[] calculatePercentChange(int[] oldVals, int[] newVals) {
		// Check if the two arrays are of the same length
		if (oldVals.length != newVals.length) {
			return null;
		}

		// Create an array to hold the results
		double[] results = new double[oldVals.length];

		for (int i = 0; i < results.length; i++) {
			// Calculate the percent change from old to new val
			results[i] = 100.0 * (newVals[i] - oldVals[i]) / oldVals[i];

			// NOTE: If the multiply by 100.0 was at the end of the calculation,
			// then it would not calculate the correct answer because in that
			// case the division would have been treated as an integer
			// operation.
		}

		return results;
	}

	/**
	 * Reverse the order of the input parameter array.
	 * 
	 * @param vals
	 * @return
	 */
	public static int[] reverseOrder(int[] vals) {

		// Only need to iterate over half of the values since we are swapping
		// values
		for (int i = 0; i < vals.length / 2; i++) {
			int temp = vals[i];
			vals[i] = vals[vals.length - 1 - i];
			vals[vals.length - 1 - i] = temp;
		}

		return vals;
	}

	public static void main(String[] args) {

		//
		// Percent change example
		//

		// Say, we have the number of employees for five firms for two years
		int[] firmSizesYear1 = new int[] { 1, 2, 4, 5, 10 };
		int[] firmSizesYear2 = new int[] { 2, 2, 2, 4, 15 };

		System.out.println("Firm sizes for year 1 and year 2");
		System.out.println(Arrays.toString(firmSizesYear1));
		System.out.println(Arrays.toString(firmSizesYear2));

		// Calculate the percent change from one year to the next
		System.out.println("Percent change from year 1 to year 2");
		System.out.println(Arrays.toString(calculatePercentChange(
				firmSizesYear1, firmSizesYear2)));

		//
		// Reverse array example
		//

		// Reverse the array for year 1 (which happens to have an odd number of
		// values)
		System.out.println("Reverse values for year 1");
		System.out.println(Arrays.toString(reverseOrder(firmSizesYear1)));

		// It is also a good idea to test it with an array that has an even
		// number of values
		int[] someOtherVals = new int[] { 1, 2, 3, 4, 5, 10 };

		System.out.println("Reverse values for some other values");
		System.out.println(Arrays.toString(reverseOrder(someOtherVals)));
	}
}
