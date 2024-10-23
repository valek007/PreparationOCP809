package main.comparator_and_comparable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestComparator {
	
	public static void main(String[] args) {
		
		Set<String> set = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		
		set.add("Hello world");
		set.add("Hi!");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		TreeMap<Person3, Integer> marks = new TreeMap<>((p1, p2)->p2.getName().compareTo(p1.getName()));
		marks.put(new Person3("Noah"), 8);
		marks.put(new Person3("Ava"), 7);
		marks.put(new Person3("Isabella"), 9);
		
		for(int mark: marks.values()) {
			System.out.println(mark);
		}
		
	}

}

class Person3{
	private String name;

	public Person3(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
