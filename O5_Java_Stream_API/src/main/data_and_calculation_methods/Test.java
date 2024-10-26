package main.data_and_calculation_methods;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
count: Returns a long value representing the number of elements of the stream
min: Returns an optional instance describing the minimum element of the stream
max: Returns an optional instance describing the maximum element of the stream
reduce: Perfomrs a reduction operation on elements of the stream
average: Returns an OptionalDouble describing the arithmetic mean of elements of the stream, or an empty optional if the stream is empty
sum: Returns the total value of elements of the stream
 */
public class Test {
	
	public static void main(String[] args) {
		
		//1 count method
		long count = Stream.of("A","B","C").count();
		System.out.println(count); //print 3
		
		//2 min method
		Collection<Integer> source = Arrays.asList(3,1,4,5,2);
		Optional<Integer> opMin = source.stream().min(Integer::compare);
		System.out.println(opMin.get()); //print 1
		
		//3 max method
		Optional<Integer> opMax = source.stream().max(Integer::compare);
		System.out.println(opMax.get()); //print 5
		
		//4 reduce method
		//first method reduce(BinaryOperator<T> accumulator)
		Optional<Integer> result1 = Stream.of(0,2,4,1,3,5).reduce(Integer::sum);
		System.out.println(result1.get()); //print 15
		
		Optional<String> result2 =Stream.of("A","B","C").reduce((s1,s2)->s2+s1);
		System.out.println(result2.get()); //Print CBA
		
		//second method reduce(T identity, BinaryOperator<T> accumulator)
		int result3 = Stream.of(1,2,4,1,3,5).reduce(1, (i,j)->i*j);
		System.out.println(result3); //print 120
		
		//5 average method
		OptionalDouble opAverage = IntStream.of(0,2,4,1,3,5).average();
		double average = opAverage.getAsDouble(); //Only works on Primitive Stream
		System.out.println(average);//print number 2,5
		
		//6 sum method
		int sum = IntStream.of(0,2,4,1,3,5).sum(); //Only works on Primitive Stream
		System.out.println(sum); //print 15
		
		
	}

}
