package main.primitive_versions_of_functional_interfaces;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class ConsumerPrimitiveClass {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
//		DoubleConsumer primitiveConsumer = d->{
//			//The following statement cannot compile
//			System.out.println(d.intValue());
//		};
		
		Consumer<Double> wrapperConsumer = d->{
			//The following statement compiles
			System.out.println(d.intValue());
		};
		
		LongConsumer consumer = System.out::println;
		consumer.andThen(consumer).accept(1);
	}

}
