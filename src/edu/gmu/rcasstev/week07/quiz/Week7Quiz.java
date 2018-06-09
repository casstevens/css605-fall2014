package edu.gmu.rcasstev.week07.quiz;

/**
 * Answers for Week 7 Quiz.
 * 
 * @author randy
 *
 */
public class Week7Quiz {

	public static void main(String[] args) {

		//
		// Question 1
		//

		Parent p = new Parent();
		Child1 c1 = new Child1();
		Child2 c2 = new Child2();
		Parent pToC = new Child1();

		p.someMethod();
		c1.someMethod();
		c2.someMethod();
		pToC.someMethod();

		//
		// Question 2
		//

		p.someOtherMethod();
		c1.someOtherMethod();
		c2.someOtherMethod();
		pToC.someOtherMethod();
	}
}
