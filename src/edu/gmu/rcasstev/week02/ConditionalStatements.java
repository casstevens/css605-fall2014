package edu.gmu.rcasstev.week02;

/**
 * Conditional statements allows you to choose what code gets executed based on
 * the result of a conditional (i.e., a expression that returns a boolean).
 * 
 * @author randy
 *
 */
public class ConditionalStatements {

	public static void main(String[] args) {

		//
		// If statements
		//

		int x = 10;

		// A simple example of a conditional statement
		if (x > 5) {
			System.out.println("x is greater than five");
		}

		// You can also include an else clause
		if (x > 10) {
			System.out.println("x is greater than ten");
		} else {
			System.out.println("x is NOT greater than ten");
		}

		// You can also have multiple conditions
		if (x > 20) {
			System.out.println("x is greater than twenty");
		} else if (x > 5) {
			System.out
					.println("x is greater than five, but not greater than twenty");
		} else {
			System.out.println("x is NOT greater than five");
		}

		// Also, you can have an if and else in a single line of code:
		int y = x > 5 ? 1 : 0;

		System.out.println("y is: " + y);

		// The line above says if x is greater than five, then set y to 1,
		// otherwise set y to 0.

		// GOOD CODING PRACTICE:
		// Only use the above technique if the conditional is simple, otherwise
		// it is easy to create code that difficult to understand.

		//
		// Switch statement
		//

		// Following example taken from:
		// http://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html

		// A switch statement may be more readable, then lots of if statements.
		// Depending on the value of the variable in the switch (in this case,
		// the month variable), will determine which case or cases get executed.

		int month = 8;
		String monthString;
		switch (month) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		System.out.println(monthString);

		// IMPORTANT: Notice the break in each case!
		// The default behavior for a switch statement finds the case to start
		// at and then continue to the end, UNLESS you get to a break which
		// breaks you out of the switch.

		// GOOD CODING PRACTICE: Most of the time when using a switch statement,
		// you want to include a break at the end of each case.
	}

}
