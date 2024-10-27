package main.catch_multicatch_finally;

public class Test {

	@SuppressWarnings({ "unused", "null" })
	public static void main(String[] args) {

		/*
		 * Explanation:
		 * 
		 * If the try block throws an ArithmeticException (as in 10 / 0), the catch
		 * block for ArithmeticException will execute.
		 */
		try {
			int result = 10 / 0; // This will throw ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println("Caught an ArithmeticException: " + e.getMessage());
		}

		/*
		 * Explanation:
		 * 
		 * This example uses a multi-catch block to handle both
		 * ArrayIndexOutOfBoundsException and NullPointerException. If either exception
		 * occurs, the same catch block will handle it. Important: In a multi-catch
		 * block, each exception type must be separated by a vertical bar (|) and cannot
		 * be related by inheritance (e.g., Exception | NullPointerException would be
		 * invalid because NullPointerException is a subclass of Exception).
		 */

		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[5]); // This throws ArrayIndexOutOfBoundsException

			String str = null;
			System.out.println(str.length()); // This throws NullPointerException

		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("Caught an exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
		}

		/*
		 * Explanation:
		 * 
		 * Here, the finally block will run after the catch block, regardless of whether
		 * an exception was thrown. If no exception is thrown, finally executes after
		 * try. Even if a catch block is skipped (if an exception is not matched),
		 * finally still runs.
		 */

		try {
			int result = 10 / 0; // Throws ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println("Caught an ArithmeticException: " + e.getMessage());
		} finally {
			System.out.println("This is the finally block, it always executes.");
		}
	}

}
