package main.optional_class;

import java.util.Optional;

public class Test {

	public static void main(String[] args) {

		Person person = new Person();

		//Example 1:		
		//Million dollar mistake String street = person.getAddress().getStreet();
		//System.out.println(street); //NullPointerException
		

		//Example 2: This code works, but is less readable and more harder to maintain.
		//String street = null; Address address = person.getAddress();
		//if(address!=null) { street = address.getStreet(); }
		//System.out.println(street);
		 
		//Example 3:
		//String street = person.getAddress().get().getStreet();
		//System.out.println(street); //NoSuchElementException 
		
		//Example 4:
		Optional<Address> opAddress = person.getAddress();
		String street = null;
		if(opAddress.isPresent()) {
			street=opAddress.get().getStreet();
		}
		System.out.println(street);
		
		//Example 5;
		Optional<String> opString = Optional.of("Hello World");
		opString.ifPresent(System.out::println);
		Optional<String> opEmpty = Optional.empty();
		opEmpty.ifPresent(System.out::println);
		
		
		//Example 6:
		Optional<Integer> opInteger = Optional.of(2);
		Optional<Integer> opFilter = opInteger.filter(i->i%2==0);
		System.out.println(opFilter.isPresent());
		
		
		//Example 7:
		Optional<String> opString2 = Optional.of("Hello World");
		Optional<Integer> opLength = opString2.map(s -> s.length());
		System.out.println(opLength.get());
		
		//Example 8:
		Optional<String> opLowerCase = Optional.of("abcdefg");
		Optional<String> opUpperCase = opLowerCase.flatMap(s->Optional.of(s.toUpperCase()));
		System.out.println(opUpperCase.get());

	}

	static class Person {

		private Optional<Address> address = Optional.empty();

		public Optional<Address> getAddress() {
			return address;
		}

		public void setAddress(Optional<Address> address) {
			this.address = address;
		}

	}

	static class Address {
		private String street;

		public Address(String street) {
			this.street = street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getStreet() {
			return street;
		}

	}

}
