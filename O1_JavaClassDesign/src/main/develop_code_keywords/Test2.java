package main.develop_code_keywords;

public class Test2 {
	
	public static void main(String[] args) {
		
		Outer.Nested nestedObject = new Outer.Nested();
		System.out.println(nestedObject);
	}

}

@SuppressWarnings("unused")
class Outer{
	private static String outerVar;
	
	@SuppressWarnings("static-access")
	private String innerVar = new Outer().outerVar;
	
	public static class Nested{
		
		private String innerVar = outerVar;
	}
}
