package main.primitive_versions_of_functional_interfaces;

import java.util.function.DoubleSupplier;
import java.util.function.LongSupplier;

public class SupplierPrimitiveClass {
	
	public static void main(String[] args) {
		DoubleSupplier supplier = ()->{
			double number = (Math.random()*10)+1;
			
			return number;
		};
		System.out.println("The random number is: "+supplier.getAsDouble());
		
		LongSupplier supplier2 = ()->Long.MAX_VALUE;
		System.out.println(supplier2.getAsLong());
	}

}
