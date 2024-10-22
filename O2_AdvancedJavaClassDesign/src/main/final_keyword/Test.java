package main.final_keyword;

@SuppressWarnings("unused")
public class Test {
	
	private static final int cont = 0;
	private static final int num;
	private final int num2;
	private final int num3;
	
	{
		num3 = 3;
	}
	
	public Test() {
		num2 = 2;
	}
	
	public Test(int num2) {
		this.num2 = num2;
	}
	
	static {
		num = 1;
	}
	
	public static void main(String[] args) {
		//cont++; //The final field cannot be assignned
		
		Pet dog = new Dog();
		dog.eat();
	}

}

final class Animal{
	
}

class Pet{
	final void eat() {
		System.out.println("Eating...");
	}
}

//class Dog extends Animal{ //Not possible to extend of final class
//	
//}

class Dog extends Pet{
	
	//Cannot override eat() method
	
}
