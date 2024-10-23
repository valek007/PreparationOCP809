package main.arraylist_treeset_treemap_arraydeque;

import java.util.TreeMap;

//Use TreeMap when you need a sorted map (key-value pairs) with fast lookups.
//It automatically orders the keys in natural order (or custom order using a comparator).
//It is useful when you frequently need to access elements in sorted order.

public class TreeMapTest {

	public static void main(String[] args) {
		// Create a new TreeMap with String keys and Integer values
		TreeMap<String, Integer> treeMap = new TreeMap<>();

		// Adding key-value pairs to the TreeMap
		treeMap.put("Apple", 3);
		treeMap.put("Banana", 2);
		treeMap.put("Orange", 5);
		treeMap.put("Grapes", 4);

		// Printing the TreeMap (keys are automatically sorted in natural order)
		System.out.println("TreeMap: " + treeMap);
		// Output: TreeMap: {Apple=3, Banana=2, Grapes=4, Orange=5}

		// Accessing a value by key
		int appleValue = treeMap.get("Apple");
		System.out.println("Value for key 'Apple': " + appleValue);
		// Output: Value for key 'Apple': 3

		// Replacing the value for a specific key
		treeMap.put("Banana", 10); // Updates the value for "Banana" to 10
		System.out.println("Updated TreeMap: " + treeMap);
		// Output: Updated TreeMap: {Apple=3, Banana=10, Grapes=4, Orange=5}

		// Checking if a key exists
		boolean hasOrange = treeMap.containsKey("Orange");
		System.out.println("TreeMap contains 'Orange': " + hasOrange);
		// Output: TreeMap contains 'Orange': true

		// Checking if a value exists
		boolean hasValue5 = treeMap.containsValue(5);
		System.out.println("TreeMap contains value 5: " + hasValue5);
		// Output: TreeMap contains value 5: true

		// Removing a key-value pair
		treeMap.remove("Grapes");
		System.out.println("TreeMap after removing 'Grapes': " + treeMap);
		// Output: TreeMap after removing 'Grapes': {Apple=3, Banana=10, Orange=5}

		// Getting the first (lowest) key
		String firstKey = treeMap.firstKey();
		System.out.println("First key: " + firstKey);
		// Output: First key: Apple

		// Getting the last (highest) key
		String lastKey = treeMap.lastKey();
		System.out.println("Last key: " + lastKey);
		// Output: Last key: Orange

		// Using higherKey() to get the least key strictly greater than the given key
		String higherThanApple = treeMap.higherKey("Apple");
		System.out.println("Key higher than 'Apple': " + higherThanApple);
		// Output: Key higher than 'Apple': Banana

		// Using lowerKey() to get the greatest key strictly less than the given key
		String lowerThanOrange = treeMap.lowerKey("Orange");
		System.out.println("Key lower than 'Orange': " + lowerThanOrange);
		// Output: Key lower than 'Orange': Banana

		// Getting the size of the TreeMap
		int size = treeMap.size();
		System.out.println("Size of TreeMap: " + size);
		// Output: Size of TreeMap: 3

		// Clearing all entries in the TreeMap
		treeMap.clear();
		System.out.println("TreeMap after clear(): " + treeMap);
		// Output: TreeMap after clear(): {}

		// Checking if the TreeMap is empty
		boolean isEmpty = treeMap.isEmpty();
		System.out.println("Is TreeMap empty? " + isEmpty);
		// Output: Is TreeMap empty? true
	}

}
