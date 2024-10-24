package main.unary_operator_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Test {

	public static void main(String[] args) {

		UnaryOperator<Person> operator = p -> new Person(p.getName().toUpperCase(), p.getAge() + 1);
		
		Person oldPerson = new Person("John",16);
		Person newPerson = operator.apply(oldPerson);
		System.out.println(newPerson.getName()+":"+newPerson.getAge());
		
		UnaryOperator<Double> operator2 = d->d/2;
		double result = operator2.apply(1.2);
		System.out.println(result);
		
		List<String> list = Arrays.asList("java");
		list.replaceAll(s->s.toUpperCase());
		System.out.println(list.get(0));

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

	}

}
