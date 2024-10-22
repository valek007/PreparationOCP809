package main.lambda_expressions;

public class Test {
	
	public static void main(String[] args) {
		
		Printable printable = new Printable() { //Anonymous class
			
			@Override
			public void print() {
				System.out.println("Anonymous declaration");
				
			}
		};
		printable.print();
		
		Printable printable2 = () -> System.out.println("Lambda expression");
		printable2.print();
		
		String output = handleText(s -> {
			System.out.println("Converting a "+s+" to uppercase.");
			return s.toUpperCase();
		}, "hello world!");
		System.out.println(output);
		
		int result = compute().calculate(2, 3);
		System.out.println("2 + 3 is: "+result);
		
		boolean max = compare().compare(10, 5);
		System.out.println("10 is more than 5? "+max);
		
		
	}
	
	public static String handleText(Convertible convertible, String input) {
		return convertible.convert(input);
	}
	
	public static Calculation compute() {
		return (int num1, int num2) -> num1 + num2;
	}
	
	public static Comparison compare() {
		return (num1, num2) -> num1 > num2;
	}

}

@FunctionalInterface
interface Printable{//Just can have one abstract method
	
	void print();
	
	//void print2(); //Alert: Printable is not now a functional method
	
	default void defaultMethod() {
		System.out.println("default method"); //Its allowed
	}
	
	static void staticMethod() {
		System.out.println("static method"); //Its allowed
	}
}

@FunctionalInterface
interface Convertible{
	String convert(String args);
}

@FunctionalInterface
interface Calculation{
	int calculate(int num1, int num2);
}

@FunctionalInterface
interface Comparison{
	boolean compare(int num1, int num2);
}
