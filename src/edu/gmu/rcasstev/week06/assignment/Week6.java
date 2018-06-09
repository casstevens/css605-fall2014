package edu.gmu.rcasstev.week06.assignment;

import java.util.List;

/**
 * Here is your assignment for Week 6:
 * 
 * DUE: Tuesday, October 7th at noon
 *
 * TASK 1: Copy AgentData.java, Week6.java and Week6Test.java to your own
 * package following the same pattern as used above (i.e., replace rcasstev with
 * your username).
 * 
 * TASK 2: Implement the methods (addValueForAgent, getAgentsWithValues, and
 * getValuesForAgent) from the AgentData interface in the Week6 class.
 *
 * TASK 3: Make calls to these methods in the main method to make sure they are
 * producing the correct results.
 *
 * TASK 4: Run the unit tests in Week6Test.java to ensure your methods are
 * correct.
 * 
 * TASK 5: Email your version of Week6.java to rcasstev@gmu.edu
 * 
 */
public class Week6 implements AgentData {

	/**
	 * Stores the double value for the given agent. So, when the
	 * getValuesForAgent method is called, it will return the values that are
	 * associated with the provided agent Object.
	 * 
	 * @param agent
	 * @param x
	 */
	@Override
	public void addValueForAgent(Object agent, double x) {

		// TODO: PLACEHOLDER - Your code goes here...

	}

	/**
	 * Returns a list of agent Objects that have values associated with them.
	 * 
	 * @return
	 */
	@Override
	public List<Object> getAgentsWithValues() {

		// TODO: PLACEHOLDER - Your code goes here...

		return null;
	}

	/**
	 * Returns only the values that are associated with the agent input
	 * parameter.
	 * 
	 * @param agent
	 * @return
	 */
	@Override
	public List<Double> getValuesForAgent(Object agent) {

		// TODO: PLACEHOLDER - Your code goes here...

		return null;
	}

	public static void main(String[] args) {

		// TODO: PLACEHOLDER - Your code goes here...

	}
}
