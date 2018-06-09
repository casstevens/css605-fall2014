package edu.gmu.rcasstev.week06;

public class Parent {

	/**
	 * General rule of thumb:
	 * 
	 * Attributes are generally private and methods are generally public, but
	 * this is not always to case.
	 */

	/**
	 * Also, take note that this is used only for demonstration purposes. In
	 * general, attribute variable names do not start with their visibility.
	 */

	/**
	 * Attributes can also be of any type. Here for simplicity, I am just
	 * showing attributes of type double.
	 */

	// Not visible by Child
	private double privateAttribute;

	// Visible by Child
	protected double protectedAttribute;

	// Visible by anyone
	public double publicAttribute;

	// Static attributes only have one value per class, but non-static
	// attributes can have a different value for each instance of the class.
	public static double staticAttribute;

	/**
	 * This is a constructor that is called when the following is called:
	 * 
	 * Parent p = new Parent(1,2,3);
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Parent(double x, double y, double z) {
		privateAttribute = x;
		protectedAttribute = y;
		publicAttribute = z;
	}

	/**
	 * By making the attribute private, we can control the access to the value.
	 * 
	 * @return
	 */
	public double getPrivateAttribute() {
		return privateAttribute;
	}

	/**
	 * Controlling access is particularly important when allowing attribute
	 * values to be changed.
	 * 
	 * @param newVal
	 */
	public void setPrivateAttribute(double newVal) {
		privateAttribute = newVal;
	}

	/**
	 * Private methods are only visible from inside the class and can be useful
	 * for breaking out a procedure that would either not be useful to other
	 * classes or you do not want to be available to other classes.
	 */
	private void setPrivateAttributeToZero() {
		privateAttribute = 0;
	}

	/**
	 * Just prints a message, but this method is going to be overridden by the
	 * Child.
	 */
	public void someMethod() {
		System.err.println("someMethod in Parent");
	}
}
