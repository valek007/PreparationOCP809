package main.comparator_and_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Use Comparator:
//
//- When you need flexibility to define multiple sorting strategies.
//- When you want to keep sorting logic outside the class itself (separation of concerns).
//- When you can't modify the class or it already implements Comparable but you need alternative sorting criteria.

public class ComparatorTest {
	
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("John Doe",30));
		people.add(new Person("Jane Doe", 28));
		people.add(new Person("Baby Doe", 1));
		
		//With Set doesn't work
		Collections.sort(people, new MyComparator());
		
		for (Person person : people) {
			System.out.println(person.getName()+":"+person.getAge());
		}
	}

}

class Person2{
	private String name;
	private int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class MyComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		int comp = p1.getName().compareTo(p2.getName());	
		return comp!=0?comp:p1.getAge()-p2.getAge();
	}	
}
