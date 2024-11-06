package main.potential_threading_problems;

public class Test {
	
	public static void main(String[] args) {
		//methodDeadlock();
		//methodStarvation();
		//methodLivelock();
		methodRaceConditions();
	}
	
	static void methodDeadlock() {
		//Deadlock describes a situation where two or more threads are blocked forever
		//Deadlock may happen when multiple threads attempt to acquire the same locks
		//at the same time, but in different order
		class LockedTask{
			private String name;
			public LockedTask(String name) {
				this.name = name;
			}
			
			public synchronized void doStart(LockedTask task) {
				System.out.printf("%s is starting\n", name);
				task.doStop();
			}
			
			public synchronized void doStop() {
				System.out.printf("%s is stopping\n",name);
			}
		}
		
		//Execution code
		LockedTask task1 = new LockedTask("Task 1");
		LockedTask task2 = new LockedTask("Task 2");
		new Thread(()->task1.doStart(task2)).start();
		new Thread(()->task2.doStart(task1)).start();
		
		//In this given situation all threads are completly blocked
	}
	
	static void methodStarvation() {
		//Starvation describes a situation where some threads are unable to gain acces to
		//shared resource while it is occupied by other threads.
		//Starvation happens when a greedy thread gains exclusive acces to a resource for a
		//long period of time, leaving other threads no chance to continue, or when a thread
		//keeps failing to acquire a lock due to the competition of other threads.
		class LockedTask{
			public synchronized void printThreadName() {
				int count = 10;
				while(count > 0) {
					try {
						Thread.sleep(1000);
					}catch (InterruptedException e) {
						count--;
						System.out.println(Thread.currentThread().getName());
					}
				}
			}
		}
		//Execution code
		LockedTask task = new LockedTask();
		new Thread(()->task.printThreadName(), "Thread 1").start();
		new Thread(()->task.printThreadName(), "Thread 2").start();
		
		//In this threading situation where multiple threads are treated unfairly,
		//with one thread occupies a share resource while all the others are blocked.
	}
	
	static void methodLivelock() {
		//Livelock describes a situation where multiple threads are busy responding to
		//the acrions of each other; those threads keep execution particular statements
		//resulting in the program being unable to make progress
		
		class Task{
			private volatile boolean value;
			private boolean getValue() {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {	
				}
				return value;
			}
			
			public void setSame(Task task) {
				while(value!=task.getValue()) 
					value = !value;
			}
			
			public void setOpp(Task task) {
				while(value == task.getValue())
					value = !value;
			}
		}
		
		//Execution code
		Task task1 = new Task();
		Task task2 = new Task();
		new Thread(()->task1.setOpp(task2)).start();
		try {
			Thread.sleep(500);
		}catch (InterruptedException e) {
		}
		new Thread(()->task2.setSame(task1)).start();
		
		//In this situation threads keep running but no progress
	}
	
	static void methodRaceConditions() {
		//Race conditions are situations where multiple threads access and change
		//the same resources at the same time, resulting in unpredictable outcomes
		class Task{
			private int count;
			public synchronized void increaseCount() {
				for(int i= 0; i<1000000; i++) {
					count = count +1;
				}
			}
			public int getCount() {
				return count;
			}
		}
		//execution code
		Task task = new Task();
		new Thread(()->task.increaseCount()).start();
		new Thread(()->task.increaseCount()).start();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		System.out.println(task.getCount());
	}

}
