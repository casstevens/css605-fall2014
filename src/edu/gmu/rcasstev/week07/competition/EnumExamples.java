package edu.gmu.rcasstev.week07.competition;

import edu.gmu.rcasstev.competition.gametheory.GamePayoffs;

/**
 * An enum allows you to defined a set of predefined constants. For example, it
 * is used in the first competition for the semester.
 * 
 * @author randy
 *
 */
public class EnumExamples {

	public static void main(String[] args) {

		//
		// Used within an if statement
		//
		
		GamePayoffs gamePayoffs = GamePayoffs.PRISONERS_DILEMMA;

		if (gamePayoffs.equals(GamePayoffs.PRISONERS_DILEMMA)) {
			System.out.println("Game is Prisoner's Dilemma");
		} else if (gamePayoffs.equals(GamePayoffs.STAG_HUNT)) {
			System.out.println("Game is Stag Hunt");
		} else if (gamePayoffs.equals(GamePayoffs.HAWK_DOVE)) {
			System.out.println("Game is Hawk-Dove");
		}
		
		//
		// Used within a switch statement
		//

		gamePayoffs = GamePayoffs.STAG_HUNT;

		switch (gamePayoffs) {
		case PRISONERS_DILEMMA:
			System.out.println("Game is Prisoner's Dilemma");
			break;
		case STAG_HUNT:
			System.out.println("Game is Stag Hunt");
			break;
		case HAWK_DOVE:
			System.out.println("Game is Hawk-Dove");
			break;
		}
	}
}
