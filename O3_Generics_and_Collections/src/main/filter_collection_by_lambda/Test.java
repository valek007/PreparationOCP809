package main.filter_collection_by_lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		Collection<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);

		collection.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});
		
		for(Integer number: collection) {
			System.out.print(number+" ");
		}
		
		System.out.println();
		Stream<Integer> originalStream = Stream.of(0,-1,1,-2,2);
		Stream<Integer> filteredStream = originalStream.filter(i->i>0);
		filteredStream.forEach(i->System.out.print(i+" "));
	}

}
