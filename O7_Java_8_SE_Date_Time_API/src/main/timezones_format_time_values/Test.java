package main.timezones_format_time_values;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//ZoneId instance represents the identity of a time-zone, wich is used to identify the rules
		//to convert between an Instant and a LocalDateTime
		
		ZoneId fixedOffset = ZoneId.of("UTC-06:00");
		ZoneId geoRegion = ZoneId.of("America/Chicago");
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.stream().forEach(System.out::println); //print all avaible ZoneIds
		
		//ZoneOffset is a sbuclass of ZoneId: an instance of this class represents
		//the amount of time that a time-zone differs from UTC
		ZoneOffset simple = ZoneOffset.of("+6");
		ZoneOffset normalized = ZoneOffset.of("+06:00");
		ZoneOffset ofHours = ZoneOffset.ofHours(6);
		
		//An OffsetTime instance indicates a time with an offset from UTC in the ISO-8601
		//calendar system, storing all time fields to a precision of nanoseconds
		LocalTime localTime = LocalTime.of(10, 20);
		ZoneOffset offset1 = ZoneOffset.of("+06:00");
		OffsetTime offsetTime1 = OffsetTime.of(localTime, offset1);
		OffsetTime offsetTime2 = offsetTime1.plusHours(3).minusMinutes(10);
		ZoneOffset offset2 = ZoneOffset.of("+07:00");
		OffsetTime offsetTime3 = offsetTime2.withOffsetSameInstant(offset2);
		int hour = offsetTime3.getHour();//the value of hour is 14
		
		//An OffsetDateTime instance indicates a date-time with an offset from UTC in the ISO-8601
		//calendar system, storing all date and time fields to a precision of nanoseconds
		LocalDateTime lDateTime = LocalDateTime.of(2018, 02,20,15,0);
		LocalDate lDate = LocalDate.of(2018, 02, 20);
		LocalTime lTime = LocalTime.of(10, 0);
		ZoneOffset offsetl1 = ZoneOffset.of("+03:00");
		ZoneOffset offsetl2 = ZoneOffset.of("+01:00");
		OffsetDateTime zDateTime1 = OffsetDateTime.of(lDateTime, offsetl1);
		OffsetDateTime zDateTime2 = OffsetDateTime.of(lDate,lTime, offsetl2);
		boolean isBefore = zDateTime1.minusHours(4).isBefore(zDateTime2); //true
		
		//A ZoneDateTime instance indicates a date-time with a time-zone in the ISO-8601 calendar
		//system, storing all date and time fields to a precision of nanoseconds
		ZoneId zoneId2 = ZoneId.of("America/Los_Angeles");
		ZonedDateTime zDateTimel1 = ZonedDateTime.of(lDateTime, zoneId2);
		ZonedDateTime zDateTimel2 = zDateTimel1.withMonth(3).withDayOfMonth(15).withHour(12);
		System.out.println(zDateTimel2.getOffset());
		
		//If a local date-time falls into an offset gap, the resulting zoned date-time is in the later offset;
		//If a local date-time is in an overlap duration, the previous offset is preserved by default
		
		ZoneId rZoneId = ZoneId.of("Europe/Paris");
		LocalDateTime lForwardDST = LocalDateTime.of(2018, 3,25,2,30);
		LocalDateTime lBackwardDST = LocalDateTime.of(2018, 10,28,2,30);
		ZonedDateTime zForwardDST = ZonedDateTime.of(lForwardDST, rZoneId);
		System.out.println(zForwardDST); //print 2018-03-25T03:30+02:00[Europe/Paris]
		ZonedDateTime zBackwardDST = ZonedDateTime.of(lBackwardDST, rZoneId);
		System.out.println(zBackwardDST); //print 2018-10-28T02:30+02:00[Europe/Paris]
		ZonedDateTime zBackwardEarlier = zBackwardDST.withEarlierOffsetAtOverlap();
		ZonedDateTime zBackwardLater = zBackwardDST.withLaterOffsetAtOverlap();
		System.out.println(zBackwardEarlier+" "+zBackwardLater);
		//print 2018-10-28T02:30+02:00[Europe/Paris] 2018-10-28T02:30+01:00[Europe/Paris]
		
		/*
		 The DateTimeFormatter class is used for parsing and formatting date and time objectos
		 Predefined formatters:
		 Class			Default formatter		Example
		 LocalDate		ISO_LOCAL_DATE			2018-08-18
		 LocalTime		ISO_LOCAL_TIME			10:20:30
		 LocalDateTime	ISO_LOCAL_DATE_TIME		2018-08-18T10:20:30
		 OffsetTime		ISO_OFFSET_TIME			10:20:30+01:00
		 OffsetDateTime	ISO_OFFSET_DATE_TIME	2018-08-18T10:20:30+01:00
		 ZonedDateTime	ISO_ZONED_DATE_TIME		2018-08-18T10:20:30+01:00[Europe/Paris]
		 
		 A DateTimeFormatter instance can be created using a given patter or format style:
		 DateTimeFormatter ofPattern(String pattern)
		 DateTimeFormatter ofLocalizedDateTime(FormatStyle dateTimeStyle)
		 Pattern letters:
		 
		 Letter		Meaning		Example
		   y		Year		2018
		   M		Month		1, 01, Jan, January, J
		   d		Day			1, 01
		   H		Hour(0-23)	1, 01
		   m		Minute		1, 01
		   s		Second		1, 01
		   Z		Zone offset	+0100, GMT+01:00
		 */
		
		//The parse method of a date-time class obtains an instance of that class from an input string,
		// while the format method formats the date-time instance using the specified formatter.
		ZoneId fZoneId = ZoneId.of("UTC+01:00");
		DateTimeFormatter ptnFormatter = DateTimeFormatter.ofPattern("H'h'm 'on' dd MMM y");
		LocalDateTime fDateTime = LocalDateTime.parse("8h15 on 05 Mar 2018", ptnFormatter);
		ZonedDateTime zDateTime = ZonedDateTime.of(fDateTime, fZoneId);
		DateTimeFormatter stdFormatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
		DateTimeFormatter stlFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		String text1 = zDateTime.format(stdFormatter); //2018-03-95T08:15:00+01:00[UTC+01:00]
		String text2 = zDateTime.format(stlFormatter); //March 5, 2018 8:15:00 AM UTC+01:00
		
		
		
		
		
		
	}

}
