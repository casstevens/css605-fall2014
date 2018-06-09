package edu.gmu.rcasstev.week02;

/**
 * Loops allow you to run the same block of code multiple times.
 * 
 * @author randy
 *
 */
public class LoopExamples {

	public static void main(String[] args) {

		//
		// While loop
		//

		// While loops check a conditional and then keep running the code block
		// as long as the conditional is true.

		// Examples adapted from:
		// http://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html

		int count = 1;
		while (count < 11) {
			System.out.println("While loop: Count is: " + count);
			count++;
		}

		//
		// Do-while loop
		//

		// The do-while loop differs from the while loop in that it evaluates
		// the conditional at the end of the code block rather than the start.

		count = 1;
		do {
			System.out.println("Do-while loop: Count is: " + count);
			count++;
		} while (count < 11);

		// In the do-while loop the code block will always be executed at least
		// once because the conditional isn't evaluated until the end, but in
		// the while loop the code block may not execute at all.
		// QUESTION: How would the two loops differ if count was set to 11
		// instead of 1 at the beginning of each loop?

		// IMPORTANT: It can be easy to create a while or do-while loop that
		// will never stop running (i.e., where the conditional always evaluates
		// to true and therefore doesn't stop looping).

		//
		// For loop
		//

		// Examples adapted from:
		// http://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html

		// Iterating over a range of values is a common piece of code, so a for
		// loop allows you to do that.

		// The following for loop does the same thing as the previous while
		// loop, but is a bit more compact.

		for (int i = 1; i < 11; i++) {
			System.out.println("For loop: Count is: " + i);
		}

		// Let's take a closer look at the for loop. Inside the parenthesis,
		// there is an initialization, followed by a conditional, and ends with
		// an update. The initialization happens only at the beginning. The
		// conditional is evaluated before each execution of the code block. The
		// updating code is executed after each time the code block is executed.

		//
		// For loop to iterate over an array
		//

		// For loops can also be used to iterate over the elements of an array

		// You can do the following:

		int[] nums = new int[] { 10, 20, 30, 40, 50, 60, 70, 80 };

		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			System.out.println("For loop: iterate over array: " + n);
		}

		// You can also do it this way:

		for (int n : nums) {
			System.out.println("For loop: iterate over array (2nd way): " + n);
		}
	}

}
