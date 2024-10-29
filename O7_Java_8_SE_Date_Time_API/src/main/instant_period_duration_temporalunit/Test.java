package main.instant_period_duration_temporalunit;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Test {
	
	public static void main(String[] args) {
		
		//A Period on one day is a coneptual day, maintaining local time and ignoring daylight
		//saving change; a Duration of one day is always exactly 24 hours
		Period period = Period.ofDays(1);
		Duration duration = Duration.ofDays(1);
		ZoneId zoneId = ZoneId.of("America/New_York");
		LocalDateTime localDateTime = LocalDateTime.of(2018,3,10,12,0);
		ZonedDateTime referenceTime = ZonedDateTime.of(localDateTime, zoneId);
		ZonedDateTime perPlusTime = referenceTime.plus(period);
		ZonedDateTime durPlusTime = referenceTime.plus(duration);
		System.out.println(perPlusTime);//print 2018-03-11T12:00-04:00[America/New_York]
		System.out.println(durPlusTime);//print 2018-03-11T13:00-04:00[America/New_York]
		
		//Implementation of the TemporalUnit interface represent units of time
		//The Java API provides a TemporalUnit implementation out of the box, ChronoUnit;
		//this enum type provides a set of predefined time units, from NANOS to FOREVER
		//Noticeable methods:
		//<R extends Temporal>R addTo(R temporal, long amount)
		//long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive)
		//boolean isDateBased()
		//boolean isTimeBased()
		
		LocalDateTime dateTime1 = LocalDateTime.of(2018,6,30,12,0);
		LocalDateTime dateTime2 = dateTime1
				.minus(1, ChronoUnit.DECADES).plus(11, ChronoUnit.YEARS)
				.plus(10, ChronoUnit.HOURS).minus(30, ChronoUnit.MINUTES);
		System.out.println(dateTime2); //print 2019-06-30T21:30
		
	}
}
