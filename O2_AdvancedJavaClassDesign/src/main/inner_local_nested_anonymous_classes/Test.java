package main.inner_local_nested_anonymous_classes;

public class Test {
	
	public static void main(String[] args) {
		
		Outer outerClass = new Outer();
		Outer.Inner innerClass = outerClass.new Inner();
		Outer.StaticInner innerStaticClass = new Outer.StaticInner();
		outerClass.method();
		innerClass.method();
		innerStaticClass.method();
		
		class LocalClass{ //only abstract and final modifier is allowed
			
			{
				System.out.println("Local Class");
			}
			
			public void method() {
				System.out.println("Local Class method");
			}
			
		}
		LocalClass localClass = new LocalClass();
		localClass.method();
		
		ExampleAnonymousClass anonymousClass = new ExampleAnonymousClass() { //Can use only final variables
			
			@Override
			public void method() {
				System.out.println("Anonymous class method");		
			}
		};
		anonymousClass.method();
		
		
	}
	
	interface ExampleAnonymousClass{
		void method();
	}

}

class Outer{ // Can be only public or default
	
	{
		System.out.println("Outer Class");
	}
	
	public void method() {
		System.out.println("Outer Method");
	}
	
	class Inner{
		
		private final static int num = 1; //constants can be only primitive use not Integer object for example, without final is error to
		
		{
			System.out.println("Inner Class");
		}
		
		public void method() {
			System.out.println("Inner Method "+num);
		}
		
	}
	
	static class StaticInner{
		
		static {
			System.out.println("Static Inner Class");
		}
		
		public void method() {
			System.out.println("Inner Static Method");
		}
	}
}
