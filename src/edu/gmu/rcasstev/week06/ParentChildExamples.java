package edu.gmu.rcasstev.week06;

public class ParentChildExamples {

	public static void main(String[] args) {

		Parent p = new Parent(1, 2, 3);
		Child c = new Child(4, 5, 6);

		System.err.println("Calling someMethod on p and c");
		p.someMethod();
		c.someMethod();

		// A Parent reference can also refer to a Child instance
		Parent pToC = new Child(7, 8, 9);

		// This will call the method defined in the Child class
		System.err.println("\nCalling someMethod on pToC");
		pToC.someMethod();

		// But, not the other way around
		// Child cToP = new Parent(10, 11, 12); // this causes an error

		// This previous line does not work because Child extends a Parent, but
		// the Parent does not extend the Child. The cToP is trying to reference
		// a Child, but the Parent instance is not a Child instance.

		// To expand on this a bit, let's look at having a Object reference to a
		// Parent and Child instance:
		Object oToP = new Parent(-1, -2, -3);
		Object oToC = new Child(-4, -5, -6);

		// The Java compiler has no problems with the previous two lines,
		// although since you are using an Object reference, only methods
		// defined in the Object class can be referenced! So, the following does
		// not work:
		// oToP.someMethod();
		// oToC.someMethod();

		//
		// THE MAIN LESSON OF THIS EXAMPLE IS ABOVE
		//
		// The problem with casting instances to other types is covered in the
		// remainder of this example if you are interested.
		//

		// Bad Programming Practice:
		// To make it work, you must cast the instance to the class that defines
		// the method:
		System.err.println("\nCalling someMethod on oToP and oToC");
		((Parent) oToP).someMethod();
		((Child) oToC).someMethod();

		// Or:
		((Parent) oToC).someMethod();

		// What makes this so bad? The compiler cannot do type checking at
		// compile time and runs the risk of generating an error at run time.
		// For example, this statement has no syntax errors:
		Object oToS = new String("some string");

		// And the following statement is also a syntactically correct
		// statement, but generates an error at run time because you are trying
		// to cast the instance to a type that it is not:
		// ((Parent) oToS).someMethod();

		// Good Programming Practice:
		// Avoid casting because it doesn't let the compiler help you find bugs
		// earlier rather than later. When choosing the type of a variable, make
		// it the type that has all of the methods that you need available to
		// you without any casting.
	}
}
