package edu.gmu.rcasstev.week03;

/**
 * Examples of two dimensional arrays of doubles.
 * 
 * @author randy
 *
 */
public class TwoDimensionalArrayExamples {

	public static void main(String[] args) {

		//
		// Create Two-dimensional Array
		//

		double[][] twoDimArray = new double[][] { { 1, 2, 3 }, { 4, 5, 6 } };

		// Iterate over the elements of the array
		// r is the row index
		// c is the column index
		for (int r = 0; r < twoDimArray.length; r++) {
			for (int c = 0; c < twoDimArray[r].length; c++) {
				// Print the element at row r and column c
				System.out.print(twoDimArray[r][c] + " ");
			}

			// Print a return after each row
			System.out.println();
		}

		// Say, we want to multiply all the elements by 2:
		for (int r = 0; r < twoDimArray.length; r++) {
			for (int c = 0; c < twoDimArray[r].length; c++) {
				// Multiply by two
				twoDimArray[r][c] = twoDimArray[r][c] * 2;
			}
		}
		
		System.out.println("After multiplying by two:");
		for (int r = 0; r < twoDimArray.length; r++) {
			for (int c = 0; c < twoDimArray[r].length; c++) {
				// Print the element at row r and column c
				System.out.print(twoDimArray[r][c] + " ");
			}

			// Print a return after each row
			System.out.println();
		}
	}
}
