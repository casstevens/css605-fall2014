package edu.gmu.rcasstev.week07.quiz;

public class Parent {

	protected double x = 10.0;

	public void someMethod() {
		System.err.println("someMethod in Parent");
	}

	public void someOtherMethod() {
		System.err.println("someOtherMethod in Parent, x = " + x);
	}
}
