package main.singleton_inmutable_clases;

/*
 Definition of a singleton class:
  - is a class that allows only one instance to be created
 Common components:
  - A private constructor that prevents the class from being instantiated from outside.
  - A public static method returning the only object of the class
 Singleton implementations:
  - Lazy initialization
  - Initialization-on-demand holder idiom
  - Eager initialization
  - Using ENUM
 */

//- Lazy initialization
public class SingletonClass {

	private static SingletonClass INSTANCE;

	private SingletonClass() {
	}

	public synchronized static SingletonClass getInstance() { // thread safe
		if (INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
}

//- Initialization-on-demand holder idiom
class SingletonClass2 {

	private SingletonClass2() {
	}

	private static class SingletonHolder {
		private static final SingletonClass2 INSTANCE = new SingletonClass2();
	}

	public static SingletonClass2 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}

//- Eager initialization
class SingletonClass3 {
	private static final SingletonClass3 INSTANCE = new SingletonClass3();

	private SingletonClass3() {
	}

	public static SingletonClass3 getInstance() {
		return INSTANCE;
	}
}

//- Using ENUM "The best implementation of the Singleton pattern"
class SingletonClass4 {
	@SuppressWarnings("unused")
	private static final SingletonClass4 INSTANCE = new SingletonClass4();

	private SingletonClass4() {
	}
	
	//This must to be public out of the class in the own file
	enum Singleton{
		INSTANCE
	}
}


