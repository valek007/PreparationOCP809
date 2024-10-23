package main.arraylist_treeset_treemap_arraydeque;

import java.util.ArrayList;

//Use ArrayList when you need a resizable array to store elements in an ordered sequence.
//It allows fast random access (via index) and is good for read-heavy operations.
//However, adding or removing elements (except at the end) can be slow, as it involves shifting.

public class ArraListTest {
	
	public static void main(String[] args) {
		
//		3 options for declare the ArrayList
//		List<String> list = new ArrayList<>();
//		list = Arrays.asList("Hello","World");
//		list = List.of("Hello", "World"); from java 9
		
		
        // Create a new ArrayList of Strings
        ArrayList<String> arrayList = new ArrayList<>();
        
        // Adding elements to the ArrayList
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        
        // Adding an element at a specific index
        arrayList.add(1, "Mango"); // Inserts "Mango" at index 1
        
        // Printing the ArrayList
        System.out.println("ArrayList: " + arrayList);
        // Output: ArrayList: [Apple, Mango, Banana, Orange]
        
        // Accessing an element at a specific index
        String elementAtIndex2 = arrayList.get(2);
        System.out.println("Element at index 2: " + elementAtIndex2);
        // Output: Element at index 2: Banana
        
        // Changing the element at a specific index
        arrayList.set(2, "Grapes");
        System.out.println("ArrayList after set(2, 'Grapes'): " + arrayList);
        // Output: ArrayList after set(2, 'Grapes'): [Apple, Mango, Grapes, Orange]
        
        // Removing an element by index
        arrayList.remove(1);  // Removes the element at index 1 ("Mango")
        System.out.println("ArrayList after removing element at index 1: " + arrayList);
        // Output: ArrayList after removing element at index 1: [Apple, Grapes, Orange]
        
        // Removing an element by value
        arrayList.remove("Grapes");
        System.out.println("ArrayList after removing 'Grapes': " + arrayList);
        // Output: ArrayList after removing 'Grapes': [Apple, Orange]
        
        // Checking if an element is present
        boolean containsApple = arrayList.contains("Apple");
        System.out.println("Does ArrayList contain 'Apple'? " + containsApple);
        // Output: Does ArrayList contain 'Apple'? true
        
        // Getting the size of the ArrayList
        int size = arrayList.size();
        System.out.println("Size of ArrayList: " + size);
        // Output: Size of ArrayList: 2
        
        // Iterating over the elements of the ArrayList
        System.out.println("Iterating over ArrayList:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }
        // Output:
        // Iterating over ArrayList:
        // Apple
        // Orange
        
        // Clearing all elements from the ArrayList
        arrayList.clear();
        System.out.println("ArrayList after clear(): " + arrayList);
        // Output: ArrayList after clear(): []
        
        // Checking if the ArrayList is empty
        boolean isEmpty = arrayList.isEmpty();
        System.out.println("Is ArrayList empty? " + isEmpty);
        // Output: Is ArrayList empty? true
    }

}
