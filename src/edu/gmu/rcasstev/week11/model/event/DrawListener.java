package edu.gmu.rcasstev.week11.model.event;

import java.util.EventListener;

/**
 * If you want to listen for when new Drawables are created, then implement this
 * listener and add your listener to the DrawModel.
 * 
 * @author randy
 *
 */
public interface DrawListener extends EventListener {

	public void objectDrawn(DrawEvent drawEvent);

}
