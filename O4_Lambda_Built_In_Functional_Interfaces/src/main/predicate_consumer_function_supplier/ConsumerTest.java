package main.predicate_consumer_function_supplier;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {

		Consumer<Applicant> setStatus = a -> {
			if (a.getAge() >= 18 && a.getAge() < 60)
				a.setStatus("Accepted");
		};
		
		Consumer<Applicant> notify = a->{
			if(a.getStatus().equals("Accepted"))
				System.out.println(a.getName()+" is accepted.");
		};
		
		Applicant a1 = new Applicant("John Doe",20);
		Applicant a2 = new Applicant("Jane Roe",16);
		handleApplicant(a1, setStatus.andThen(notify));
		handleApplicant(a2, setStatus.andThen(notify));

	}

	public static void handleApplicant(Applicant a, Consumer<Applicant> consumer) {
		consumer.accept(a);
	}
}
