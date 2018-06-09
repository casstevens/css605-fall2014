package edu.gmu.rcasstev.week06.shape;

/**
 * This class must implement all of the methods of the Shape interface that
 * haven't been implemented already.
 * 
 * @author randy
 *
 */
public class Circle extends AbstractShape {

	double radius;

	public Circle(String name, double radius) {
		// Let the super class take care of the name
		super(name);

		// Notice how you need the this. in front of the instance variable.
		// The radius without the this. is referring to the input parameter.
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

}
