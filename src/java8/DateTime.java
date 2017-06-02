package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTime {
  public static void main(String arg[]){
	  LocalDate currentDate = LocalDate.now();
	  System.out.println(currentDate);
	 // 2014-02-10
	 LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
	 // months values start at 1 (2014-08-01)
	 LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
	 // the 65th day of 2010 (2010-03-06)
	 LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
	 
	 LocalTime currentTime = LocalTime.now(); // current time
	 System.out.println(currentTime);
	 LocalTime midday = LocalTime.of(12, 0); // 12:00
	 LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
	 // 12345th second of day (03:25:45)
	 LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);
	 // dates with times, e.g. 2014-02-18 19:08:37.950
	 LocalDateTime currentDateTime = LocalDateTime.now();
	 // 2014-10-02 12:30
	 LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);
	 // 2014-12-24 12:00
	 LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);
  }
}
