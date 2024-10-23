package main.create_and_use_generic_class;

import java.util.ArrayList;
import java.util.List;

//Allowing for stranger type checks at compile time
//Elimination of casting
public class Test {

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public static void main(String[] args) {

		// non-generic
		List list1 = new ArrayList();
		list1.add("Hello");
		String element = (String) list1.get(0);

		// generic
		List<String> list2 = new ArrayList<String>();
		list2.add("Hello");
		element = list2.get(0);

		Person<String, Integer> person = new Person<>("Pedro", 18);
		System.out.println(person.getName() + " " + person.getAge());
		
		Integer num = 0;
		Data data = new Data<Number>(num);
		Integer num2 = (Integer) data.getVar();
		System.out.println(num2);

	}

}

class Person<S, T extends Number> {

	private S name;
	private T age;

	public Person(S name, T age) {
		this.name = name;
		this.age = age;
	}

	public S getName() {
		return name;
	}

	public T getAge() {
		return age;
	}
}

class Data<T extends Number> {

	private T var;

	public Data(T var) {
		this.var = var;
	}

	public T getVar() {
		return var;
	}

}
