package main.use_method_references_with_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Method reference syntax: <ClassName | objectVariable>::<methodName>
//Types of references:
//- To a static method
//- To an instance method of an arbitrary object of a particular type
//- To an instance method of a particular object
//- to a constructor
public class Test {

	public static void main(String[] args) {
		// Reference to a static method: ClassName::staticMethodName

		/*
		 * The static method reference will fail to compile if the method signature
		 * (i.e., number of parameters and their types) doesn't match the functional
		 * interface expected in the context (such as a Consumer<T> for forEach). When
		 * there is a mismatch, the compiler throws an error because Java doesn't know
		 * how to match the stream element to the method parameters. The solution is
		 * either to use a lambda expression to handle additional arguments or to ensure
		 * the method matches the expected functional interface signature.
		 */
		Stream.of("apple", "banana", "cherry").forEach(Test::print); // Equivalent to: s -> StaticMethodExample.print(s)

		System.out.println();

		// Reference to an instance method of an arbitrary object:
		String[] words = { "apple", "banana", "cherry" };
		// ClassName::instanceMethod
		Arrays.stream(words).map(String::toUpperCase) // Equivalent to: s -> s.toUpperCase()
				.forEach(System.out::println);

		System.out.println();

		// Reference to an instance method of a particular object:
		// objectVariable::instanceMethod
		String prefix = "Fruit: ";
		Stream.of("apple", "banana", "cherry").map(prefix::concat) // Equivalent to: s -> prefix.concat(s)
				.forEach(System.out::println);

		System.out.println();

		// Reference to a constructor: ClassName::new
		List<String> fruitNames = Arrays.asList("apple", "banana", "cherry");
		Stream<Fruit> fruitStream = fruitNames.stream().map(Fruit::new); // Equivalent to: name -> new Fruit(name)
		fruitStream.forEach(System.out::println); // Prints the fruits
	}

	// - To a static method
	public static void print(String s) {
		System.out.println(s);
	}

}

class Fruit {
	private String name;

	public Fruit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
