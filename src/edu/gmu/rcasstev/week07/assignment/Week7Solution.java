package edu.gmu.rcasstev.week07.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Week7Solution<A> implements AdvancedAgentData<A> {

	// Notice that we are using generics this week. For the unit test, any agent
	// class could be used to represent the agents, but for simplicity, I am
	// just using the String class to represent each of the agents.

	private Map<A, AgentEntry<A>> agentEntriesMap = new HashMap<A, AgentEntry<A>>();

	private List<A> agents = new ArrayList<A>();

	private List<String> fields = new ArrayList<String>();

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

		// If there is no entry for this agent, then make one
		if (agentEntriesMap.containsKey(agent) == false) {
			agents.add(agent);
			agentEntriesMap.put(agent, new AgentEntry<A>(agent));
		}

		// Check to see if we have seen this field
		if (fields.contains(field) == false) {
			fields.add(field);
		}

		// Get the entry for the agent
		AgentEntry<A> agentEntry = agentEntriesMap.get(agent);

		// Store the value in the agent's entry
		agentEntry.addValue(field, x);
	}

	/**
	 * Returns a list of agent objects of type A that have values associated
	 * with any field.
	 * 
	 * @return
	 */
	@Override
	public List<A> getAgentsWithValues() {
		return Collections.unmodifiableList(agents);
	}

	/**
	 * Returns a list of fields of type String that have values associated with
	 * them.
	 * 
	 * @return
	 */
	@Override
	public List<String> getFieldsWithValues() {
		return Collections.unmodifiableList(fields);
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

		// Make sure the key exists to avoid a null pointer exception
		if (agentEntriesMap.containsKey(agent)) {
			// Don't let the list of agent values be modified somewhere else
			AgentEntry<A> entry = agentEntriesMap.get(agent);

			List<Double> values = entry.getValues(field);

			if (values == null) {
				return null;
			}

			return Collections.unmodifiableList(values);
		} else {
			// If the agent had no values added for it, then return null
			return null;
		}
	}

	public static void main(String[] args) {

		AdvancedAgentData<String> agentData = new Week7Solution<String>();
		
		// Create some data for the agent Alice
		agentData.addValueForAgent("Alice", "sugar", 4);
		agentData.addValueForAgent("Alice", "sugar", 5);
		agentData.addValueForAgent("Alice", "sugar", 6);
		
		agentData.addValueForAgent("Alice", "spice", 9);
		agentData.addValueForAgent("Alice", "spice", 8);
		agentData.addValueForAgent("Alice", "spice", 6);
		
		// Create some data for the agent Ben
		agentData.addValueForAgent("Ben", "sugar", 8);
		agentData.addValueForAgent("Ben", "sugar", 8);
		
		agentData.addValueForAgent("Ben", "spice", 1);
		agentData.addValueForAgent("Ben", "spice", 2);

		// Print the data to console
		System.out.println("Alice had sugar values: " + agentData.getValuesForAgent("Alice", "sugar"));
		System.out.println("Alice had spice values: " + agentData.getValuesForAgent("Alice", "spice"));
		System.out.println("Ben had sugar values: " + agentData.getValuesForAgent("Ben", "sugar"));
		System.out.println("Ben had spice values: " + agentData.getValuesForAgent("Ben", "spice"));
	}
}
