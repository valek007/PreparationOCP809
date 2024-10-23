package main.stream_interface_and_pipeline;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		
		Collection<Integer> collection = Arrays.asList(1,2,3,4,5,6);
		Stream<Integer> stream = collection.stream();
		//Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
		stream.filter(i->i%2==0).filter(i->i%3==0).forEach(i->System.out.println(i));
		
		Stream<String> names = Stream.of("John","Jane");
		names.filter(n->{
			System.out.println(n);
			return n.equals("John");
		}).forEach(n->System.out.println(n));
	}

}
