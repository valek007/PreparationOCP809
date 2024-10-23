package main.comparator_and_comparable;

import java.util.Set;
import java.util.TreeSet;

//Use Comparable:
//
//- When there is a natural or default ordering for objects.
//- When you expect the class itself to always be comparable in the same way (e.g., numbers are naturally ordered).
//- Suitable for single sorting logic that applies generally to the class.


public class ComparableTest {

	public static void main(String[] args) {
		
		Set<Person> people = new TreeSet<>();
		people.add(new Person("John Doe",30));
		people.add(new Person("Jane Doe", 28));
		people.add(new Person("Baby Doe", 1));
		
		//For sorting list we can use 		Arrays.sort(people);
		
		for (Person person : people) {
			System.out.println(person.getName()+":"+person.getAge());
		}

	}
}

class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person person) {
		int comp = this.name.compareTo(person.name);
		return comp!=0?comp:person.age-this.age;
	}

}
