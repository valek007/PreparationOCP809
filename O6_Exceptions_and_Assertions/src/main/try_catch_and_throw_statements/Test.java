package main.try_catch_and_throw_statements;

public class Test {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		/*
		 * Explanation try block: Encloses code that might throw an exception. catch
		 * block: Catches and handles specific types of exceptions. Here, separate catch
		 * blocks are used for ArithmeticException, NullPointerException, and
		 * ArrayIndexOutOfBoundsException. finally block: Always executes, regardless of
		 * whether an exception occurred.
		 */
		try {
			// Potentially risky code block

			// 1. ArithmeticException (Division by zero)
			int result = 10 / 0; // This will throw ArithmeticException
			System.out.println("Result: " + result);

			// 2. NullPointerException
			String str = null;
			System.out.println(str.length()); // Uncommenting will throw NullPointerException

			// 3. ArrayIndexOutOfBoundsException
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[5]); // Uncommenting will throw ArrayIndexOutOfBoundsException

			// 4. Compilation Error Example - Uncommenting will cause a compilation error
			// int x = "hello"; // Incorrect data type assignment

		} catch (ArithmeticException e) {
			System.out.println("Caught an ArithmeticException: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Caught a NullPointerException: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
		} catch (Exception e) {
			// This is a generic catch block for any other Exception
			System.out.println("Caught an Exception: " + e.getMessage());
		} finally {
			// Code that will always execute regardless of exceptions
			System.out.println("This is the finally block.");
		}

		/*
		 * Explanation of throw Statement and Code Flow Throwing an Exception:
		 * 
		 * In the checkNumber method, an IllegalArgumentException is explicitly thrown
		 * if the input number is negative: throw new
		 * IllegalArgumentException("Number must be non-negative"); When throw is
		 * encountered, the method immediately stops executing and control goes to the
		 * nearest matching catch block (if any). Catching the Exception:
		 * 
		 * In main, the checkNumber(-5); call is wrapped in a try block. Since
		 * checkNumber throws an IllegalArgumentException, the catch block catches it,
		 * and the custom message "Caught an exception: Number must be non-negative" is
		 * printed. Finally Block:
		 * 
		 * Regardless of whether an exception occurs, the finally block is always
		 * executed. Here, it displays "Execution completed in finally block."
		 */
		try {
			checkNumber(-5); // This will throw an IllegalArgumentException
		} catch (IllegalArgumentException e) {
			System.out.println("Caught an exception: " + e.getMessage());
		} finally {
			System.out.println("Execution completed in finally block.");
		}

		/*
		 * In this example:
		 * 
		 * Custom Exception Class:
		 * 
		 * InvalidAgeException is a custom exception that extends Exception. This makes
		 * it a checked exception, so it must either be caught or declared in the method
		 * signature using throws. Throwing the Custom Exception:
		 * 
		 * In checkAge, the custom exception InvalidAgeException is thrown if the age is
		 * less than 18. Handling the Custom Exception:
		 * 
		 * In main, the checkAge method is called within a try block, and the catch
		 * block captures InvalidAgeException if it is thrown. Output (If Age < 18) 
		 * Caught custom exception: Age must be 18 or older
		 */

		try {
			checkAge(15); // This will throw an InvalidAgeException
		} catch (InvalidAgeException e) {
			System.out.println("Caught custom exception: " + e.getMessage());
		}
	}

	// Method that throws an exception if the number is negative
	public static void checkNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be non-negative"); // Throws an exception if number is
																				// negative
		}
		System.out.println("The number is: " + number);
	}

	public static void checkAge(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or older"); // Throws custom exception if age is below 18
		}
		System.out.println("Access granted - Age is valid.");
	}

}

//Custom exception class
class InvalidAgeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidAgeException(String message) {
		super(message);
	}
}
