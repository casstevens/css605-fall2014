package edu.gmu.rcasstev.week06.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Just some examples of running the Shape code.
 * 
 * @author randy
 *
 */
public class ShapeExamples {

	public static void someMethodUsingShape(Shape s) {

	}

	public static void main(String[] args) {

		// Create some instances of Shapes
		Circle circle = new Circle("Cece", 1.0);
		Rectangle rectangle = new Rectangle("Rick", 4.0, 3.0);
		Square square = new Square("Stew", 5.0);

		// A method that takes a Shape as input will also work for an instance
		// that implements Shape.
		someMethodUsingShape(circle);

		// This List can hold all of the instances that implement Shape
		List<Shape> shapes = new ArrayList<Shape>();

		shapes.add(circle);
		shapes.add(rectangle);
		shapes.add(square);

		// Print the info about the Shapes (the toString method is being called,
		// which is defined in the AbstractShape class)
		for (Shape s : shapes) {
			System.err.println(s);
		}
	}
}
