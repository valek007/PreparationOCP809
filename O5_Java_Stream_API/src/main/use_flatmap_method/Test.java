package main.use_flatmap_method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		Student henry = new Student("Henry", 90); 
		Student bella = new Student("Bella", 80);
		Student dylan = new Student("Dylan", 70);
		Student riley = new Student("Riley", 85);
		Course ocajp = new Course("OCAJP");
		Course ocpjp = new Course("OCPJP");
		
		ocajp.addStudent(bella);
		ocajp.addStudent(dylan);
		ocpjp.addStudent(henry);
		ocpjp.addStudent(riley);
		
		List<Course> courses = Arrays.asList(ocajp,ocpjp);
		Stream<Student> students = courses.stream().flatMap(c->c.getStudents().stream());
		students.forEach(s->System.out.println(s.getName()));
		//print "Bella","Dylan","Henry" and "Riley
		IntStream marks = courses.stream()
				.flatMapToInt(c->c.getStudents().stream().mapToInt(Student::getMark));
		marks.forEach(System.out::println);
		//print 80, 70, 90 and 85

	}

	static class Student {
		private String name;
		private int mark;

		public Student(String name, int mark) {
			this.name = name;
			this.mark = mark;
		}

		public String getName() {
			return name;
		}

		public int getMark() {
			return mark;
		}

	}

	static class Course {
		private String name;
		private List<Student> students = new ArrayList<>();

		public Course(String name) {
			this.name = name;
		}

		public void addStudent(Student student) {
			this.students.add(student);
		}

		public String getName() {
			return name;
		}

		public List<Student> getStudents() {
			return students;
		}

	}

}
