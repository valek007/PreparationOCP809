package main.arraylist_treeset_treemap_arraydeque;

import java.util.TreeSet;

//TreeSet is an implementation of the Set interface that sorts elements based on their ordering
//Elements of a TreeSet instance are ordered using their natural ordering, or by a Comparator provided at creation time, depending on which constructor is used.
//Use TreeSet when you need a sorted, unique set of elements.
//It does not allow duplicates and maintains elements in sorted order.
//It’s ideal when the order of elements and uniqueness are important.
public class TreeSetTest {
	
	public static void main(String[] args) {
        // Create a new TreeSet of Strings
        TreeSet<String> treeSet = new TreeSet<>();
        
        // Adding elements to the TreeSet
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Orange");
        
        // Trying to add a duplicate element (this will be ignored as TreeSet doesn't allow duplicates)
        treeSet.add("Apple");  // Duplicate

        // Printing the TreeSet (elements will be in sorted order automatically)
        System.out.println("TreeSet: " + treeSet);
        // Output: TreeSet: [Apple, Banana, Mango, Orange]
        
        // Checking if an element is present in the TreeSet
        boolean containsApple = treeSet.contains("Apple");
        System.out.println("TreeSet contains 'Apple': " + containsApple);
        // Output: TreeSet contains 'Apple': true
        
        // Getting the first (lowest) element
        String firstElement = treeSet.first();
        System.out.println("First element: " + firstElement);
        // Output: First element: Apple
        
        // Getting the last (highest) element
        String lastElement = treeSet.last();
        System.out.println("Last element: " + lastElement);
        // Output: Last element: Orange
        
        // Removing an element from the TreeSet
        treeSet.remove("Mango");
        System.out.println("TreeSet after removing 'Mango': " + treeSet);
        // Output: TreeSet after removing 'Mango': [Apple, Banana, Orange]
        
        // Using higher() method to get the least element strictly greater than the given element
        String higherThanBanana = treeSet.higher("Banana");
        System.out.println("Element higher than 'Banana': " + higherThanBanana);
        // Output: Element higher than 'Banana': Orange
        
        // Using lower() method to get the greatest element strictly less than the given element
        String lowerThanOrange = treeSet.lower("Orange");
        System.out.println("Element lower than 'Orange': " + lowerThanOrange);
        // Output: Element lower than 'Orange': Banana
        
        // Polling (retrieving and removing) the first and last elements
        String polledFirst = treeSet.pollFirst();
        System.out.println("Polled first element: " + polledFirst);
        // Output: Polled first element: Apple
        
        String polledLast = treeSet.pollLast();
        System.out.println("Polled last element: " + polledLast);
        // Output: Polled last element: Orange
        
        // TreeSet after polling first and last elements
        System.out.println("TreeSet after polling: " + treeSet);
        // Output: TreeSet after polling: [Banana]
        
        // Clear the entire TreeSet
        treeSet.clear();
        System.out.println("TreeSet after clear(): " + treeSet);
        // Output: TreeSet after clear(): []
        
        // Checking if the TreeSet is empty
        boolean isEmpty = treeSet.isEmpty();
        System.out.println("Is TreeSet empty? " + isEmpty);
        // Output: Is TreeSet empty? true
    }

}
