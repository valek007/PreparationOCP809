package main.read_and_set_with_locale_object;

import java.util.Locale;

public class Test {
	
	public static void main(String[] args) {
		
		//A Locale object is and identifier representing a specific geographical, political, or cultural region
		//A Locale may contain information about language, region, variant, script and extensions
		//The textual representation of a Locale object when it consists of only language and region is
		//formed by concatenating the language code, the _ character and the region code
		
		//Locale.Builder is a utility class that can be used to construct Locale objects conforming
		//to the IETF BCP 47 syntax
		//You can build instances of the Local class using setter methods of Locale.Builder
		Locale enLocale = new Locale.Builder().setLanguage("en").build();
		Locale frLocale = new Locale.Builder().setLanguage("fr").setRegion("CA").build();
		System.out.println(enLocale+" "+frLocale);//print en fr_Ca
		
		//The Locale class contains three public constructors:
		//Locale(String language)
		//Locale(String language, String country)
		//Locale(String language, String country, String variant)
		Locale deLocale = new Locale("de");
		Locale ruLocale = new Locale("ru", "RU");
		System.out.println(deLocale+" "+ruLocale);//print de ru_RU
		
		//The Locale::forLanguageTag method returns a Locale
		//for the specified IETF BCP 47 language tag string
		Locale enLocale2 = Locale.forLanguageTag("en-US");
		System.out.println(enLocale2);//print en_US
		
		//For your convenience, several static final fields "Constants" of the
		//Locale class are declared to indicate particular locales
		Locale zhLocale = Locale.CHINESE;
		Locale itLocale = Locale.ITALY;
		System.out.println(zhLocale+" "+itLocale);//print zh it_IT
		
		//The default Locale is the one used by locale-sensitive objects 
		//when no locale is explicitly specified
		Locale defaultLocale = Locale.getDefault();
		System.out.println(defaultLocale);//print es_ES
		Locale.setDefault(Locale.FRANCE);
		
	}

}
