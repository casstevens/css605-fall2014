package edu.gmu.rcasstev.week07.assignment;

import java.util.List;

/**
 * Here is your assignment for Week 7:
 * 
 * DUE: Tuesday, October 14th at noon
 *
 * TASK 1: Copy AdvancedAgentData.java, Week7.java and Week7Test.java to your
 * own package following the same pattern as used above (i.e., replace rcasstev
 * with your username).
 * 
 * TASK 2: Implement the methods (addValueForAgent, getAgentsWithValues,
 * getFieldsWithValues, and getValuesForAgent) from the AdvancedAgentData
 * interface in the Week7 class.
 *
 * TASK 3: Make calls to these methods in the main method to make sure they are
 * producing the correct results.
 *
 * TASK 4: Run the unit tests in Week7Test.java to ensure your methods are
 * correct.
 * 
 * TASK 5: Email your version of Week7.java and any other supplementary class
 * files (hint: something like AgentEntry.java from the lecture notes may be
 * helpful) to rcasstev@gmu.edu
 * 
 */
public class Week7<A> implements AdvancedAgentData<A> {

	// Notice that we are using generics this week. For the unit test, any agent
	// class could be used to represent the agents, but for simplicity, I am
	// just using the String class to represent each of the agents.

	/**
	 * Stores the double value for the given agent and field. So, when the
	 * getValuesForAgent method is called, it will return the list of values
	 * associated with the provided agent and field.
	 * 
	 * @param agent
	 *            the agent that may have multiple attributes that we care about
	 *            storing (fields)
	 * @param field
	 *            the field that is being stored
	 * @param x
	 *            the value that is being stored during this method call
	 */
	@Override
	public void addValueForAgent(A agent, String field, double x) {

		// TODO: PLACEHOLDER - Your code goes here...

	}

	/**
	 * Returns a list of agent objects of type A that have values associated
	 * with any field.
	 * 
	 * @return
	 */
	@Override
	public List<A> getAgentsWithValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a list of fields of type String that have values associated with
	 * them.
	 * 
	 * @return
	 */
	@Override
	public List<String> getFieldsWithValues() {

		// TODO: PLACEHOLDER - Your code goes here...

		return null;
	}

	/**
	 * Returns a list of values that are associated with the agent and field
	 * input parameters.
	 * 
	 * @param agent
	 *            the agent associated with the list of values returned
	 * @param field
	 *            the field associated with the list of values returned
	 * @return
	 */
	@Override
	public List<Double> getValuesForAgent(A agent, String field) {

		// TODO: PLACEHOLDER - Your code goes here...

		return null;
	}

	public static void main(String[] args) {

		// TODO: PLACEHOLDER - Your code goes here...

	}
}
