package main.extracting_data_map_peek;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		Person logan = new Person("Logan", 25);
		Person avery = new Person("Avery", 22);

		// Example 1: peek
		Stream<Person> stream1 = Stream.of(logan, avery).peek(p -> System.out.println(p));
		stream1.forEach(p -> {
		});
		
		//Example 2: map
		Stream<String> stream2 = Stream.of(logan, avery).map(p->p.getName());
		stream2.forEach(System.out::println);
		
		//Example 3: IntStream, DoubleStream, LongStream
		IntStream stream3 = Stream.of(logan, avery).mapToInt(p->p.getAge());
		stream3.forEach(System.out::println);

	}

	static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
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
		public String toString() {
			return this.getName() + " age: " + this.getAge();
		}

	}

}
