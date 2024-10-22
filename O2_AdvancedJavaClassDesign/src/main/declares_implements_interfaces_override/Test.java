package main.declares_implements_interfaces_override;

public class Test {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		MyClass myClass = new MyClass();
		myClass.method1();
		MyInterface.method2();
		myClass.method3();
		
		MyInterface myInterface = new MyInterface() {
			
			@Override
			public void method1() {
				System.out.println("method 1.2");
				
			}
		};
		
		myInterface.method1();
		MyInterface.method2();
		myInterface.method3();
		
		System.out.println(myInterface.variable);
		System.out.println(MyInterface.variable);
		
		myClass.method4();
		myInterface.method4();
	}
}

interface MyInterface{
	
	String variable = " Variable"; //is implicitly public, static and final
	
	void method1(); //abstract method
	
	static void method2() { //the static method cannot be inherited or used in the interface instance
		System.out.println("method 2"+variable);
		//variable = "Hello"; that is not legal because it is final
	}
	
	default void method3() { //default method
		System.out.println("method 3"+variable);
	}
	
	default void method4() {
		method2(); //is legal
	}
	
}

class MyClass implements MyInterface{

	@Override
	public void method1() { //forced to override
		System.out.println("method 1");
	}	
}

class MyClass2 extends MyClass{
	
	@Override
	public void method3() { //not required to override
		System.out.println("method 3.2");
	}
}
