package edu.gmu.rcasstev.week04.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Here is your assignment for Week 4:
 * 
 * DUE: September 22th at noon
 *
 * TASK 1: Copy Week4.java and Week4Test.java to your own package following the
 * same pattern as used above (i.e., replace rcasstev with your username).
 * 
 * TASK 2: Implement the findValuesWithinRange method.
 *
 * TASK 3: Make several calls to this method in the main method to make sure
 * they are calculating the results correctly and output the results to standard
 * out (i.e., System.out).
 *
 * TASK 4: Run the unit tests in Week4Test.java to ensure your method is
 * correct.
 * 
 * TASK 5: Email your version of Week4.java to rcasstev@gmu.edu
 * 
 */
public class Week4Solution {

	/**
	 * The first two input parameters for this method are two arrays that should
	 * be of equal length. If they are not, then throw an
	 * IllegalArgumentException. The two arrays represent a time series where
	 * the Date array is the time the values in the double array were collected.
	 * 
	 * Using the start and end Date, return an array of doubles that are the
	 * values from the input parameter that lie between the two dates (including
	 * the data points that are equal to the start and end dates).
	 * 
	 * @param dates
	 * @param nums
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] findValuesWithinRange(Date[] dates, double[] nums,
			Date startDate, Date endDate) throws IllegalArgumentException {

		if (dates.length != nums.length) {
			throw new IllegalArgumentException(
					"dates and nums are not the same length");
		}

		// List to hold the returned values
		ArrayList<Double> retvalList = new ArrayList<Double>();

		for (int i = 0; i < dates.length; i++) {
			Date d = dates[i];
			// If date is between start and end
			if (startDate.getTime() <= d.getTime()
					&& endDate.getTime() >= d.getTime()) {
				// Then save the value to the list
				retvalList.add(nums[i]);
			}
		}

		// Convert to a double array
		double[] retval = new double[retvalList.size()];

		for (int i = 0; i < retvalList.size(); i++) {
			retval[i] = retvalList.get(i);
		}

		return retval;
	}

	/**
	 * The previous approach used a List for holding the results, but another
	 * way to do it is the following method where you iterate through the list
	 * of Dates to determine how large your return value should be.
	 * 
	 * @param dates
	 * @param nums
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double[] findValuesWithinRange2(Date[] dates, double[] nums,
			Date startDate, Date endDate) throws IllegalArgumentException {

		if (dates.length != nums.length) {
			throw new IllegalArgumentException(
					"dates and nums are not the same length");
		}

		// Determine size of return value
		int count = 0;
		for (Date d : dates) {
			if (startDate.getTime() <= d.getTime()
					&& endDate.getTime() >= d.getTime()) {
				count++;
			}
		}

		// Make the return value
		double[] retval = new double[count];

		count = 0;
		for (int i = 0; i < dates.length; i++) {
			Date d = dates[i];
			if (startDate.getTime() <= d.getTime()
					&& endDate.getTime() >= d.getTime()) {
				retval[count] = nums[i];
				count++;
			}
		}

		return retval;
	}

	public static void main(String[] args) {

		// Just some example code
		Date[] dates = new Date[] { new Date(100), new Date(200),
				new Date(300), new Date(400) };
		double[] vals = new double[] { 1.0, 2.0, 3.0, 4.0 };

		Date start = new Date(150);
		Date end = new Date(350);

		System.err.println(Arrays.toString(findValuesWithinRange(dates, vals,
				start, end)));

	}
}
