package edu.gmu.rcasstev.week07.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentEntry<A> {

	// The following reference to the agent isn't used now, but could be useful
	// in a future lecture.
	private A agent;

	private Map<String, List<Double>> fieldToValuesMap;

	public AgentEntry(A agent) {
		this.agent = agent;
		this.fieldToValuesMap = new HashMap<String, List<Double>>();
	}

	public void addValue(String field, Double value) {
		// Create a list for this field if it doesn't exist
		if (fieldToValuesMap.containsKey(field) == false) {
			fieldToValuesMap.put(field, new ArrayList<Double>());
		}
		
		List<Double> values = fieldToValuesMap.get(field);

		values.add(value);
	}

	public List<Double> getValues(String field) {
		return fieldToValuesMap.get(field);
	}
}
