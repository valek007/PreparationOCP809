package main.inheritance;

public class Test {
	
	public static void main(String[] args) {
		Super obj = new Sub();
		System.out.println(obj.text);
		obj.print("Hi!");
	}

}
