package edu.gmu.rcasstev.week07;

import java.util.ArrayList;
import java.util.List;

public class AgentEntry<A> {

	// The following reference to the agent isn't used now, but could be useful
	// in a future lecture.
	private A agent;

	private List<Double> values;

	public AgentEntry(A agent) {
		this.agent = agent;
		this.values = new ArrayList<Double>();
	}

	public List<Double> getValues() {
		return values;
	}
}
