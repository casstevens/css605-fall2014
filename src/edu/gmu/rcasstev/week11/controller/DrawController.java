package edu.gmu.rcasstev.week11.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import edu.gmu.rcasstev.week11.model.DrawModel;
import edu.gmu.rcasstev.week11.model.Drawable;
import edu.gmu.rcasstev.week11.model.Line;
import edu.gmu.rcasstev.week11.model.Oval;
import edu.gmu.rcasstev.week11.model.Rectangle;

/**
 * Controller for creating new Drawables.
 * 
 * @author randy
 *
 */
public class DrawController implements MouseListener {

	private DrawModel drawModel;

	private DrawMode drawMode = DrawMode.RECTANGLE;

	private Point previousPoint;

	public DrawController(DrawModel drawModel) {
		this.drawModel = drawModel;
	}

	public void setDrawMode(DrawMode drawMode) {
		this.drawMode = drawMode;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// If the user is trying to erase some objects
		if (drawMode.equals(DrawMode.ERASE)) {

			List<Drawable> toBeErased = new ArrayList<Drawable>();

			// Check to see which objects need to be erased
			for (Drawable d : drawModel.getDrawableList()) {
				if (d.contains(e.getPoint())) {
					toBeErased.add(d);
				}
			}

			drawModel.removeDrawables(toBeErased);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		previousPoint = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (previousPoint != null) {
			Point curPoint = e.getPoint();

			Drawable newDrawable = null;

			int width = Math.abs(curPoint.x - previousPoint.x);
			int height = Math.abs(curPoint.y - previousPoint.y);

			if (drawMode.equals(DrawMode.RECTANGLE)) {

				newDrawable = new Rectangle(previousPoint, width, height);

			} else if (drawMode.equals(DrawMode.OVAL)) {

				newDrawable = new Oval(previousPoint, width, height);

			} else if (drawMode.equals(DrawMode.LINE)) {

				newDrawable = new Line(previousPoint, curPoint);
			}

			previousPoint = null;

			if (newDrawable != null) {
				drawModel.addDrawable(newDrawable);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Do nothing for now...

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Do nothing for now...

	}
}
