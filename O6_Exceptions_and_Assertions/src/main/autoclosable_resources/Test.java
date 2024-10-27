package main.autoclosable_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {

		/*
		 * Explanation:
		 * 
		 * Automatic Resource Management: Both FileReader and BufferedReader implement
		 * AutoCloseable, so they will automatically close when the try block completes,
		 * even if an exception is thrown. No Explicit finally: You don’t need a finally
		 * block to close the resources manually; they are automatically closed at the
		 * end of the try block. Exception Handling: If an IOException occurs (e.g., if
		 * the file is not found), the catch block handles it.
		 */

		// Using try-with-resources to automatically manage resources
		try (FileReader fr = new FileReader("sample.txt"); BufferedReader br = new BufferedReader(fr)) {

			// Reading the first line from the file
			String line = br.readLine();
			System.out.println("First line: " + line);

		} catch (IOException e) {
			System.out.println("An IOException occurred: " + e.getMessage());
		}

		/*
		 * Explanation:
		 * 
		 * Custom AutoCloseable: MyResource is a custom class that implements
		 * AutoCloseable and overrides the close() method. Automatic Closing: The
		 * close() method is called automatically at the end of the try block.
		 */

		// Using try-with-resources with a custom AutoCloseable resource
		try (MyResource resource = new MyResource()) {
			resource.doSomething();
		} catch (Exception e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}

		/*
		 * Explanation:
		 * 
		 * Multiple Resources: FileReader, BufferedReader, and FileWriter are all
		 * managed by a single try-with-resources statement. Automatic Closing Order:
		 * Resources are closed in reverse order of their declaration (FileWriter closes
		 * first, then BufferedReader, then FileReader).
		 */

		try (FileReader fr = new FileReader("input.txt");
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("output.txt")) {

			String line;
			while ((line = br.readLine()) != null) {
				fw.write(line + "\n"); // Writing each line to the output file
			}

			System.out.println("File copied successfully.");

		} catch (IOException e) {
			System.out.println("An IOException occurred: " + e.getMessage());
		}

		/*
		 * - Benefits of try-with-resources Automatic Resource Management: 
		 * Ensures resources are closed automatically, reducing boilerplate code.
		 * - Cleaner Code:
		 * No need for explicit finally blocks to close resources. 
		 * - Error Prevention:
		 * Reduces the risk of resource leaks, which can cause memory or file handle exhaustion.
		 */
	}

}

class MyResource implements AutoCloseable {
	public MyResource() {
		System.out.println("Resource opened.");
	}

	public void doSomething() {
		System.out.println("Doing something with the resource.");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Resource closed.");
	}
}
