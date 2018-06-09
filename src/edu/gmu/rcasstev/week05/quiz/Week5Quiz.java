package edu.gmu.rcasstev.week05.quiz;

import java.util.Date;

/**
 * Answers for Week 5 Quiz.
 * 
 * @author randy
 *
 */
public class Week5Quiz {

	/**
	 * Tests whether the curDate lies between the start and end Dates.
	 * 
	 * @param curDate
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean someMethod(Date curDate, Date start, Date end) {
		if (end.before(start)) {
			throw new IllegalArgumentException("end is before start");
		}

		if (curDate.after(start) && curDate.before(end)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		//
		// Question 1
		//

		// Remember that the operators are executed from left to right

		int x = 10;
		int y = 20;

		System.out.println(x + y + " is x + y");

		//
		// Question 2
		//

		Date d1000 = new Date(1000);
		Date d2000 = new Date(2000);
		Date d3000 = new Date(3000);

		try {
			System.out.println("Method call 1: "
					+ someMethod(d2000, d1000, d3000));
			System.out.println("Method call 2: "
					+ someMethod(d1000, d2000, d3000));
			System.out.println("Method call 3: "
					+ someMethod(d2000, d3000, d1000));
		} catch (IllegalArgumentException e) {
			System.out.println("Exception thrown");
		}
	}
}
