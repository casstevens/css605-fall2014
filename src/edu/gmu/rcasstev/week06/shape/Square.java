package edu.gmu.rcasstev.week06.shape;

/**
 * Notice how we created a class that does not need to implement any of the
 * methods of the Shape interface.
 * 
 * @author randy
 *
 */
public class Square extends Rectangle {

	public Square(String name, double width) {
		// Since a square has the same width and height
		super(name, width, width);
	}
}
