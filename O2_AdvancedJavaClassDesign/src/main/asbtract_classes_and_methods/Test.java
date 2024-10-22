package main.asbtract_classes_and_methods;

public class Test {
	
	public static void main(String[] args) {
		
		//Animal animal = new Animal(); //Cannot instantiate the type Animal
		//animal.eat(); //also we cannot use it 
		Animal dog = new Dog();
		dog.eat();
		dog.doSomething();
		
		
	}

}

abstract class Animal{
	
	abstract void eat(); //Abstract method just can use it on the interfaces or abstract classes
	
	public void doSomething() {
		System.out.println("Animal is doing something..."); //Is legal contain no-abstract methods
	}
	
	public Animal() {
		System.out.println("Hello world"); //Its legal to declare an constructor but we cannot instantiate Animal
	}
}

class Dog extends Animal{

	@Override
	void eat() {
		System.out.println("Dog is eating...");
		
	}
	
}
