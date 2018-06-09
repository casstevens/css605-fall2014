package edu.gmu.rcasstev.week06.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Week6Solution implements AgentData {

	private Map<Object, List<Double>> agentToValuesMap = new HashMap<Object, List<Double>>();

	private List<Object> agents = new ArrayList<Object>();

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

		// If you haven't seen this agent, then create a list for this agent
		if (agentToValuesMap.containsKey(agent) == false) {
			agents.add(agent);
			agentToValuesMap.put(agent, new ArrayList<Double>());
		}

		// Get any existing values for the agent
		List<Double> agentValues = agentToValuesMap.get(agent);

		// Add the current value
		agentValues.add(x);
	}

	/**
	 * Returns a list of agent Objects that have values associated with them.
	 * 
	 * @return
	 */
	@Override
	public List<Object> getAgentsWithValues() {

		// Return the agents with values
		return Collections.unmodifiableList(agents);
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
		
		// Get the list of values for the agent
		return Collections.unmodifiableList(agentToValuesMap.get(agent));
	}

	public static void main(String[] args) {

		// Create the instance
		AgentData agentData = new Week6Solution();

		// Make up a name for the agent
		String agentName = "Alvin";

		// Some values to associate with the agent
		double[] someVals = new double[] { 1.0, 2.0, 4.0, 8.0, 16.0 };

		// Add the values
		for (double x : someVals) {
			agentData.addValueForAgent(agentName, x);
		}
		
		// Print the results
		System.out.println("Agents with values: " + agentData.getAgentsWithValues());
		
		System.out.println("Agent values for Alvin: " + agentData.getValuesForAgent(agentName));

	}
}
