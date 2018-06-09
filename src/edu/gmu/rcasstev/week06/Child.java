package edu.gmu.rcasstev.week06;

public class Child extends Parent {

	// An example of a constant
	public static final double CONSTANT_VALUE = 100.0;

	// The Child can also introduce other attributes
	private double childAttribute;

	/**
	 * Constructor for creating a Child.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Child(double x, double y, double z, double a) {
		// Calls the constructor of the Parent
		super(x, y, z);

		childAttribute = a;
	}

	public Child(double x, double y, double z) {
		// Calls the constructor above (the Child constructor with four inputs)
		// Provides a default value for the last input parameter (default value
		// is 0).
		this(x, y, z, 0);
	}

	/**
	 * Method for showing the visibility of the various attributes in the
	 * Parent.
	 * 
	 * This method also overrides a method by the same name in the Parent.
	 * 
	 */
	@Override
	public void someMethod() {
		// Everyone has access to the public attributes
		double x = publicAttribute;

		// But, Child also can access protected attributes in the Parent
		x = protectedAttribute;

		// But, not the private attributes
		// x = privateAttribute;

		System.err.println("someMethod in Child");
	}

}
