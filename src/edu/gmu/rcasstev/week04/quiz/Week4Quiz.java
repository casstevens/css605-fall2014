package edu.gmu.rcasstev.week04.quiz;

import java.util.Arrays;

/**
 * Answers for Week 4 Quiz.
 * 
 * @author randy
 *
 */
public class Week4Quiz {

	/**
	 * Returns the last element in each row.
	 * 
	 * @param nums
	 * @return
	 */
	public static double[] someMethod(double[][] nums) {
		double[] retval = new double[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int j = nums[i].length - 1;
			retval[i] = nums[i][j];
		}

		return retval;
	}

	public static void main(String[] args) {

		//
		// Question 1
		//

		// Remember that the operators are executed from left to right

		int x = 10;
		int y = 20;

		System.out.println("x + y is " + x + y);

		//
		// Question 2
		//

		double[][] myNums = new double[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 },
				{ 9, 10, 11, 12 } };

		System.out.println(Arrays.toString(someMethod(myNums)));
	}

}
