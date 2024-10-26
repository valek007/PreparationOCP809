package main.sorting_collection;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		//Example 1:
		Stream<Integer> stream1 = Arrays.asList(2, 3, 1).stream().sorted();
		stream1.forEachOrdered(System.out::print); // print 123

		System.out.println();

		//Example 2:
		Stream<String> stream2 = Arrays.asList("A", "B", "C").stream().sorted((s1, s2) -> s2.compareTo(s1));
		Optional<String> result = stream2.reduce(String::concat);
		System.out.println(result.get());
		
		Arrays.asList(new Person("Adam"), new Person("Eva")).stream().sorted().forEachOrdered(p->System.out.print(p.getName()+" "));
		
		

	}

	static class Person implements Comparable<Person>{
		private String name;

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public int compareTo(Person person) {
			return person.getName().compareTo(name);
		}
	}

}
