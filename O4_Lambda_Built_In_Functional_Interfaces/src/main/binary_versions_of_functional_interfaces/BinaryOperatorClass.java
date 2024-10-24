package main.binary_versions_of_functional_interfaces;

import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;

public class BinaryOperatorClass {
	
	public static void main(String[] args) {
		BinaryOperator<String> biOperator = (s1, s2)->s1.concat(".").concat(s2);
		String line = biOperator.apply("Hello", "World");
		System.out.println(line);
		
		LongBinaryOperator longOperator = (l1,l2)->l1+l2;
		long result = longOperator.applyAsLong(10L, -9L);
		System.out.println(result);
		
		BinaryOperator<Double> operator = (d1, d2)->d1*d2;
		double result2 = operator.apply(1.2, 2.2);
		System.out.println(result2);
		
		
	}

}
