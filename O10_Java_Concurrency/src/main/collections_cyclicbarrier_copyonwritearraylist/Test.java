package main.collections_cyclicbarrier_copyonwritearraylist;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class Test {
	
	public static void main(String[] args) {
		//CyclicBarrier is a synchronization class that allows a set of threads to wait for
		//each other when reaching a common barrier point
		//A CyclicBarrier instance can be created with a a Runnable task that is run once
		//per barrier point, after all threads arrive and before any threads are released
		//Constructors: CyclicBarrier(int parties) CyclicBarrier(int parties, Runnable barrierAction)
		//await: Waits until all parties have invoked await on the barrier
		//getNumberWaiting: Returns the number of parties currently waiting at the barrier
		//getParties: Returns the number of parties required to trip the barrier
		//isBroken: Checks if the barrier is in the broken state
		//reser: Resets the barrier to its initial state
		CyclicBarrier barrier = new CyclicBarrier(2, ()->System.out.println("Threads released"));
		Runnable task1 = ()->{
			for(int i=1; i<=2; i++) {
				try {
					barrier.await();
				}catch(InterruptedException | BrokenBarrierException e) {}
				System.out.println("Thread 1 - round "+i);
			}
		};
		Runnable task2 = ()->{
			for(int i=1; i<=2; i++) {
				try {
					Thread.sleep(1000);
					barrier.await();
				}catch(InterruptedException | BrokenBarrierException e) {}
				System.out.println("Thread 2 - round "+i);
			}
		};
		new Thread(task1).start();
		new Thread(task2).start();
		//console output
		//Threads released
		//Thread 1 - round 1
		//Thread 2 - round 1
		//Threads released
		//Thread 2 - round 2
		//Thread 1 - round 2
		
		//CopyOnWriteArrayList is a thread-safe varian of the ArrayList class in wich all mutative
		//operations are implemented by making a copy of the uderlying array
		//When an Iterator instance is created to iterate over elements in the list, it provides
		//a snapshot state of the list at the point that the iterator was constructed
		//Methods:
		//addIfAbsent: Appends the given element if it is not already present in the list
		//addAllAbsent: Appends elements in the given collection that are not existent in the list
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("Hello");
		list.add("How are you?");
		Iterator<String> iterator = list.iterator();
		list.add("OCPJP");
		list.remove(0);
		while(iterator.hasNext()) {
			//Print Hello How are you?
			System.out.println(iterator.next());
		}
		
	}

}
