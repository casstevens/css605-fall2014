package edu.gmu.rcasstev.week06.shape;

/**
 * Since this class is labeled as an abstract class, then we cannot create an
 * instance of this class. Making the class abstract also has the benefit that
 * you are not required to provide implementations for all of the methods in any
 * interfaces that you implement (e.g., Shape).
 * 
 * By default, if you class does not state what it extends, then it
 * automatically extends Object. The Object class is at the top of the entire
 * Java class hierarchy.
 * 
 * @author randy
 *
 */
public abstract class AbstractShape /* extends Object */implements Shape {

	protected String name;

	public AbstractShape(String name) {
		this.name = name;
	}

	/**
	 * We can provide implementations for the methods that we can.
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is being overridden from the Object class and makes it easier
	 * to print out Objects in a human readable way.
	 * 
	 */
	public String toString() {
		return getClass().getSimpleName() + " named " + name + " has area of "
				+ getArea() + " and perimeter of " + getPerimeter() + ".";
	}
}
