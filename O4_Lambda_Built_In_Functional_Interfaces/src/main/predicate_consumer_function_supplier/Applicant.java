package main.predicate_consumer_function_supplier;

import java.util.Random;

public class Applicant {

	private int id;
	private String name;
	private Gender gender;
	private int age;
	private String status = "Registred";

	public Applicant(String name, Gender gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Applicant(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Applicant(String name) {
		this.id = new Random().nextInt(1000);
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public static enum Gender {
		MALE, FEMALE
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
