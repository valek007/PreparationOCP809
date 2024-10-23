package main.iterate_streams_and_list;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.of(1,2,3);
		
		stream.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				t = 2*t;
				System.out.print(t+" ");
			}
		});
		
		System.out.println();
		
		List<String> list = Arrays.asList("j","a","v","a");
		list.forEach(s->{
			s = s.toUpperCase();
			System.out.print(s);
		});
	}

}
