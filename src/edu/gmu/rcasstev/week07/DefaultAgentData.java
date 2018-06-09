package edu.gmu.rcasstev.week07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultAgentData<A> implements AgentData<A> {

	// Take note how I am defining and initializing the class attributes at the
	// same time. This can be a useful approach if your constructor does not
	// need any input parameters.

	// Used for storing the values for each agent
	private Map<A, List<Double>> agentToValueMap = new HashMap<A, List<Double>>();

	// Used for keep the order of the agents
	private List<A> agents = new ArrayList<A>();

	@Override
	public void addValueForAgent(A agent, double x) {

		// If there is no entry for this agent, then make one
		if (!agentToValueMap.containsKey(agent)) {
			agents.add(agent);
			agentToValueMap.put(agent, new ArrayList<Double>());
		}

		// Get the existing values for the agent
		List<Double> agentValues = agentToValueMap.get(agent);

		// Add the current value to the agent's values
		agentValues.add(x);
	}

	@Override
	public List<A> getAgentsWithValues() {
		// Don't let the list of agents be modified somewhere else
		return Collections.unmodifiableList(agents);
	}

	@Override
	public List<Double> getValuesForAgent(A agent) {
		// Don't let the list of agent values be modified somewhere else
		return Collections.unmodifiableList(agentToValueMap.get(agent));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (A agent : agents) {
			sb.append(agent + " has values: ");

			for (Double x : getValuesForAgent(agent)) {
				sb.append(x + ", ");
			}

			sb.append("\n");
		}

		return sb.toString();
	}
}
