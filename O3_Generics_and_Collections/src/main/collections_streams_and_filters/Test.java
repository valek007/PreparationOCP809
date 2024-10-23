package main.collections_streams_and_filters;

import java.util.ArrayList;
import java.util.Collection;

public class Test {

	public static void main(String[] args) {
		
		Collection<Person> collection = new ArrayList<>();
		collection.add(new Person("Emma","F",20));
		collection.add(new Person("Liam","M",30));
		collection.add(new Person("Olivia","F",27));
		collection.add(new Person("Noah","M",24));
		collection.removeIf(p->p.getAge()>25);
		collection.stream().forEach(System.out::println);
		
		System.out.println();
		
		collection.removeIf(p->p.getGender().equals("M"));
		collection.stream().forEach(System.out::println);
		
//		Collection collection2 = new ArrayList<>(); Collection is the same as Collection<Object>
//		collection2.add(new Person("Emma","F",20));
//		collection2.add(new Person("Liam","M",30));
//		collection2.add(new Person("Olivia","F",27));
//		collection2.add(new Person("Noah","M",24));
//		collection2.removeIf(p->p.getAge()>25); We have to cast to Person if not compile time error
//		collection2.stream().forEach(System.out::println);

	}

}

class Person {
	private String name, gender;
	private int age;

	public Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name+" "+age+" "+gender;
	}
	
	
}
