package edu.gmu.rcasstev.week12.assignment;

public class ExampleAgent implements Agent {

	private int i;

	public ExampleAgent(int i) {
		this.i = i;
	}

	@Override
	public void step() {
		System.err.println("example agent " + i + " activated");
	}
}
