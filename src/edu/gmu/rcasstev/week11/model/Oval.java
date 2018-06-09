package edu.gmu.rcasstev.week11.model;

import java.awt.Graphics;
import java.awt.Point;

/**
 * An Oval Drawable.
 * 
 * @author randy
 *
 */
public class Oval extends Rectangle {

	public Oval(Point location, int width, int height) {
		super(location, width, height);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getLocation().x, getLocation().y, getWidth(), getHeight());
	}

	@Override
	public boolean contains(Point p) {

		Point upperLeft = getLocation();

		double centerX = upperLeft.x + getWidth() / 2.0;
		double centerY = upperLeft.y + getHeight() / 2.0;

		double rX = getWidth() / 2.0;
		double rY = getHeight() / 2.0;

		return Math.pow(p.x - centerX, 2) / (rX * rX)
				+ Math.pow(p.y - centerY, 2) / (rY * rY) <= 1;

	}
}
