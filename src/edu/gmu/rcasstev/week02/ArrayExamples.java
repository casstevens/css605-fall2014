package edu.gmu.rcasstev.week02;

import java.util.Arrays;

/**
 * Shows a simple example of arrays and array indexing, which goes from 0 to
 * size-1.
 * 
 * @author randy
 *
 */
public class ArrayExamples {

	public static void main(String[] args) {

		//
		// Basic arrays
		//

		// Create a variable for an array
		int[] intArray;

		// Before you can use this array, we need to allocate memory for it
		intArray = new int[10];

		// You could also do this in one line of code:
		// int[] intArray2 = new int[10];

		// Now, we have an array of 10 ints, but default value of zero
		System.out.println(Arrays.toString(intArray));

		// The Arrays class provides some handy features for arrays, but for the
		// assignment this week you will need to re-implement some of that
		// functionality for practice!

		// We can place values in the array by using indexing
		intArray[0] = 123;
		intArray[5] = 567;

		// Let's see what it looks like now...
		System.out.println("After inserting a couple of values...");
		System.out.println(Arrays.toString(intArray));

		// COMMON MISTAKES WITH ARRAYS
		// IMPORTANT: Indexing starts at zero!
		// ALSO IMPORTANT: The last index in the array is size - 1 (NOT size!)

		// This would throw an exception (i.e., an error)
		// intArray[10] = 100;

		// Sometimes it is handy to declare an array and initialize it at the
		// same time:
		double[] doubleArray = new double[] { 0.5, 1.0, 2.0, 4.0, 8.0 };

		// Let's print it to see what it looks like...
		System.out.println("Initized a double array at declaration");
		System.out.println(Arrays.toString(doubleArray));

		// If you initialize an array during declaration, then you do not need
		// to include the size of the array. The array is made the same size as
		// the number of values given.

		// To see the size of an array you can do the following:
		System.out.println("Size of arrays");
		System.out.println("int array size: " + intArray.length);
		System.out.println("double array size: " + doubleArray.length);

		// Notice the use of the dot operator (.), we will talk about that a lot
		// more in future lectures.

		// Just to reiterate, if you want access to the last element of the
		// array, you need to subtract one from the array length:
		System.out.println("Last element of arrays");
		System.out.println("int array last element: "
				+ intArray[intArray.length - 1]);
		System.out.println("double array last element: "
				+ doubleArray[doubleArray.length - 1]);

		// Also, you can create arrays using other types (e.g., boolean, long,
		// etc.)

		//
		// Two dimensional arrays
		//

		// You can also create multidimensional arrays.

		double[][] twoDimensionalArray = new double[3][5];

		// This creates a two dimensional array with 3 rows and 5 columns.
		// Row indices are 0 to 2
		// Column indices are 0 to 4

		System.out.println("Print two dimensional array");

		// Print the elements of the array
		for (int i = 0; i < twoDimensionalArray.length; i++) {
			System.out.println(Arrays.toString(twoDimensionalArray[i]));
		}

		// You can see that the elements where initialized to zero.

		// All of the rows do not have to have the same number of elements:
		twoDimensionalArray[1] = new double[] { 1, 2, 3, 4, 5, 6, 7, 8 };

		System.out
				.println("Print two dimensional array after changing the second row");

		// Now if we print
		for (int i = 0; i < twoDimensionalArray.length; i++) {
			System.out.println(Arrays.toString(twoDimensionalArray[i]));
		}

		// But, the other rows still have the same number of columns, so you
		// cannot access element or you will get an array index out of bounds
		// exception:
		// System.out.println(twoDimensionalArray[0][5]);
	}
}
