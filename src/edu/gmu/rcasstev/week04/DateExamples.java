package edu.gmu.rcasstev.week04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateExamples {

	public static void main(String[] args) {

		//
		// Date basics
		//

		// Create a object that holds the current time
		Date now = new Date();
		System.out.println("now = " + now);

		// Dates hold the number of milliseconds since the start of 1970
		Date year1970 = new Date(0);

		// Notice how it isn't quite the start of 1970
		// This is because of the time zone differences
		System.out.println("year1970 = " + year1970);

		// Create a formatter that will format the date in GMT
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEE MMM d, yyyy hh:mm:ss a z");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Now, it is the start of 1970
		System.out.println("year1970 again = " + sdf.format(year1970));

		System.out.println();

		// There are other types of formatters
		System.out
				.println("year1970 date instance short = "
						+ DateFormat.getDateInstance(DateFormat.SHORT).format(
								year1970));
		System.out.println("year1970 date instance default = "
				+ DateFormat.getDateInstance().format(year1970));
		System.out.println("year1970 date instance long = "
				+ DateFormat.getDateInstance(DateFormat.LONG).format(year1970));

		System.out.println();

		// And formatters that print the date and time
		System.out.println("year1970 date/time instance short = "
				+ DateFormat.getDateTimeInstance(DateFormat.SHORT,
						DateFormat.SHORT).format(year1970));
		System.out.println("year1970 date/time instance default = "
				+ DateFormat.getDateTimeInstance().format(year1970));
		System.out.println("year1970 date/time instance long = "
				+ DateFormat.getDateTimeInstance(DateFormat.LONG,
						DateFormat.LONG).format(year1970));

		System.out.println();

		//
		// Convert String into Date
		//

		SimpleDateFormat yearFormat = new SimpleDateFormat("MMyyyy");

		String dateStr = "062014";

		// Notice how we need to catch the exception
		Date date = null;
		try {
			date = yearFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("After converting String: " + dateStr + " to Date: "
				+ date);

		System.out.println();

		//
		// Comparing Dates
		//

		String dateStr2 = "072014";

		// Notice how we need to catch the exception
		Date date2 = null;
		try {
			date2 = yearFormat.parse(dateStr2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("After converting second String: " + dateStr2
				+ " to Date: " + date2);

		System.out.println();

		// Negative because date is before date2
		System.out.println("date.compareTo(date2) = " + date.compareTo(date2));
		// Positive because date2 is after date
		System.out.println("date2.compareTo(date) = " + date2.compareTo(date));
		// Zero because date is same as date
		System.out.println("date.compareTo(date) = " + date.compareTo(date));

		System.out.println();

		// Is before
		System.out.println("date.before(date2) = " + date.before(date2));
		// Isn't after
		System.out.println("date.after(date2) = " + date.after(date2));

		System.out.println();

		// date is equal to date so not before
		System.out.println("date.before(date) = " + date.before(date));
		// date is equal to date so not after
		System.out.println("date.after(date) = " + date.after(date));

		System.out.println();

		//
		// Getting the number of milliseconds
		//

		// You can also use the getTime method in a Date to find the number of
		// milliseconds since the start of 1970

		// Since this date holds 1970, then it will be zero:
		System.out.println("year1970.getTime() : " + year1970.getTime());

		// The number of milliseconds between now and 1970 is:
		System.out.println("now.getTime() : " + now.getTime());

		// You can also use these values for comparison
		System.out.println("year1970 is before now: "
				+ (year1970.getTime() < now.getTime()));
	}
}
