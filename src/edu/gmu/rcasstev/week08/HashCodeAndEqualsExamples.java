package edu.gmu.rcasstev.week08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Examples of how the equals and hashCode methods work.
 * 
 * @author randy
 *
 */
public class HashCodeAndEqualsExamples {

	public static void main(String[] args) {

		//
		// The equals method
		//

		// This class does not include an implementation of the hashCode and
		// equals methods, but relies on the default implementation provided by
		// the Object class.
		ObjectWithoutEquals noEquals = new ObjectWithoutEquals(1, 10.0);

		// This class includes an implementation of hashCode and equals
		ObjectWithEquals withEquals = new ObjectWithEquals(1, 10.0);

		// Of course, these two instances are not going to be equal because they
		// are instances of two different classes.
		System.out.println("Two instances of difference classes, equal?: "
				+ withEquals.equals(noEquals));
		System.out.println("Two instances of difference classes, equal?: "
				+ noEquals.equals(withEquals));
		System.out.println();

		// Now, let's create two more instances of these classes using the same
		// input parameters.
		ObjectWithoutEquals noEquals2 = new ObjectWithoutEquals(1, 10.0);
		ObjectWithEquals withEquals2 = new ObjectWithEquals(1, 10.0);

		System.out.println("Two instances of ObjectWithoutEquals, equal?: "
				+ noEquals.equals(noEquals2));
		System.out.println("Two instances of ObjectWithEquals, equal?: "
				+ withEquals.equals(withEquals2));
		System.out.println();

		// If you do not implement the equals method, then equals only returns
		// true if the two variables are referring to the same instance.

		System.out.println("Same instance of ObjectWithoutEquals, equal?: "
				+ noEquals.equals(noEquals));
		System.out.println("Same instance of ObjectWithEquals, equal?: "
				+ withEquals.equals(withEquals));
		System.out.println();

		// Of course, the exact same instance should be equal to itself.

		// Also, the == operator checks if the instance on the left and right of
		// the operator are referencing the same instance.
		System.out.println("Two instances of ObjectWithoutEquals, ==: "
				+ (noEquals == noEquals2));
		System.out.println("Two instances of ObjectWithEquals, ==: "
				+ (withEquals == withEquals2));
		System.out.println();
		// Which in this case, they are not.

		//
		// How the equals method is used in Collections
		//

		// The behavior of the equals method can influence how other things work
		// in Java.
		// For example, if these instances where included in a Collection:
		List<ObjectWithoutEquals> noEqualsList = new ArrayList<ObjectWithoutEquals>();
		List<ObjectWithEquals> withEqualsList = new ArrayList<ObjectWithEquals>();

		// Add the first two instances that we created earlier:
		noEqualsList.add(noEquals);
		withEqualsList.add(withEquals);

		// If we check if the list contains the other instance that we created
		// earlier:
		System.out.println("List of ObjectWithoutEquals, contains?: "
				+ noEqualsList.contains(noEquals2));
		System.out.println("List of ObjectWithEquals, contains?: "
				+ withEqualsList.contains(withEquals2));
		System.out.println();

		// The class with no equals method says that it does not contain the
		// instance even though there is an instance with the same parameters in
		// the List.

		// The class with an equals method does contain the instance as
		// expected.

		// So, if you try to use the values as keys in a Map:
		Map<ObjectWithoutEquals, Double> noEqualsMap = new HashMap<ObjectWithoutEquals, Double>();
		noEqualsMap.put(noEquals, 10.0);
		noEqualsMap.put(noEquals2, 20.0);

		Map<ObjectWithEquals, Double> withEqualsMap = new HashMap<ObjectWithEquals, Double>();
		withEqualsMap.put(withEquals, 10.0);
		withEqualsMap.put(withEquals2, 20.0);

		// Then the Map using the class with the default equals method
		// will contain two keys and two values, while the Map using the class
		// with an equals method will only have one key and one value
		// (because it knows that the two keys are equal).
		System.out.println("Map using ObjectWithoutEquals: " + noEqualsMap);
		System.out.println("Map using ObjectWithEquals: " + withEqualsMap);
		System.out.println();

		//
		// The hashCode method
		//

		// Another method used by Collections is the hashCode method. If the
		// equals method says that two instances are equal, then the hashCode
		// method should generate the same int.

		// The hashCode value is used in Maps
		System.out.println("Two instances of ObjectWithoutEquals, hashCodes?: "
				+ noEquals.hashCode() + " and " + noEquals2.hashCode());
		System.out.println("Two instances of ObjectWithEquals, hashCodes?: "
				+ withEquals.hashCode() + " and " + withEquals2.hashCode());
		System.out.println();

		// Since the default hashCode method is overridden in the
		// ObjectWithEquals class, the two instances return the same int value.

		// The hashCode method is not required to give a unique value
		// for every unequal instance, but performance can be improved by having
		// the hashCode method generate distinct values.

		// For example:
		Map<ObjectWithEquals, Integer> mapUsingDistinctHashCodes = new HashMap<ObjectWithEquals, Integer>();
		Map<ObjectWithEquals, Integer> mapUsingSameHashCodes = new HashMap<ObjectWithEquals, Integer>();

		// Now add 10,000 objects to each map
		for (int i = 0; i < 10000; i++) {
			// Uses the hashCode in ObjectWithEquals
			ObjectWithEquals distinctHashCode = new ObjectWithEquals(i, i);
			mapUsingDistinctHashCodes.put(distinctHashCode, i);

			// The following overrides the hashCode method using an anonymous
			// inner class.
			// We will get to anonymous inner classes later... the important
			// part is that it returns the same hashCode no matter what values
			// are given to the constructor, which is a really bad idea!
			ObjectWithEquals sameHashCode = new ObjectWithEquals(i, i) {
				@Override
				public int hashCode() {
					return 31;
				}
			};
			mapUsingSameHashCodes.put(sameHashCode, i);
		}

		// Iterate over the two maps and time how long it takes
		long startTime = System.nanoTime();

		for (ObjectWithEquals key : mapUsingDistinctHashCodes.keySet()) {
			int i = mapUsingDistinctHashCodes.get(key);
		}

		long endTime = System.nanoTime();

		System.out.println("Time required when using distinct hashCodes: "
				+ (endTime - startTime));

		startTime = System.nanoTime();

		for (ObjectWithEquals key : mapUsingSameHashCodes.keySet()) {
			int i = mapUsingSameHashCodes.get(key);
		}

		endTime = System.nanoTime();

		System.out.println("Time required when using same hashCodes: "
				+ (endTime - startTime));
		System.out.println();

		//
		// Warning about hashCode method
		//

		// You can run into trouble if your hashCode is based on a value that
		// could change.
		// For example, we create an instance with a custom hashCode
		// implementation:
		ObjectWithEquals withEquals3 = new ObjectWithEquals(1, 10.0);

		// Create the Map and add the instance as a key
		Map<ObjectWithEquals, Double> withEquals3Map = new HashMap<ObjectWithEquals, Double>();
		withEquals3Map.put(withEquals3, 100.0);

		// Print some info about Map before changing attribute
		System.out.println("Map before changing attribute of key: "
				+ withEquals3Map);
		System.out
				.println("Map before changing attribute, does it contain key: "
						+ withEquals3Map.containsKey(withEquals3));
		System.out.println();

		// Now we change one of the values that the hashCode is based on:
		withEquals3.setX(123);

		// See what the Map look like now
		System.out.println("Map after changing attribute of key: "
				+ withEquals3Map);
		System.out
				.println("Map after changing attribute, does it contain key: "
						+ withEquals3Map.containsKey(withEquals3));
		System.out.println();

		// What is the source of this problem?
		// So, even though we used the same instance to put a value in the Map,
		// the Map does not recognize that the key is in the Map if an attribute
		// that is being used by the hashCode method is changed.
		// This can create some really confusing behavior!

		//
		// Final notes about equals and hashCode
		//

		// Also, Eclipse has a nice feature for generating the equals and
		// hashCode methods (Source -> Generate hashCode and equals methods), so
		// I would recommend using this feature if you need to implement these
		// methods. The source generator allows you to choose which attributes
		// should be used in the equals and hashCode methods.

		// GOOD CODING PRACTICE:
		// When working with objects, it is good to know if you are working with
		// the same instances over and over again or if you are expected to do
		// comparisons between different instances that may actually be equal.
		//
		// Also, if you override the hashCode method, if possible have the
		// hashCode be based on immutable data (data that cannot change value).
	}
}
