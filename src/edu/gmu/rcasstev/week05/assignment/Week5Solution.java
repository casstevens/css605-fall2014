package edu.gmu.rcasstev.week05.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Here is your assignment for Week 5:
 * 
 * DUE: September 29th at noon
 *
 * TASK 1: Copy Week5.java and Week5Test.java to your own package following the
 * same pattern as used above (i.e., replace rcasstev with your username).
 * 
 * TASK 2: Implement the writeDataToFile and readDataFromFile methods.
 *
 * TASK 3: Make calls to these methods in the main method to make sure they are
 * producing the correct results.
 *
 * TASK 4: Run the unit tests in Week5Test.java to ensure your methods are
 * correct.
 * 
 * TASK 5: Email your version of Week5.java to rcasstev@gmu.edu
 * 
 */
public class Week5Solution {

	/**
	 * Write the List of Strings to a file.
	 * 
	 * @param filename
	 *            the name of the file to write the Strings to
	 * @param stringList
	 *            the List of Strings to write to file
	 */
	public static void writeDataToFile(String filename, List<String> stringList) {

		PrintWriter out = null;
		try {
			// Create a writer using the filename
			out = new PrintWriter(filename);

			// Iterate over all Strings
			for (String s : stringList) {
				out.println(s);
			}

		} catch (FileNotFoundException e) {
			// Just print the error
			e.printStackTrace();
		} finally {
			// Make sure to close the file
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * Read the List of Strings from a file.
	 * 
	 * @param filename
	 *            the name of the file to read the Strings from
	 * @return the List of Strings read from the file
	 */
	public static List<String> readDataFromFile(String filename) {

		BufferedReader in = null;
		List<String> retval = null;

		try {
			retval = new ArrayList<String>();

			// Create the reader for the filename
			in = new BufferedReader(new FileReader(filename));

			// While there is still another line, then parse it
			String nextLine = null;
			while ((nextLine = in.readLine()) != null) {
				retval.add(nextLine);
			}
		} catch (FileNotFoundException e) {
			// Just print the error
			e.printStackTrace();
		} catch (IOException e) {
			// Just print the error
			e.printStackTrace();
		} finally {
			// Make sure to close the file
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// Just print the error
					e.printStackTrace();
				}
			}
		}

		return retval;
	}

	public static void main(String[] args) {

		// Strings to be written to file
		List<String> someStrings = new ArrayList<String>();
		
		someStrings.add("some");
		someStrings.add("strings");
		someStrings.add("to");
		someStrings.add("test");
		someStrings.add("out");
		someStrings.add("the");
		someStrings.add("methods");

		// File to write to and read from
		String filename = "temp_week5.txt";
		
		// Write file
		writeDataToFile(filename, someStrings);

		// Read file
		List<String> someStringsFromFile = readDataFromFile(filename);
		
		// Print what was read from file
		System.out.println(someStringsFromFile);
	}

}
