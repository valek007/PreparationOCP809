package main.polymorphism;

public class Sub1 extends Super {

	@Override
	public void print() {
		System.out.println(txt.toLowerCase());

	}

	@Override
	public void changeValue() {
		num++;
	}

}
