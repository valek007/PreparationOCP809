package main.date_and_time_based_events;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//time-zone in the ISO-8601 calendar system
		LocalDate date1 = LocalDate.of(2018, 1, 1);//refers ti 01 January 2018
		LocalDate date2 = date1.withMonth(6); //refers to 01 June 2018
		LocalDate date3 = date2.plusDays(100); //refers to 09 September 2018
		LocalDate date4 = date2.minusDays(50); //refers to 21 July 2018
		boolean isLeapYear = date4.isLeapYear(); //the value is false
		int dayOfMonth = date4.getDayOfMonth(); //the value is 21
		
		//time-zone without the ISO-8601 calendar system	
		LocalTime time1 = LocalTime.parse("20:30:40"); //refers to 20:30:40
		LocalTime time2 = time1.with(ChronoField.MINUTE_OF_DAY,10);//refers to 20:10:40
		boolean isTime2AfterTime1 = time2.isAfter(time1);//the value is false
		int second = time2.get(ChronoField.SECOND_OF_MINUTE);//the value is 40
		
		//time-zone without the ISO-8601 calendar system	
		LocalDateTime dateTime1 = date1.atTime(time1);//refers to 20:30:40 on 01 January 2018
		LocalDateTime dateTime2 = dateTime1.plusMonths(2).minusHours(12);//refers to 08:30:40 on 01 March 2018
		LocalDate newDate1 = LocalDate.from(dateTime2);// refers to 01 March 2018
		LocalTime newTime1 = LocalTime.from(dateTime2);// refers to 08:30:40
		
		//Instant object represents an instantaneous point on the time-line
		Instant now = Instant.now(); //refers to the current point in time
		Instant instant = Instant.ofEpochMilli(1500000000L);//instant refers to 1970-01-18T08:40:00Z
		boolean isBefore = instant.isBefore(now);//the value is true
		
		//Period instance indicates a date-based amount of time in the ISO-8601 calendar system
		Period period1 = Period.of(1, 2, 3);//period1 indicates 1 year, 2 months and 3 days
		Period period2 = period1.minusMonths(1).plusDays(2);//period2 indicates 1 year, 1 month and 5 days
		date1 = LocalDate.of(2018, Month.SEPTEMBER, 15); //date1 refers to 15 September 2018
		LocalDate newDate2 = date1.plus(period2); //newDate2 refers to 20 October 2019
		
		//Duration instance indicates a time-based amount of time in the ISO-8601 calendar system
		Duration duration1 = Duration.parse("PT-20H-20M");//duration1 indicates 2 hours and 30 minutes
		Duration duration2 = Duration.between(time1, time2);//duration2 indicates 20 hours and 20 minutes
		boolean isEqual = duration2.equals(duration1);//indicates true
		System.out.println(isEqual);
		


		
		
	}

}
