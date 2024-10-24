package main.binary_versions_of_functional_interfaces;

import java.util.function.BiPredicate;

public class BiPredicateClass {
	
	public static void main(String[] args) {
		
		BiPredicate<Integer, Double> predicate = (i,d)->i>d;
		boolean result = predicate.test(0, 1.0);
		if(result)
			System.out.println("The integer is greater than the double");
		else
			System.out.println("The integer is not grater than the double");
		
		BiPredicate<String, Integer> predicate2 = (s,i)->s.length()==i;
		if(predicate2.or(predicate2.negate()).test("Hello", 10))
			System.out.println("Correct");
		
	}

}
