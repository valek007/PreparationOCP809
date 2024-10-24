package main.predicate_consumer_function_supplier;

import java.util.function.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		Supplier<Applicant> supplier = provider();
		Applicant a1 = supplier.get();
		Applicant a2 = supplier.get();
		System.out.println("The first dummy applicant's id is "+a1.getId());
		System.out.println("The second dummy applicant's id is "+a2.getId());
	}
	
	public static Supplier<Applicant> provider(){
		return ()->new Applicant("John Doe");
	}

}
