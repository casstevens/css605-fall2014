package edu.gmu.rcasstev.week04;

/**
 * The Math class provides several useful methods for doing numeric operations.
 * 
 * @author randy
 *
 */
public class MathExamples {

	public static void main(String[] args) {

		// Some input values
		double x = 10;
		double y = -5;

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		System.out.println();

		//
		// Useful methods
		//

		System.out.println("Math.abs(x) = " + Math.abs(x));
		System.out.println("Math.abs(y) = " + Math.abs(y));
		System.out.println("Math.pow(x, 2) = " + Math.pow(x, 2));
		System.out.println("Math.pow(y, 2) = " + Math.pow(y, 2));
		System.out.println("Math.log(x) = " + Math.log(x));
		System.out.println("Math.log(y) = " + Math.log(y));
		System.out.println("Math.floor(x / 4.0) = " + Math.floor(x / 4.0));
		System.out.println("Math.floor(y / 2.0) = " + Math.floor(y / 2.0));
		System.out.println("Math.ceil(x / 4.0) = " + Math.ceil(x / 4.0));
		System.out.println("Math.ceil(y / 2.0) = " + Math.ceil(y / 2.0));
		System.out.println("Math.max(x, y) = " + Math.max(x, y));
		System.out.println("Math.min(x, y) = " + Math.min(x, y));
		System.out.println("Math.sin(x) = " + Math.sin(x));
		System.out.println("Math.sin(y) = " + Math.sin(y));

		System.out.println();

		//
		// Useful constants
		//

		System.out.println("Math.PI = " + Math.PI);
		System.out.println("Math.E = " + Math.E);
	}
}
