package main.binary_versions_of_functional_interfaces;

import java.util.function.BiFunction;
import java.util.function.ToDoubleBiFunction;

public class BiFunctionClass {

	public static void main(String[] args) {
		Male adam = new Male("Adam", 30);
		Female eva = new Female("Eva", 20);
		BiFunction<Male, Female, String> biFunction = (m, f) -> m.getName() + "-" + f.getName();
		ToDoubleBiFunction<Male, Female> doubleFunction = (m, f) -> (m.getAge() + f.getAge()) / 2;

		System.out.println("The name of the couple is " + biFunction.apply(adam, eva));
		System.out.println("The average age of the coupe is " + doubleFunction.applyAsDouble(adam, eva));
		
		BiFunction<String, String, Person> function = (f,l) -> new Person(f,l);
		Person person = function.apply("John", "Doe");
		System.out.println(person.getFullName());
		
	}

	static class Person {
		private String firstName, lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFullName() {
			return firstName + " " + lastName;
		}
	}

	static class Female {

		@SuppressWarnings("unused")
		private static final String gender = "FEMALE";
		private String name;
		private int age;

		public Female(String name, int age) {
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

	static class Male {

		@SuppressWarnings("unused")
		private static final String gender = "MALE";
		private String name;
		private int age;

		public Male(String name, int age) {
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
}
