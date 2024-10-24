package main.binary_versions_of_functional_interfaces;

import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

public class BiConsumerClass {
	
	public static void main(String[] args) {
		
		BiConsumer<String, String> biConsumer = (s1, s2)-> System.out.println(s1+" "+s2);
		biConsumer.accept("Hello", "World");
		
		ObjIntConsumer<String> intConsumer = (s,i) -> System.out.println(s.length()-i);
		intConsumer.accept("Hello", 4);
		
		BiConsumer<Person,String> consumer = (p,s) -> p.setName(s);
		Person person = new Person();
		consumer.accept(person, "John");
		System.out.println(person.getName());
	}

}

class Person{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
