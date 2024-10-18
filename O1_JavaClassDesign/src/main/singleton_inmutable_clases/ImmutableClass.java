package main.singleton_inmutable_clases;

/*
 Definition:
  - A class is considered immutable if the state of its objects cannot be modified after they are created
 Creating immutable classes:
 - Make all fields final and private
 - Do not provide setter methods
 - Do not allow subclasses to override methods of the class you want to make immutable
 - If instance fields of the class include references to mutable objects, do not directly expose those objects
 
 Pros:
  - Objects of an immutable class cannot be corrupted by thread interference or observed in an inconsistent state
 Cons:
  - A new object must be created each time you need an object with a different state, which may result in object proliferation
 */
public class ImmutableClass {
	
	public static void main(String[] args) {
		Person person = new Person("Joe Doe");
		System.out.println(person.getFullName());
	}

}

final class Person {
	private final String fullName;
	
	public Person(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}
}
