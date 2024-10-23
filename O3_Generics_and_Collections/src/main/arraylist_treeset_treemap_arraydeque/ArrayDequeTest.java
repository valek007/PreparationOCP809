package main.arraylist_treeset_treemap_arraydeque;

import java.util.ArrayDeque;

//Use ArrayDeque when you need a double-ended queue (deque) that can function as both a stack or queue.
//It allows adding/removing elements from both ends efficiently and is faster than LinkedList for this purpose.
//It is useful when you need both stack-like and queue-like operations.
public class ArrayDequeTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Create a new ArrayDeque of Strings
		ArrayDeque<String> deque = new ArrayDeque<>();

		// Adding elements at the end of the deque
		deque.add("Apple");
		deque.add("Banana");
		deque.add("Orange");

		// Adding elements at the front of the deque
		deque.addFirst("Mango"); // Adds "Mango" at the front
		deque.addLast("Grapes"); // Adds "Grapes" at the end (equivalent to add())

		// Printing the deque
		System.out.println("ArrayDeque: " + deque);
		// Output: ArrayDeque: [Mango, Apple, Banana, Orange, Grapes]

		// Accessing the first and last elements
		String firstElement = deque.getFirst(); // Retrieves but doesn't remove
		String lastElement = deque.getLast();
		System.out.println("First element: " + firstElement);
		System.out.println("Last element: " + lastElement);
		// Output: First element: Mango, Last element: Grapes

		// Removing elements from the front and end
		String removedFirst = deque.removeFirst(); // Removes and returns the first element
		String removedLast = deque.removeLast(); // Removes and returns the last element
		System.out.println("ArrayDeque after removals: " + deque);
		// Output: ArrayDeque after removals: [Apple, Banana, Orange]

		// Using offer() to add elements at the end
		deque.offer("Pineapple"); // Adds to the end (equivalent to add())
		deque.offerFirst("Strawberry"); // Adds to the front
		deque.offerLast("Kiwi"); // Adds to the end
		System.out.println("ArrayDeque after offers: " + deque);
		// Output: ArrayDeque after offers: [Strawberry, Apple, Banana, Orange,
		// Pineapple, Kiwi]

		// Peeking at elements without removing them
		String peekFirst = deque.peekFirst(); // Retrieves the first element without removing
		String peekLast = deque.peekLast(); // Retrieves the last element without removing
		System.out.println("Peek first: " + peekFirst + ", Peek last: " + peekLast);
		// Output: Peek first: Strawberry, Peek last: Kiwi

		// Checking if deque contains an element
		boolean containsBanana = deque.contains("Banana");
		System.out.println("Deque contains 'Banana': " + containsBanana);
		// Output: Deque contains 'Banana': true

		// Polling elements (retrieves and removes)
		String polledFirst = deque.pollFirst(); // Removes and returns the first element
		String polledLast = deque.pollLast(); // Removes and returns the last element
		System.out.println("ArrayDeque after polling: " + deque);
		// Output: ArrayDeque after polling: [Apple, Banana, Orange, Pineapple]

		// Clearing the deque
		deque.clear();
		System.out.println("ArrayDeque after clear(): " + deque);
		// Output: ArrayDeque after clear(): []

		// Checking if the deque is empty
		boolean isEmpty = deque.isEmpty();
		System.out.println("Is deque empty? " + isEmpty);
		// Output: Is deque empty? true
	}

}
