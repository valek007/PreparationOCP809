package main.create_custom_exceptions;

public class Test {

	public static void main(String[] args) {

		/*
		 * Explanation:
		 * 
		 * try-with-resources: When MyAutoCloseableResource is initialized inside the
		 * try block, it will automatically call close() when the block finishes, even
		 * if an exception is thrown. Custom Exception Handling: The catch block catches
		 * ResourceException if any error occurs within the try block. General Exception
		 * Handling: A second catch block is provided to handle unexpected exceptions,
		 * ensuring all cases are covered.
		 */

		// Use try-with-resources to automatically manage MyAutoCloseableResource
		try (MyAutoCloseableResource resource = new MyAutoCloseableResource()) {
			resource.performAction(); // Perform action if the resource was opened successfully

		} catch (ResourceException e) {
			// Handle custom exceptions thrown by MyAutoCloseableResource
			System.out.println("Caught ResourceException: " + e.getMessage());
		} catch (Exception e) {
			// Handle any other exception that may occur
			System.out.println("Caught an unexpected exception: " + e.getMessage());
		} finally {
			System.out.println("Completed try-with-resources block.");
		}
	}

}

//Custom exception for when something goes wrong with the resource
class ResourceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ResourceException(String message) {
		super(message);
	}
}

//Custom resource that implements AutoCloseable
class MyAutoCloseableResource implements AutoCloseable {
	private boolean isActive;

	public MyAutoCloseableResource() throws ResourceException {
		System.out.println("Opening resource...");
		this.isActive = true;

		// Simulate a potential issue while opening the resource
		if (Math.random() > 0.5) { // Randomly throw exception for demonstration
			throw new ResourceException("Failed to open the resource due to an error.");
		}
	}

	// Method to perform some action
	public void performAction() throws ResourceException {
		if (!isActive) {
			throw new ResourceException("Resource is no longer active.");
		}
		System.out.println("Performing action with resource...");
	}

	// Override close method to handle resource cleanup
	@Override
	public void close() {
		System.out.println("Closing resource...");
		this.isActive = false;
	}
}
