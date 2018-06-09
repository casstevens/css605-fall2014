package edu.gmu.rcasstev.week03;

import java.util.Arrays;

/**
 * Some examples of using Strings in Java. A String is simply a sequence of
 * characters.
 * 
 * @author randy
 *
 */
public class StringExamples {

	public static void main(String[] args) {

		//
		// Creating Strings
		//

		// Creating and initializing a String variable
		String s1 = "hello";

		// You can also call the constructor using the 'new' keyword
		String s2 = new String("there");

		//
		// String Concatenation
		//

		// You can concatenate two strings using the + operator
		System.out.println(s1 + s2);

		// The above doesn't not include a space between the two strings, so we
		// can do this:
		System.out.println(s1 + " " + s2);

		// Or to add a tab between the two Strings
		System.out.println(s1 + "\t" + s2);

		// null is just a placeholder if the Object hasn't been created yet.
		// If you try to use the variable that is set to null, you will most
		// likely get a NullPointerException.
		String sNull = null;

		System.out
				.println("If you want to create the variable without initializing it, then you can set it to null: "
						+ sNull);

		//
		// Splitting a String into pieces
		//

		// Say we have a String with multiple values divided by the tab
		// character
		String numStr = "1 \t 2 \t 3 \t 4";

		// We can split the String up using the split method
		String[] numStrSplitAtTab = numStr.split("\t");

		// Notice how . operator (pronounced the 'dot' operator), a String is an
		// Object and the dot operator is how we access the methods inside an
		// Object.

		// Let's print the result
		System.out.println(Arrays.toString(numStrSplitAtTab));

		// But, we are still not able to do mathematical operations with the
		// String array, so continue to the NumberExamples to see how to convert
		// this String array into an array of numbers.

		// Other useful methods:
		String someStr = "  some     string   ";

		System.out.println("Original string: " + someStr);
		System.out.println("Remove whitespace from ends of String: "
				+ someStr.trim());
		System.out.println("Make String all lower case: "
				+ someStr.toLowerCase());
		System.out.println("Make String all upper case: "
				+ someStr.toUpperCase());
		System.out.println("Get a substring from the String: "
				+ someStr.substring(2, 6)); // <- some
		System.out.println("Contains another String: "
				+ someStr.contains("some"));
	}

}
