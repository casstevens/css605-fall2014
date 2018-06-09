package edu.gmu.rcasstev.week04;

/**
 * Examples showing when you much catch a checked exception and when you do not
 * required to catch an unchecked exception.
 * 
 * @author randy
 *
 */
public class ExceptionExamples {

	/**
	 * Just for an example. In general, it does not make sense to throw an
	 * exception as broad as an Exception.
	 * 
	 * Just because it declares that it can throw an Exception doesn't mean it
	 * will.
	 * 
	 * @throws Exception
	 */
	public static void someMethodThrowsException() throws Exception {

	}

	/**
	 * Just for an example. In general, it does not make sense to throw an
	 * exception as broad as a RuntimeException.
	 * 
	 * @throws RuntimeException
	 */
	public static void someMethodThrowsRuntimeException()
			throws RuntimeException {

	}

	/**
	 * Simple example using division.
	 * 
	 * @param args
	 */
	public static double divide(double dividend, double divisor)
			throws IllegalArgumentException {
		if (divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}

		return dividend / divisor;
	}

	/**
	 * Simple example using division, but note that you do not need to specify
	 * that you can throw the RuntimeException.
	 * 
	 * @param args
	 */
	public static double divide2(double dividend, double divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}

		return dividend / divisor;
	}

	/**
	 * Simple example using division, but note that you DO need to specify that
	 * you can throw an Exception.
	 * 
	 * @param args
	 */
	public static double divide3(double dividend, double divisor)
			throws Exception {
		if (divisor == 0) {
			throw new Exception("Cannot divide by zero");
		}

		return dividend / divisor;
	}

	public static void main(String[] args) {

		// Since the method declared that it can throw an Exception then you are
		// required to catch it
		try {
			someMethodThrowsException();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// But, if it throws a RuntimeException, then you are not required to
		// catch it
		someMethodThrowsRuntimeException();

		// However, it is a good idea to handle all exceptions
		try {
			someMethodThrowsRuntimeException();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		double x = 1.0;

		// The following are not required to be caught because they throw
		// RuntimeExceptions
		try {
			System.out.println("divide(x, 0.0): " + divide(x, 0.0));
			System.out.println("divide2(x, 0.0): " + divide2(x, 0.0));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		// You must catch checked Exceptions
		try {
			System.out.println("divide3(x, 0.0): " + divide3(x, 0.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
