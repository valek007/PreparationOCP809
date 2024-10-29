package main.read_and_write_from_console;

import java.io.Console;
import java.util.Scanner;

/*
 System.in: An InputStream object representing the standard input stream
 System.out: A PrintStream object representing the standard output stream
 System.err: A PrintStream object representing the standard error output stream
 
 Standart streams are byte-based, while Console is character-based
 Standart streams are always existent, while a Console instance might or might not be
 Standart streams belong to the underlying platform, while the unique Console objects
 is associated with the JVM
 */
public class Test {
	
	public static void main(String[] args) {
		System.out.println("Oracle Corporation");//print "Oracle Corporation"
		System.out.printf("%s%d Exam\n","OCAJP",8);//print "OCAJP8 Exam"
		System.err.format("%s%d Exam\n","OCAJP",8);//print "OCAJP8 Exam"
		System.err.print("Sun Microsystems");//print "Sun Microsystems"
		
		Scanner scanner = new Scanner(System.in);
		String input = "", output = "";
		System.out.println("\nEnter a message: ");
		while(true) {
			input = scanner.nextLine();
			if(input.equalsIgnoreCase("Exit"))
				break;
			output+="\n"+input.toUpperCase();
		}
		System.out.println("Yout message: "+output);
		scanner.close();
		
		/*
		 The Console class represents the unique character-based console device, 
		 wich is associated with the current Java Virtual Machine.
		 
		 Whether the virtual machine has a console depends on the underlying platform,
		 and on the manner in wich it is launched.
		 
		 Obtainint the Console instance: System.console()
		 
		 Console console = System.console();
			if(console != null) {
				console.printf("Welcome to %s", "Java");
				console.format("Welcome to %s", "Java");
			}
		 */
		Console console = System.console();
		if(console!=null) {
			console.printf("Enter a message:\n");
			while(true) {
				input = console.readLine();
				if(input.equalsIgnoreCase("Exit"))
					break;
				output+=input.toUpperCase()+" ";
			}
			console.format("Your message: %s", output);
		}
		
		//method for read passwords
		if(console != null) {
			char[] password = console.readPassword("Enter your password");
			System.out.println(password);
		}
		
		
		
		
	}

}
