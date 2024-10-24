package main.predicate_consumer_function_supplier;

import java.util.function.Function;

public class FunctionTest {
	
	public static void main(String[] args) {
		Function<Applicant, Applicant> setStatus = a->{
			if(a.getAge()>=18&&a.getAge()<60)
				a.setStatus("Accepted");
			return a;
		};
		Function<Applicant, String> returnResult = a->{
			if(a.getStatus().equals("Accepted"))
				return "Accepted";
			else return "Rejected";
		};
		
		Applicant a1 = new Applicant("John Doe",20);
		Applicant a2 = new Applicant("Jane Roe",16);
		handleApplicant(a1, returnResult.compose(setStatus));
		handleApplicant(a2, setStatus.andThen(returnResult));
		
	}
	
	public static void handleApplicant(Applicant a, Function<Applicant, String> f) {
		String result = f.apply(a);
		System.out.println(a.getName()+" is "+result);
	}

}
