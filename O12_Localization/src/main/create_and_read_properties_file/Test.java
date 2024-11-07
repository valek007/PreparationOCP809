package main.create_and_read_properties_file;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		
		//A properties file is a is a simple text file, whose name ends with the properties extension
		//Each line of a properties file contains a key-value pair, the key and value are separated by
		//an equal sign (=), a color (:) or a white.space, with the key on the left and value on the right
		
		//The ResourceBundle class contains a static method named getBundle, wich reads
		//a properties file with the specified base name and the default locale:
		//ResurceBundle getBundle(String baseName)
		
		//Assuming you have a properties file named Exam.properties in the classpath, the
		//following statements extract and print out all property keys contained in that file:
		ResourceBundle exam = ResourceBundle.getBundle("Exam");
		Enumeration<String> enumeration = exam.getKeys();
		while(enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			System.out.println(key);
		}
		//You can output property keys using the Stream Api as follows:
		Set<String> set = exam.keySet();
		set.stream().forEach(System.out::println);
		
		//You can read a property value in a ResourceBundle using the getString method:
		//String getString(String key)
		//ResourceBundle exam = //a ResourceBundle instance
		//String key = //a property key
		//System.out.println(exam.getString(key));
		
	}

}
