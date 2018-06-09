package edu.gmu.rcasstev.week07;

public class AgentDataExamples {

	public static void main(String[] args) {
		
		// Using one example implementation
		AgentData<String> defaultAgentData = new DefaultAgentData<String>();
		String defaultAgent1 = "default agent1";
		
		for (double x = 0.0; x < 100.0; x += 16.0)
		{
			defaultAgentData.addValueForAgent(defaultAgent1, x);
		}
		
		String defaultAgent2 = "default agent2";
		
		for (double x = 0.0; x < 100.0; x += 24.0)
		{
			defaultAgentData.addValueForAgent(defaultAgent2, x);
		}
		
		// Using the other example implementation
		AgentData<String> agentEntryData = new AgentEntryData<String>();
		String agentEntryAgent = "agent entry agent";

		for (double x = 0.0; x <= 1024.0; x += 128.0)
		{
			agentEntryData.addValueForAgent(agentEntryAgent, x);
		}
		
		// Print both of the implementations
		System.out.println(defaultAgentData);	
		System.out.println(agentEntryData);
		
		// Add some more values to the default agent2
		for (double x = 0.0; x < 100.0; x += 12.0)
		{
			defaultAgentData.addValueForAgent(defaultAgent2, x);
		}
		
		// See how the values have changed
		System.out.println(defaultAgentData);
	}

}
