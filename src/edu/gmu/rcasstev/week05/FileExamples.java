package edu.gmu.rcasstev.week05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Examples of how to read from and write to Files. There are multiple ways to
 * do this, but this is one of the simpler ways to do it.
 * 
 * Not discussed here, but you may also want to explore the Scanner class.
 * 
 * @author randy
 *
 */
public class FileExamples {

	public static void writeToFile(String filename, double[][] nums) {

		PrintWriter out = null;
		try {
			// Create a writer using the filename
			out = new PrintWriter(filename);

			// Iterate over all elements of nums
			for (int r = 0; r < nums.length; r++) {
				for (int c = 0; c < nums[r].length; c++) {

					// Print each element to file
					out.print(nums[r][c]);

					// If this isn't the last element, then separate values with
					// a comma
					if (c != nums[r].length - 1) {
						out.print(",");
					}
				}
				out.println();
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

	public static double[][] readFromFile(String filename) {
		BufferedReader in = null;
		double[][] retval = null;
		try {
			// A holder for the file contents (using a List because we do not
			// know how many rows there will be)
			List<double[]> rowList = new ArrayList<double[]>();

			// Create the reader for the filename
			in = new BufferedReader(new FileReader(filename));

			// While there is still another line, then parse it
			String nextLine = null;
			while ((nextLine = in.readLine()) != null) {

				// Split it up based on commas
				String[] splitStr = nextLine.split(",");

				// Create space for the values
				double[] row = new double[splitStr.length];

				// Parse the Strings into doubles
				for (int i = 0; i < splitStr.length; i++) {
					row[i] = Double.parseDouble(splitStr[i]);
				}

				// Add the row to the list
				rowList.add(row);
			}

			// Covert the List into an array
			retval = rowList.toArray(new double[rowList.size()][]);

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
		// Create a two dimensional array
		double[][] myNums = new double[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8 },
				{ 9, 10, 11, 12 } };

		// Print original data
		System.out.println("Original data");

		for (int r = 0; r < myNums.length; r++) {
			System.out.println(Arrays.toString(myNums[r]));
		}

		// Name of file that we will be reading from and writing to
		String filename = "myNums.txt";

		// Write the data to file
		writeToFile(filename, myNums);

		// Read the data from file
		double[][] myNumsFromFile = readFromFile(filename);

		System.out.println();

		// Print the data from file
		System.out.println("Data from file");

		for (int r = 0; r < myNumsFromFile.length; r++) {
			System.out.println(Arrays.toString(myNumsFromFile[r]));
		}
	}
}
