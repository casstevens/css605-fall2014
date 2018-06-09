package edu.gmu.rcasstev.week04;

import java.util.Arrays;

/**
 * A couple of examples to show how parameter passing works in Java.
 * 
 * @author randy
 *
 */
public class ParameterPassingExamples {

	public static void someMethod(Double x) {
		x = x * 2.0;
		System.err.println("someMethod(Double x) after multiplication: " + x);
	}

	public static void someArrayMethod(Double[] nums) {
		for (Double x : nums) {
			x = x * 2.0;
		}
		System.err
				.println("someMethodArray(Double[] nums) after multiplication: "
						+ Arrays.toString(nums));
	}

	public static void someArrayMethod2(Double[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * 2.0;
		}
		System.err
				.println("someMethodArray2(Double[] nums) after multiplication: "
						+ Arrays.toString(nums));
	}

	public static void main(String[] args) {

		Double someDouble = 10.0;
		Double[] someDoubles = new Double[] { 1.0, 2.0, 3.0, 4.0 };
		Double[] someDoubles2 = new Double[] { 1.0, 2.0, 3.0, 4.0 };

		// Print the data before calling the methods
		System.err.println("someDouble before method call: " + someDouble);
		System.err.println("someDoubles before method call: "
				+ Arrays.toString(someDoubles));
		System.err.println("someDoubles2 before method call: "
				+ Arrays.toString(someDoubles));

		System.err.println();

		// Call some methods to see if they change the original data
		someMethod(someDouble);
		someArrayMethod(someDoubles);
		someArrayMethod2(someDoubles2);

		System.err.println();

		// Print the data after calling the methods
		System.err.println("someDouble after method call: " + someDouble);
		System.err.println("someDoubles after method call: "
				+ Arrays.toString(someDoubles));
		System.err.println("someDoubles2 after method call: "
				+ Arrays.toString(someDoubles2));

	}

}
