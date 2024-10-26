package main.searching_data_findfirst_anymatch_etc;

import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		
		Person dylan = new Person("Dylan", 25);
		Person sarah = new Person("Sarah", 22);
		
		//Example1: findFirst
		Person first = Stream.of(dylan, sarah).findFirst().get();
		System.out.println(first);
		
		//Example2: findAny can be Dylan or Sarah
		Person any = Stream.of(dylan, sarah).findAny().get();
		System.out.println(any);
		
		//Example3: anyMatch
		System.out.println(Stream.of(dylan, sarah).anyMatch(p->p.getAge()>25));
		
		//Example4: allMatch "if the stream is empty, automatically returns true"
		System.out.println(Stream.of(dylan, sarah).allMatch(p->p.getAge()>25));
		
		//Example5: noneMatch
		System.out.println(Stream.of(dylan, sarah).noneMatch(p->p.getAge()>25));
			
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
