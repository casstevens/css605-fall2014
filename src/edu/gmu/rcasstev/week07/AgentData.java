package edu.gmu.rcasstev.week07;

import java.util.List;

/**
 * Simple interface for storing data about a group of agents (using generics).
 * Using generics, this class is a type safe way of reusing this class for a
 * variety of agent implementations.
 * 
 * @author randy
 *
 */
public interface AgentData<A> {

	/**
	 * Stores the double value for the given agent. So, when the
	 * getValuesForAgent method is called, it will return the values that are
	 * associated with the provided agent.
	 * 
	 * @param agent
	 * @param x
	 */
	void addValueForAgent(A agent, double x);

	/**
	 * Returns a list of agents of type A that have values associated with them.
	 * 
	 * @return
	 */
	List<A> getAgentsWithValues();

	/**
	 * Returns only the values that are associated with the agent input
	 * parameter.
	 * 
	 * @param agent
	 * @return
	 */
	List<Double> getValuesForAgent(A agent);
}
