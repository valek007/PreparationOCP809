package main.save_results_to_collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.save_results_to_collection.Test.Person.Gender;

public class Test {

	public static void main(String[] args) {

		// Example 1
		List<String> list = Stream.of("A", "B", "B", "A").collect(Collectors.toList());
		System.out.println(list); // print [A, B, B, A]

		// Example 2
		Set<String> set = Stream.of("A", "B", "B", "A").collect(Collectors.toSet());
		System.out.println(set); // print [A, B]

		// Example 3
		LinkedList<String> lList = Stream.of("A", "B", "C").collect(Collectors.toCollection(() -> new LinkedList<>()));
		System.out.println(lList); // print [A, B, C]

		// Example 4
		Stream<Person> stream = Stream.of(new Person(1, "David"), new Person(2, "Grace"));
		Map<Integer, String> map = stream.collect(Collectors.toMap(Person::getId, Person::getName));
		System.out.println(map); // print {1=David, 2=Grace}
		
		//Example 5
		Person p1 = new Person("Leo", Gender.MALE, 40);
		Person p2 = new Person("Mia", Gender.FEMALE, 30);
		Person p3 = new Person("Eli", Gender.MALE, 20);
		Person p4 = new Person("Zeo", Gender.FEMALE, 10);
		Stream<Person> stream2 = Stream.of(p1,p2,p3,p4);
		Map<Gender, List<Person>> map2 = stream2.collect(Collectors.groupingBy(Person::getGender));
		System.out.println(map2); //print {FEMALE=[Mia 30, Zeo 10], MALE=[Leo 40, Eli 20]}
		
		Stream<Person> stream3 = Stream.of(p1,p2,p3,p4);
		Map<Gender, Double> reducedMap = stream3.collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getAge)));
		System.out.println(reducedMap); //print {FEMALE=20.0, MALE=30.0}
		
		Stream<Person> stream4 = Stream.of(p1,p2,p3,p4);
		Map<Boolean, List<Person>> map3 = stream4.collect(Collectors.partitioningBy(Person::isMale));
		System.out.println(map3); //print {false=[Mia 30, Zeo 10], true=[Leo 40, Eli 20]}
		
		Stream<Person> stream5 = Stream.of(p1,p2,p3,p4);
		Map<Boolean, Double> reducedMap2 = stream5.collect(Collectors.partitioningBy(Person::isMale, Collectors.averagingDouble(Person::getAge)));
		System.out.println(reducedMap2); //print {false=20.0, true=30.0}
		
		//Last important think to know is:                                                       We have to pass this argument for Collection
		Collection<String> collection = Stream.of("Java","Java").collect(Collectors.toCollection(()->new HashSet<String>()));
		System.out.println(collection);

	}

	static class Person {
		private int id;
		private String name;
		// New atributes
		private Gender gender;
		private int age;

		public Person(String name, Gender gender, int age) {
			this.name = name;
			this.gender = gender;
			this.age = age;
		}

		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public Gender getGender() {
			return gender;
		}

		public int getAge() {
			return age;
		}
		
		public boolean isMale() {
			return gender == Gender.MALE;
		}

		@Override
		public String toString() {
			return this.name+" "+this.age;
		}



		public enum Gender {
			MALE, FEMALE
		}

	}

}
