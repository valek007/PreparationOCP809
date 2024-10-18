package main.develop_code_keywords;

public class Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Data data = new Data();
		Data data2 = new Data();

		System.out.println(data.instanceValue + " " + Data.staticValue);

		data.instanceValue = 5;
		Data.staticValue = 10;

		System.out.println(data.instanceValue + " " + data.staticValue);

		System.out.println(data2.instanceValue + " " + data2.staticValue);

		data.instanceMethod();
		Data.staticMethod();
	}
}

class Data {

	public int instanceValue = 0;
	public static int staticValue = 1;

	static {
		System.out.println("I am first, but unique");
		// instanceValue = 10; not allowed
		staticValue = 1;
		
		//instanceMethod(); not allowed
		staticMethod();
	}

	{
		System.out.println("I am second and I appear with my initialization");
		this.instanceValue = 0;
		staticValue = 1;
		instanceMethod();
		staticMethod();
		
	}

	public Data() {
		System.out.println("I am third");
		this.instanceValue = 0;
		staticValue = 1;
	}

	// Instance Method
	public void instanceMethod() {
		instanceValue = 0;
		staticValue = 1;

		System.out.println("Instance Method");
	}

	// Static or Class method not need instance of the class
	public static void staticMethod() {
		// instanceValue = 10; not allowed
		staticValue = 1;

		System.out.println("Static Method");
	}
}
