package main.primitive_versions_of_functional_interfaces;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class PredicatePrimitiveTest {
	
	public static void main(String[] args) {
//		IntPredicate primitivePredicate = i ->{
//			//The following statement cannot compile
//			System.out.println(i instanceof Integer);
//			return i>0;
//		};
		
		Predicate<Integer> wrapperPredicate = i ->{
			//The following statement compiles
			System.out.println(i instanceof Integer);
			return i>0;
		};
		System.out.println(wrapperPredicate.test(10));
		
		DoublePredicate predicate = d->d<1.0;
		System.out.println(predicate.negate().test(0.0));
	}

}
