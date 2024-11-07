package main.build_resource_bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//The ResourceBundle class indicates resource bundles containing locale-specific objects
		//this class has two direct descendants, PropertyResourceBundle, managing static Strings from properties files,
		//and ListResourceBundle, handling objects from Java classes
		//The ResourceBundle class consists of many overloaded static methods named getBundle, allowing
		//for the retrieval of a resource bundle using the specified base name and locale
		//ResourceBundle objects contain key-value pairs, the getKeys and keySet methods enable you to
		//obtain all the keys in a resource bundle, the value associated with a given key can be extracted
		//using the getString and getObject methods
		
		//Resource bundles belong to families whose members share a common base name, those names
		//have additional components that identify their locale
		//Locale-specific components are connected to the base name using the _ character, starting with
		//the language code, those components are also separated from each other by the _ character
		
		//If a resource bundle for the specified locale does not exist, the ResourceBundle::getBundle
		//method will attempt to find the closet match before falling back on the bundle for the default
		//locale, the on the bundle with the base name
		
		//Assuming a resource bundle named MyBundle_fr_CA is needed, and the default locale is en_US,
		//the following is the order in wich the bundles are searched for:
		//MyBundle_fr_CA -> MyBundle_fr -> MyBundle_en_US -> MyBundle_en -> MyBundle
		
		//An instance of the PropertyResourceBundle class, a concrete subclass of ResourceBundle, is
		//backed by a properties file and manages resources for a locale using static strings from that file
		
		//The PropertyResourceBundle class can be instantieted using the following constructors:
		//PropertyResourceBundle(InputStream stream) throws IOException
		//PropertyResourceBundle(Reader reader) throws IOException
		
		//You can build a PropertyResourceBundle object from a properties file in the classpath, whose name is
		//Exam.properties, as follows:
		PropertyResourceBundle bundle1 = (PropertyResourceBundle) ResourceBundle.getBundle("Exam");
		System.out.println(bundle1);
		//If you have a properties file named Exam.properties in the current working directory, you can create a
		//PropertyResourceBundle object using a constructor.
		PropertyResourceBundle bundle2 = new PropertyResourceBundle(new FileInputStream("Exam.properties"));
		PropertyResourceBundle bundle3 = new PropertyResourceBundle(new FileReader("Exam.properties"));
		System.out.println(bundle2+" "+bundle3);
		
		//Reading property values using the keySet method:
		Set<String> keys = bundle1.keySet();
		keys.stream().forEach(k->System.out.println(k+": "+bundle1.getString(k)));
		//Reading property values using the getKeys method
		Enumeration<String> keys2 = bundle1.getKeys();
		while(keys2.hasMoreElements()) {
			String key = keys2.nextElement();
			String value = bundle1.getString(key);
			System.out.println(key+": "+value);
		}
		
		//The ListResourceBundle class is an abstract subclass of ResourceBundle, managing locale-specific objects
		//a concrete subtype of this class is backed by a Java class file
		//A concrete subclass of ListResourceBundle must provide an implementation for the abstract method
		//getContents, returning locale-specific objects in the form of a two-dimensional Object array:
		//Object[][] getContents()
		class Country_en_US extends ListResourceBundle{

			private Object[][] data = {{"capital","Washington D.C."}};
			@Override
			protected Object[][] getContents() {
				return data;
			}
		}
			
		
		class Country extends ListResourceBundle{

			private Object[][] data = {{"area",0},{"capital","Unknown"}};
			@Override
			protected Object[][] getContents() {
				// TODO Auto-generated method stub
				return data;
			}
		}
		
		//execution code- output: "Area: 0, Capital: Washington D.C."
		Locale us = new Locale("en","US");
		ResourceBundle bundle = (ListResourceBundle) ResourceBundle.getBundle("Country",us);
		int area = (int) bundle.getObject("area");
		String capital = bundle.getString("capital");
		System.out.println("Area: "+area+", Capital: "+capital);
		
		
	}

}
