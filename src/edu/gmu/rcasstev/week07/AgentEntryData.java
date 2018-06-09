package edu.gmu.rcasstev.week07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentEntryData<A> implements AgentData<A> {

	private Map<A, AgentEntry<A>> agentEntriesMap = new HashMap<A, AgentEntry<A>>();

	private List<A> agents = new ArrayList<A>();

	@Override
	public void addValueForAgent(A agent, double x) {

		// If there is no entry for this agent, then make one
		if (!agentEntriesMap.containsKey(agent)) {
			agents.add(agent);
			agentEntriesMap.put(agent, new AgentEntry<A>(agent));
		}

		// Get the entry for the agent
		AgentEntry<A> agentEntry = agentEntriesMap.get(agent);

		// Get the existing values for the agent
		List<Double> agentValues = agentEntry.getValues();

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

		// Make sure the key exists to avoid a null pointer exception
		if (agentEntriesMap.containsKey(agent)) {
			// Don't let the list of agent values be modified somewhere else
			return Collections.unmodifiableList(agentEntriesMap.get(agent)
					.getValues());
		} else {
			// If the agent had no values added for it, then return null
			return null;
		}

		// The following does the same thing as above, but may be more confusing
		// return agentEntriesMap.containsKey(agent) ? Collections
		// .unmodifiableList(agentEntriesMap.get(agent).getValues())
		// : null;
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
