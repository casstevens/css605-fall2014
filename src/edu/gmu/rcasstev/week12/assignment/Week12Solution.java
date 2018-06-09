package edu.gmu.rcasstev.week12.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ec.util.MersenneTwisterFast;

/**
 * Here is your assignment for Week 12:
 * 
 * DUE: Tuesday, November 18th at noon
 *
 * TASK 1: Copy Agent.java, Schedule.java, Week12.java and Week12Test.java to
 * your own package following the same pattern as used above (i.e., replace
 * rcasstev with your username).
 * 
 * TASK 2: Implement the methods (schedule, stepSameOrder, and stepRandomOrder)
 * from the Schedule interface in the Week12 class.
 *
 * TASK 3: Make calls to these methods in the main method to make sure they are
 * producing the correct results.
 *
 * TASK 4: Run the unit tests in Week12Test.java to ensure your methods are
 * correct.
 * 
 * TASK 5: Email your version of Week12.java to rcasstev@gmu.edu
 * 
 */
public class Week12Solution implements Schedule {

	private List<Agent> agents = new ArrayList<Agent>();

	private int nextAgent = 0;

	/**
	 * Schedule the Agent for activation in the future.
	 * 
	 */
	@Override
	public void schedule(Agent a) {
		agents.add(a);
	}

	/**
	 * Steps through the agents in the same order as they were added to the
	 * Schedule.
	 * 
	 */
	@Override
	public void stepSameOrder() {

		if (agents.isEmpty()) {
			return;
		}

		if (nextAgent >= agents.size()) {
			nextAgent = 0;
		}

		agents.get(nextAgent).step();

		nextAgent++;
		nextAgent = nextAgent % agents.size();
	}

	/**
	 * Steps through the agents in an random order.
	 * 
	 */
	@Override
	public void stepRandomOrder() {

		// First way of getting random index
		int agentIndex = (int) (Math.random() * agents.size());

		// Second way
		Random r = new Random();
		int agentIndex2 = r.nextInt(agents.size());

		// Third way
		MersenneTwisterFast random = new MersenneTwisterFast();
		int agentIndex3 = random.nextInt(agents.size());

		// But only need one index, so call the step method on the first index
		// that was randomly chosen. The other randomly chosen indices are just
		// here for demonstration.
		agents.get(agentIndex).step();
	}

	public static void main(String[] args) {

		// Create a schedule
		Week12Solution schedule = new Week12Solution();

		// In order to schedule an Agent, you need a class that implements the
		// Agent interface.

		// You could do this with an anonymous inner class, which can be a bit
		// confusing
		for (int i = 0; i < 5; i++) {
			final int j = i;
			schedule.schedule(new Agent() {
				@Override
				public void step() {
					System.err.println("anonymous inner class agent " + j
							+ " activated");
				}
			});
		}

		// The more straightforward way would create another class that
		// implements Agent
		for (int i = 5; i < 10; i++) {
			schedule.schedule(new ExampleAgent(i));
		}

		// Step through schedule in same order
		System.err.println("Step through the schedule in same order");
		for (int i = 0; i < 10; i++) {
			schedule.stepSameOrder();
		}
		System.err.println();

		// Step through schedule in random order
		System.err.println("Step through the schedule in random order");
		for (int i = 0; i < 10; i++) {
			schedule.stepRandomOrder();
		}
	}

}
