package edu.gmu.rcasstev.week06.quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Answers for Week 6 Quiz.
 * 
 * @author randy
 *
 */
public class Week6Quiz {

	public static void main(String[] args) {

		//
		// Question 1
		//

		List<Double> doubleList = new ArrayList<Double>();
		
		doubleList.add(1.0);
		doubleList.add(3.0);
		doubleList.add(2.0);
		
		// Print the values
		System.out.println(doubleList);

		//
		// Question 2
		//

		Set<Integer> integerSet = new HashSet<Integer>();
		
		integerSet.add(100);
		integerSet.add(200);
		integerSet.add(100);
		integerSet.add(400);
		
		// Print the values
		System.out.println(integerSet);

	}
}
