package main.overriding_hashcode_equals_tostring;

import java.util.HashSet;

public class Test {
	
	public static void main(String[] args) {
		
		HashSet<MyClassHashCode> set = new HashSet<>();
		MyClassHashCode obj1 = new MyClassHashCode(1);
		MyClassHashCode obj2 = new MyClassHashCode(2);
		set.add(obj1);
		set.add(obj2);
		System.out.println(set.size());
		//Before override equals it was result 2
		
		boolean equality = obj1.equals(obj2);
		System.out.println(equality);
		//After override equals now the result is 1
		
		System.out.println(obj1);
		System.out.println(obj2);
		
	}

}
