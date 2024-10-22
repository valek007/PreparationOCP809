package main.declares_implements_interfaces_override;

public class Test2 {
	
	public static void main(String[] args) {
		
		//MyInterface2.method1(); Cannot make reference to non-static method1
		//MyInterface2.method2(); Cannot make reference to non-static method2
		
		MyInterface2 myInterface2 = new MyInterface2() {
			
			@Override
			public void method1() {
				
				System.out.println("Hello");
			}
		};
		
		myInterface2.method2();
	}

}

interface MyInterface2{
	
	void method1();
	
	default void method2() {
		method1();
	}
	
	static void method3() {
		//method1(); Cannot make reference to non-static method1
	}
}

/*
class MyClass3 implements MyInterface2{

	@Override
	default void method1() { cannot reduce the visibility of inherit method, what is already public
	}
	
	@Override
	void method1() { cannot reduce the visibility of inherit method, what is already public
	}	
}*/
