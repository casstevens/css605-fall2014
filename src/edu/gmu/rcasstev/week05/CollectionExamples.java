package edu.gmu.rcasstev.week05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

/**
 * Java provides multiple types of Collections for storing groups of Objects.
 * 
 * @author randy
 *
 */
public class CollectionExamples {

	public static void main(String[] args) {

		//
		// List
		//

		System.out.println("List examples");

		// One of the simplest types of Collections is a List.
		Vector<Double> doubleVector = new Vector<Double>();

		// Now we can add elements to the list and it will maintain the order in
		// which the elements were added.
		doubleVector.add(10.0);
		doubleVector.add(25.0);
		doubleVector.add(50.0);
		doubleVector.add(100.0);

		// You can iterate over the items in the Vector like this:
		for (int i = 0; i < doubleVector.size(); i++) {
			System.out.print(doubleVector.get(i) + "  ");
		}
		System.out.println();

		// Or a bit more compact way of doing the same thing:
		for (Double x : doubleVector) {
			System.out.print(x + "  ");
		}
		System.out.println();

		// Or better yet you can use the toString method of the Collection
		System.out.println(doubleVector.toString());

		// One nice thing about a list compared to an array is that you do not
		// need to specify the size of list beforehand.

		// There is also other types that implement the List interface
		ArrayList<Double> doubleArrayList = new ArrayList<Double>();

		// You can add elements just like before
		doubleArrayList.add(1.0);

		// Or you can add all of the elements from another Collection
		doubleArrayList.addAll(doubleVector);

		// Using Generics (List<Type>), you can specify what type you are going
		// to place in the Collection
		Vector<Integer> integerVector = new Vector<Integer>();
		Vector<String> stringVector = new Vector<String>();
		ArrayList<Date> dateArrayList = new ArrayList<Date>();

		//
		// Set
		//

		System.out.println();
		System.out.println("Set examples");

		// A Set is a Collection that does not maintain the order in which
		// elements were added and does not allow for elements to be added more
		// than once.
		HashSet<Double> doubleSet = new HashSet<Double>();

		// If we added the following elements
		doubleSet.add(2.0);
		doubleSet.add(2.0);

		// If we check the size of the set, then it would be one (not two)
		// because the same item was added twice.
		System.out.println("Set only has one element (not two): "
				+ doubleSet.size());

		// Therefore, a set could be used when you do not want to allow
		// duplicates in your Collection

		//
		// Map
		//

		System.out.println();
		System.out.println("Map examples");

		// A Map is a Collection that maps keys to values.

		// For example, if you want to map names to birthdays:
		HashMap<String, Date> nameToBirthdayMap = new HashMap<String, Date>();

		// The the keys are of the first Type and the values are of the second
		// Type in the Generic.

		// Create a date format so we can parse some birthdays
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		try {
			nameToBirthdayMap.put("Jane", dateFormat.parse("06/01/2000"));
			nameToBirthdayMap.put("Joe", dateFormat.parse("12/30/1900"));
			nameToBirthdayMap.put("Joe", dateFormat.parse("05/30/1950")); // Overwrites
																			// Joe's
																			// previous
																			// value
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		// Take note, that each key can only have a single value, so in the code
		// above, the first value for the "Joe" key is overwritten.

		// Print the person's name and birthday.
		// Take note, that there is no guarantees on the order in which the
		// Collection will be iterated through.
		for (String nameKey : nameToBirthdayMap.keySet()) {
			Date birthday = nameToBirthdayMap.get(nameKey);
			System.out.println(nameKey + " has the birthday: " + birthday);
		}

		// You can also  it this way
		System.out.println("Using the toString method: " + nameToBirthdayMap);

		// Notice how I didn't invoke the toString method explicitly, but it
		// still gets called.

		//
		// Collections
		//

		System.out.println();
		System.out.println("Collections examples");

		// Just like with arrays where there was the Arrays class that provided
		// some useful functionality for arrays, there is the Collections class.

		// We don't need the equivalent method as Arrays.toString for
		// Collections because each Collection already has a toString method,
		// but here are some helpful methods in the Collections class.

		System.out.println("double list: " + doubleArrayList);

		Collections.reverse(doubleArrayList);
		System.out.println("double list after reversed: " + doubleArrayList);

		Collections.shuffle(doubleArrayList);
		System.out.println("double list after shuffled: " + doubleArrayList);

		Collections.sort(doubleArrayList);
		System.out.println("double list after sorted: " + doubleArrayList);

		System.out.println("double list min: "
				+ Collections.min(doubleArrayList));
		System.out.println("double list max: "
				+ Collections.max(doubleArrayList));

		Collections.replaceAll(doubleArrayList, 100.0, 75.0);
		System.out.println("double list after replacing 100.0 with 75.0: "
				+ doubleArrayList);

		// The Collections.synchronizedCollection method is helpful if
		// you have multiple threads modifying your Collection.

		// The Collections.unmodifiableCollection method is useful when you want
		// to provide access to your Collection, but want to be guaranteed that
		// there are no changes made to it.
	}

}
