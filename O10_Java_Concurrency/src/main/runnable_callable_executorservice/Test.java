package main.runnable_callable_executorservice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) throws Exception {
		methodRunnable();
		methodCallable();
		methodExecutor();
	}

	static void methodRunnable() {
		// Runnable is a functional interface, designed to be implemented by classes
		// whose instances are intended to be executed by another thread.
		// The runnable interface defines a single abstract ,ethod, named run,
		// wich takes no argumnets and returns no value
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 2 completed.");
			}
		};
		new Thread(runnable).start();
		System.out.println("Thread 1 completed.");
	}

	static void methodCallable() throws Exception {
		// Callable is a functional interface, designed to be implemented by classes
		// whose instances are intended to be executed by another thread
		// The Callable interface defines a single abstract method, named call, wich
		// takes no arguments, returns a value and may thro a checked exception
		// V call() throws Exception
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Hello world!";
			}
		};
		System.out.println(callable.call());
	}

	static void methodExecutor() throws InterruptedException, ExecutionException {
		// The Executor interface represents objects that execute submitted Runnable
		// tasks,
		// providing way of decoupling task submission from task execution.
		// ExecutorService is a subinterface of Executor, declaring additional methods
		// to
		// execute Callable tasks and methods to shut down the executor.
		// Executor Service objects can be created from factory methods defined in the
		// Executors class.
		// An ExecutorService mus be shut down when it is no longer needed to avoid
		// threads keeping running.
		ExecutorService executor1 = Executors.newFixedThreadPool(4);
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		// executing tasks
		executor1.shutdown();
		executor2.shutdownNow();

		// A Future object represents the result of an asyncronous computation
		// The result wrapped in a Future can be retrieved using the get method; when
		// the computation has not completed, int can be cancelled by the cancel method.
		// V get() throws InterruptedException, ExecutionException
		// boolean cancel(boolean mayInterruptIfRunning)

		// A Runnable task can be submitted for execution using the submit method of
		// ExecutorService
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
//		Runnable runnable = () -> {
//			int result = 0;
//			for (int i = 0; i <= 100000; i++) {
//				result += i;
//				System.out.println("result: " + result);
//			}
//		};
//		executor.submit(runnable);
//		executor.shutdown();
//		System.out.println("Task submitted");

		// A Callable task can be submitted for execution using the submit method of
		// ExecutorService
		Callable<Integer> callable = () -> {
			int result = 0;
			for (int i = 0; i <= 100000; i++)
				result += i;
			return result;
		};
		Future<Integer> future = executor.submit(callable);
		//do something in the main thread
		int result = future.get();
		executor.shutdown();
		System.out.println("Task completed - result: "+result);
		
		//The invokeAny method of ExecutorService executes a collection of tasks,
		//returning the result of one that has completed successfully, if any.
		Callable<String> task1 = ()->"Task 1";
		Callable<String> task2 = ()->"Task 2";
		Collection<Callable<String>> tasks = Arrays.asList(task1,task2);
		executor = Executors.newCachedThreadPool();
		String result2 = executor.invokeAny(tasks);
		executor.shutdown();
		System.out.println(result2);
		
		//The invokeAll method of ExecutorService executes a collection of tasks, returning
		//a list of Future instances that hold the result of those tasks when they all complete
		executor = Executors.newCachedThreadPool();
		List<Future<String>> futures = executor.invokeAll(tasks);
		executor.shutdown();
		for(Future<String> f: futures)
			System.out.println(f.get());
	}

}
