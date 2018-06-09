package edu.gmu.rcasstev.week06.shape;

/**
 * This class must implement all of the methods of the Shape interface that
 * haven't been implemented already.
 * 
 * @author randy
 *
 */
public class Rectangle extends AbstractShape {

	private double width;

	private double height;

	public Rectangle(String name, double width, double height) {
		super(name);

		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2 * width + 2 * height;
	}
}
