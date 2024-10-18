package main.polymorphism;

public class Sub2 extends Super{

	@Override
	public void print() {
		System.out.println(txt.toUpperCase());
	}
	
	@Override
	public void changeValue() {
		num--;
	}
}
