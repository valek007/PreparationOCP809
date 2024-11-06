package main.use_parallel_fork_join_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Test {
	
	public static void main(String[] args) {
		//The fork/join framework is designed for work that can be broken into smaller
		//pieces recursively, allowing you to take advantage of multiple processors
		//The frok/join framework distributes tasks to worker threads in a thread pool,
		//wich employs a work-stealing algorithm
		//The main component of the for/join framework is the ForkJoinPool class
		//representing thread pools and executing ForkJoinTask processes
		
		//ForkJoinPool is an implementation of the ExecutorService interface, providing the entry
		//point for task submission and management
		//A ForkJoinPool instance can be created using a static factory method or a constructor:
		//commonPool(): Returns the common pool instance, the default thread pool for a ForkJoinTask
		//ForkJoinPool(): Creates a ForkJoinPool with parallelism level equal to the number of available processors
		//ForkJoinPool(int parallelism): Creates a ForkJoinPool with the specified parallelism level
		//Important method:
		//<T> T invoke(ForkJoinTask<T> task): Performs the given task and returns its result upon completion
		
		//ForkJoinTask is an abstract base class representing tasks running within a ForkJoinPool
		//Tasks are usually submitted and retrieved via the forn and join methods, or their derivatives invoke and invokeAll:
		//fork: Asynchronously executes this task in the pool
		//join: Returns the result of the computation when it is done
		//invoke: Performs this task, awaits its completion and returns its result
		//invokeAll: Performs all the given tasks, then awaits their completion
		//Two subclasses of ForkJoinTask, namely RecursiveAction and RecursiveTask, are often extended to indicate tasks
		
		//The only abstract method that must be implemented by a subclass of
		//RecursiveAction and RecursiveTask is named compute.
		//You should adhere to the folowing algorithm inside the compute method
		//to implement the fork/join framework:
		//if(the given work is small enough)
		//   do the work directly
		//else
		//   split the work into multiple pieces
		//   invoke those pieces and wait for the results
		
		//execution code RecursiveAction
		ForkJoinPool pool = ForkJoinPool.commonPool();
		MyAction action = new MyAction("Java");
		pool.invoke(action);
		//console output:
		//74-printed by ForkJoinPool.commonPool-worker-1
		//97-printed by ForkJoinPool.commonPool-worker-3
		//118-printed by ForkJoinPool.commonPool-worker-2
		//97-printed by ForkJoinPool.commonPool-worker-2
		
		System.out.println();
		//execution code RecursiveTask
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			numbers.add(i);
		}
		MyTask task = new MyTask(numbers);
		ForkJoinPool pool2 = new ForkJoinPool();
		int result = pool2.invoke(task);
		System.out.println(result);// print"499500"
		
		
	}
	
	static class MyAction extends RecursiveAction{

		private static final long serialVersionUID = 1L;
		private String word;
		
		public MyAction(String word) {
			this.word = word;
		}

		@Override
		protected void compute() {
			if(word.length()<=1) {
				System.out.println(word.codePointAt(0)+"-printed by "+Thread.currentThread().getName());
				return;
			}
			MyAction action1 = new MyAction(word.substring(0, word.length()/2));
			MyAction action2 = new MyAction(word.substring(word.length()/2));
			ForkJoinTask.invokeAll(action1, action2);
		}
	}
	
	static class MyTask extends RecursiveTask<Integer>{
		
		private static final long serialVersionUID = 1L;
		private List<Integer> numbers;
		
		public MyTask(List<Integer> numbers) {
			this.numbers = numbers;
		}

		@Override
		protected Integer compute() {
			if(numbers.size()<=100) {
				return numbers.stream().mapToInt(i->i).sum();
			}
			MyTask task1 = new MyTask(numbers.subList(0, numbers.size()/2));
			MyTask task2 = new MyTask(numbers.subList(numbers.size()/2, numbers.size()));
			task1.fork();
			task2.fork();
			return task1.join()+task2.join();
		}
		
	}

}
