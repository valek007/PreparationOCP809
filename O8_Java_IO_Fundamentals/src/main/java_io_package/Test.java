package main.java_io_package;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Test {

	static void workingWithFile() throws IOException {
		// A File instance is an abstract representation of a file or directory pathname
		File file = new File("file.txt"); // relative pathname
		System.out.println(file.exists()); // print false

		file.createNewFile();

		System.out.println(file.exists());// print true
		File dir = new File("direction");
		dir.mkdir();
		System.out.println(dir.exists());// print true
	}

	static void workingWithFileReader() throws IOException {
		// FileReader is a convenience class for reading character files
		File file = new File("file.txt");
		FileReader reader = new FileReader(file);
		char[] buffer = new char[10];
		reader.read(buffer);
		reader.close();
		// print what the file contains
		System.out.println(buffer);
	}

	@SuppressWarnings("resource")
	static void workingWithFileWriter() throws IOException {
		// FileWriter is a convenience class fot writing character files
		FileWriter writer = new FileWriter("file.txt", false);
		writer.write("Thank you, ");
		writer.append("James Gosling");

	}

	static void workingWithFileInputStream() throws IOException {
		// FileInputStream is a convenience class for reading bianry files
		FileInputStream input = new FileInputStream("file.bin");
		byte[] buffer = new byte[100];
		input.read(buffer);
		input.close();
	}

	static void workingWithFileOutputStream() throws IOException {
		// FuleOutputStream is a convenience class for writing binary files
		FileOutputStream output = new FileOutputStream("file.txt", true);
		byte[] buffer = "Welcome to the Earth!\n".getBytes();
		output.write(buffer);
		output.flush();
		buffer = "Go back to your planet!".getBytes();
		output.write(buffer, 0, 8);
		output.close();
	}

	static void workingWithBufferedReader() throws IOException {
		// A BufferedReader reads text from a character-input stream,
		// buffering characters to provide efficient readign of characters, arrays, and
		// lines
		BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
		String conText = conReader.readLine();
		System.out.println(conText);
		conReader.close();
		BufferedReader fileReader = new BufferedReader(new FileReader("file.txt"));
		fileReader.lines().forEach(System.out::println);
		fileReader.close();
	}

	static void workingWithBufferedWriter() throws IOException {
		// A BufferedWriter writes text to a character-output stream, buffering
		// characters to provide efficient writting of characters, arrays, and lines
		BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
		writer.write("Welcome to the Earth");
		writer.newLine();
		writer.write("Go back to your planet!");
		writer.close();

	}

	static void workingWithPrintWriter() throws IOException {
		// A PrintWriter prints formatted represantations of objects to a text-output
		// stream
		// The destination of a PrintWriter instance can be a File, OutputStream, or
		// Writer
		// Methods of PrinWriter never throw I/O Exceptions
		PrintWriter writer = new PrintWriter(System.out);
		writer.println("Welcome to the Earth!");
		writer.flush();
	}

	@SuppressWarnings("resource")
	static void workingWithObjectOutputStream() throws IOException {
		// An ObjectOutputStream writes primitive values and Java objects to an
		// OutputsStream;
		// those serialized values and objects can be recovered using an
		// ObjectInputStream via an InputStream
		// Only objects that supoort the Serializable interface can be written to and
		// read back from streams
		File file = new File("file.ser");
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
		Student outStudent = new Student(1, "John Doe");
		outStream.writeObject(outStudent);
		outStream.close();
	}

	static void workingWithObjectInputStream() throws IOException, ClassNotFoundException {
		File file = new File("file.ser");
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream inStream = new ObjectInputStream(fileIn);
		Student inStudent = (Student) inStream.readObject();
		//print number 1 and "John Doe"
		System.out.println(inStudent.getId()+" "+inStudent.getName());
		inStream.close();

	}

	static class Student implements Serializable {

		private static final long serialVersionUID = 1L;
		private int id;
		private String name;

		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}
}
