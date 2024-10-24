package main.predicate_consumer_function_supplier;

import java.util.function.Predicate;

public class PredicateTest {
	
	public static void main(String[] args) {
		
		Predicate<Applicant> isMale = a->a.getGender()== Applicant.Gender.MALE;//Basic predicate
		Predicate<Applicant> isWorkingAge = a->a.getAge()>=18&&a.getAge()<65;//Basic predicate
		Predicate<Applicant> isValid = isMale.and(isWorkingAge); //Composite method for first and second predicate
		Applicant a1 = new Applicant("John Doe", Applicant.Gender.MALE, 30);
		Applicant a2 = new Applicant("Jane Roe", Applicant.Gender.FEMALE, 67);
		Applicant a3 = new Applicant("Daniel Moe", Applicant.Gender.MALE, 4);
		verify(a1, isValid);
		verify(a2, isValid);
		verify(a3, isValid);
		
	}
	
	public static void verify(Applicant a, Predicate<Applicant> p) {
		if(p.test(a))
			System.out.println(a.getName()+" is accepted.");
		else
			System.out.println(a.getName()+" is rejected");
	}

}
