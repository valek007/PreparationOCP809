package main.develop_code_keywords;

@SuppressWarnings("unused")
public class Test3 {

	private static int staticValue = 0;
	private int instanceValue = 1;

	public static void main(String[] args) {
		// instanceValue = 10; Not allowed
		// method(); Not allowed

		new Test3().method();
	}

	public void method() {
		staticValue = 10;
		instanceValue = 5;
	}

}
