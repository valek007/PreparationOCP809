package main.syncronized_and_atomic_package;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Test {
	
	public static void main(String[] args) {
		methodAtomic();
	}
	
	static void methodIntrinsicLocks() {
		@SuppressWarnings("unused")
		//Intrinsic locks, also called monitors, are internal entities associated with objects
		//Every object has exaclty one instrinsic lock, enforcing exclusive access to the code associated with that
		//object and establishing happens-before relationships with susequent acquisitions of the same lock
		
		
		//Synchronized methods are methods declared with the synchronized keyword
		//When a thread invokes a synchronized method, it acquires the intrinsic lock
		//on the method's object and releases that lock when the method returns
		class Data{
			private int number;
			public synchronized void increase() {
				number++;
			}
			public synchronized void decrease() {
				number--;
			}
			public synchronized int getNumber() {
				return number;
			}
		}
		
		//The synchronized keyword can also be declared on blocks of code
		//The object that provides the intrinsic lock must be specified in a synchronized block
		@SuppressWarnings("unused")
		class Data2{
			private int number1;
			private int number2;
			private Object monitor1 = new Object();
			private Object monitor2 = new Object();
			public synchronized void increaseNumber1() {
				synchronized(monitor1) {
					number1++;
				}
			}
			public synchronized void decreaseNumber2() {
				synchronized(monitor2) {
					number2--;
				}
			}
			//other declarations
		}
	}
	
	@SuppressWarnings("unused")
	static void methodAtomic() {
		//-AtomicBoolean
		//-AtomicInteger
		//-AtomicLong
		//-AtomicReference
		
		//You can create an instance of an atomic class using its no-argument constructor,
		//of the constructor with a parameter of the appropriate type
		AtomicBoolean atomicBoolean = new AtomicBoolean(true);
		AtomicInteger atomicInteger = new AtomicInteger(10);
		AtomicLong atomicLong = new AtomicLong(1L);
		AtomicReference<String> atomicRef = new AtomicReference<>("Hello World");
		
		//The value enclosed in an atomic instance can be retrieved using the get method
		int intValue = atomicInteger.get();
		String text = atomicRef.get();
		
		//Atomic classes define a method supporting conditional update operations, named compareAndSet
		//this method sets a variable to a new value if it currentlu holds the expected value
		atomicRef.compareAndSet("Hello World", "Hello!");
		System.out.println(atomicRef); //print Hello!
		
		//Each atomic class contains two methods unconditionally setting an instance to a new value,
		//including set and getAndSet, the set method sets the instance to a value and does not return
		//anything, while getAndSet atomically sets it to the new value and returns the previous one
		boolean boolValue = atomicBoolean.getAndSet(false);//boolValue == true
		atomicBoolean.set(true);
		int intValue2 = atomicInteger.getAndSet(0);//intValue2 == 10
		atomicInteger.set(100);
		
		//addAndGet: Atomically adds the given value to the curret value, returning the updated value
		//getAndAdd: Atomically adds the given value to the current value, returning the previous value
		//incrementAndGet: Atomically increments the current value by one, returning the updated value
		//getAndIncrement: Atomically increments the current value by one, returnint the previous value
		//decrementAndGet: Atomically decrements the current value by one, returning the updated value
		//getAndDecrement: Atomically decrements the current value by one, returning the previous value
		
		AtomicInteger aInt = new AtomicInteger(5);
		int intVal1 = aInt.getAndIncrement();//intVal1 == 5
		int intVal2 = aInt.getAndAdd(-5);//intVal2 == 6
		int intVal3 = aInt.decrementAndGet();//intVal3 == 0
		AtomicLong aLong = new AtomicLong(10L);
		long longVal1 = aLong.incrementAndGet();//longVal1 == 11
		long longVal2 = aLong.addAndGet(5);//longVal2 == 16
		long longVal3 = aLong.getAndIncrement();//longVal3 == 16
		
		//updateAndGet: Atomically updates the current value with the result of applying the given function, returning the updated value
		//getAndUpdate: Atomically updates the current value with the result of applying the given function, returning the previos value
		//accumulateAndGet: Atomically updates the current value with the result of applying the given function to the current and given values, returning the updated value
		//getAndAccumulate: Atomically updates the current value with the result of applying the given function to the current and fiven values, returning the previous value
		AtomicInteger aInteger = new AtomicInteger(2);
		int integerValue1 = aInteger.updateAndGet(i->5*i);//integerValue1 = 10
		int integerValue2 = aInteger.accumulateAndGet(10, (i1,i2)->i1+i2);//integerValue2 == 20
		AtomicReference<String> atRef = new AtomicReference<String>("abcdef");
		String text1 = atRef.getAndUpdate(s->s.toLowerCase());//text1 == "ABCDEF"
		String text2 = atRef.getAndAccumulate("Welcome to ", (s1,s2)->s2+s1);//text2 == "abcdef"
	}

}
