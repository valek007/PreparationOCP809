package main.primitive_versions_of_functional_interfaces;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class FunctionPrimitiveClass {
	
	public static void main(String[] args) {
		ToIntFunction<String> stringToInt = s->Integer.valueOf(s);
		IntFunction<String> intToString = i->String.valueOf(i+1);
		String result = intToString.apply(stringToInt.applyAsInt("0"));
		System.out.println(result);
	}

}
