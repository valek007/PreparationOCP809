package main.polymorphism;

public class Test {
	
	public static void main(String[] args) {
		Super super1 = new Super();
		Super sub = new Sub1();
		
		super1.print();
		sub.print();
		
		sub = new Sub2();
		sub.print();
		
		Sub1 sub1 = new Sub1();
		Sub2 sub2 = new Sub2();
		
		sub1.changeValue();
		sub2.changeValue();
		
		System.out.println(super1.num+" "+sub1.num+" "+sub2.num);
	}

}
