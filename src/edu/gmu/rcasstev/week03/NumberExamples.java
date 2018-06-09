package edu.gmu.rcasstev.week03;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * So, far we have discussed primitive data types (e.g., int, double, etc.), but
 * each of these have a corresponding Object that provides additional
 * functionality.
 * 
 * @author randy
 *
 */
public class NumberExamples {

	public static void main(String[] args) {

		//
		// Creating Doubles
		//

		// Before we would create a double like the following
		double xPrimitive = 1.5;

		// But, to create a Double object:
		Double xObject = 1.5;

		// Or do this:
		Double xObject2 = new Double(1.5);

		// With a Double object we can do things like indicate when the value is
		// missing
		xObject2 = Double.NaN;

		// Or convert a String into a Double
		xObject2 = Double.valueOf("2.75");
		
		// We can still do mathematical operations with Doubles
		Double xObject3 = xObject + xObject2;

		System.out.println("xObject3 is: " + xObject3);

		// There is also Objects for Integers, Bytes, Long, etc.
		
		//
		// Converting String into Array of Numbers
		//

		// Continuing from the example in StringExamples:
		String numStr = "1 \t 2 \t 3 \t 4";

		// If we want to create an array of integers from this String we can
		// split based on the tab character
		String[] numStrSplitAtTab = numStr.split("\t");

		// Create an array to hold the integers
		int[] nums = new int[numStrSplitAtTab.length];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numStrSplitAtTab[i].trim());
		}

		System.out.println("This String: " + numStr
				+ " was converted to this array of ints: ");
		System.out.println(Arrays.toString(nums));

		// Notice how I used the trim method to remove any whitespace from the
		// beginning or end of the String.

		// If you wanted to parse a double, you could do:
		String someDoubleStr = "12.5";
		double someDouble = Double.parseDouble(someDoubleStr);
		System.out.println(someDoubleStr + " was parsed to create the double: " + someDouble);
		
		//
		// BigDecimal
		//

		// You can also gain precision by moving to a BigDecimal instead of a
		// Double.

		// Earlier in the semester we found precision problems with 0.1
		Double oneTenth = new Double(0.1);

		// If we create a BigDecimal based on a Double, then it will have the
		// same precision issues as the original Double
		BigDecimal oneTenthBig = new BigDecimal(oneTenth);

		// But, if we do all of the calculations using BigDecimals, then there
		// isn't precision issues
		BigDecimal oneDivTenBig = new BigDecimal(1).divide(new BigDecimal(10));

		System.out.println("BigDecimal created with Double: " + oneTenthBig);
		System.out.println("BigDecimal created with two BigDecimals: "
				+ oneDivTenBig);
		
		// However, we cannot do the following with BigDecimals:
		// BigDecimal addBigDecimal = oneTenthBig + oneDivTenBig; // <- Does not compile
		
		// We do it using the method:
		BigDecimal addBigDecimal = oneTenthBig.add(oneDivTenBig);
		System.out.println();
		System.out.println("After adding the two together: " + addBigDecimal);
	}
}
