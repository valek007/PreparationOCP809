package main.use_parallel_streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		//The Stream API facilitates parallel execution by reframing the computation as a pipeline of aggregate operations
		//A stream pipeline should produce the same result regardless of whether it is executed sequentially or in parallel
		//You can create a parallel stream from a source collection using the parallelStream method:
		Stream<String> parallelStream = Arrays.asList("A","B").parallelStream();
		//A parallel stream can also be constructed by calling the parallel method on a sequential stream:
		Stream<String> sequentialStream = Arrays.asList("A","B").stream();
		parallelStream = sequentialStream.parallel();
		parallelStream.forEach(System.out::println);//Print B A
		//You can check whether a stream is parallel or sequential using the isParallel method:
		boolean isParallel = parallelStream.isParallel();
		System.out.println(isParallel); //print true
		//The Stream interface defines a reduce method, partioning elements of a parallel stream into multiple
		//sub-streams, the processing cach sub-stream in a separate thread, and finally combining the results:
		//<U> U reduce(U identity, BiFunction<U,? super T, U> accumulator, BinaryOperator<U> combiner)
		Stream<String> stream = Arrays.asList("a","b","c","d","e","f","g").parallelStream();
		String result = stream.reduce("", String::concat, (s1, s2)->s1+s2);
		System.out.println(result);//print abcdefg
		//The collect method of the Stream interface has an overloaded form that processes elements of a parallel stream
		//in separate threads, then combines their result:
		//<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R, R> combiner>
		Stream<String> stream2 = Arrays.asList("a","b","c","d","e","f","g").parallelStream();
		StringBuffer result2 = stream2.collect(StringBuffer::new, StringBuffer::append, StringBuffer::append);
		System.out.println(result2); //print abcdefg
		//An overloaded form of the Stream::collect method performs a mutable reduction on elements of the current stream using
		//a Collector; you can specify a concurrent collector when working on parallel streams for better performance:
		//<R, A> R collect(COllector<? super T, A R> collector)
		//Code example using the Collectors::groupingByConcurrent method:
		Stream<Integer> stream3 = Arrays.asList(1,2,3,4,5,6).parallelStream();
		ConcurrentMap<Boolean, List<Integer>> map = stream3.collect(Collectors.groupingByConcurrent(i->i%2==0));
		System.out.println(map);//print {false=[5, 1, 3], true=[2, 6, 4]}
		//Code example using the Collectors::toConcurrentMap method:
		Stream<String> stream4 = Arrays.asList("java","oracle").parallelStream();
		ConcurrentMap<String, Integer> map2 = stream4.collect(Collectors.toConcurrentMap(String::toUpperCase, String::length));
		System.out.println(map2);//print {JAVA=4, ORACLE=6}
		
		
	}

}
