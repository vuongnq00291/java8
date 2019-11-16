package java8;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class V8DateTime {
  public static void main(String arg[]){
	  timeZone();
  }
  
  
  public static void localdate(){
	  LocalDate today = LocalDate.now();
	  int year = today.getYear();
	  int month = today.getMonthValue();
	  int day = today.getDayOfMonth();
	  System.out.printf("Year : %d  Month : %d  day : %d \t %n", year, month, day);
	
	  
	  LocalDate date1 = LocalDate.of(2014, 01, 14);
	  if(date1.equals(today)){
	      System.out.printf("Today %s and date1 %s are same date %n", today, date1);
	  }
	  
	  LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
	  MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
	  MonthDay currentMonthDay = MonthDay.from(today);
	       
	  if(currentMonthDay.equals(birthday)){
	     System.out.println("Many Many happy returns of the day !!");
	  }else{
	     System.out.println("Sorry, today is not your birthday");
	  }
	  
	  
	  LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
	  System.out.println("Today is : " + today);
	  System.out.println("Date after 1 week : " + nextWeek);
	  
	  
	  LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
	  System.out.println("Date before 1 year : " + previousYear);
	       
	  LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
	  System.out.println("Date after 1 year : " + nextYear);
	  
	  
	  LocalDate tomorrow = LocalDate.of(2014, 1, 15);
	     
	  if(tomorrow.isAfter(today)){
	      System.out.println("Tomorrow comes after today");
	  }
	       
	  LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);

	  if(yesterday.isBefore(today)){
	      System.out.println("Yesterday is day before today");
	  }
	  
	  YearMonth currentYearMonth = YearMonth.now();
	  System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
	  YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
	  System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
	 
  }
  
  public static void period(){
	  LocalDate today = LocalDate.now();
	  LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
	  Period periodToNextJavaRelease = Period.between(today, java8Release);
	  System.out.println("Months left between today and Java 8 release : "
	                                     + periodToNextJavaRelease.getMonths() );
  }
  
  
  public static void duration(){
	// Creating Durations
      System.out.println("--- Examples --- ");

      Duration oneHours = Duration.ofHours(1);
      System.out.println(oneHours.getSeconds() + " seconds");

      Duration oneHours2 = Duration.of(1, ChronoUnit.HOURS);
      System.out.println(oneHours2.getSeconds() + " seconds");

		// Test Duration.between
      System.out.println("\n--- Duration.between --- ");

      LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);
      LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

      System.out.println(oldDate);
      System.out.println(newDate);

      //count seconds between dates
      Duration duration = Duration.between(oldDate, newDate);

      System.out.println(duration.getSeconds() + " seconds");
  }
  
  public static void localTime(){
	  LocalTime time = LocalTime.now();
	  LocalTime newTime = time.plusHours(2); // adding two hours
	  System.out.println("Time after 2 hours : " +  newTime);
	  
	  Instant timestamp = Instant.now();
	  System.out.println("What is value of this instant " + timestamp);
  }
  
  public static void timeZone(){
	  ZoneId america = ZoneId.of("Asia/vietnam");
	  LocalDateTime localtDateAndTime = LocalDateTime.now();
	  ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
	  System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
	  
	  
	  DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");

      LocalDateTime ldt = LocalDateTime.of(2016, Month.AUGUST, 22, 14, 30);
      System.out.println("LocalDateTime : " + format.format(ldt));

      //UTC+8
      ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Kuala_Lumpur"));
      System.out.println("Depart : " + format.format(klDateTime));

      //UTC+9 and flight duration = 7 hours
      ZonedDateTime japanDateTime = klDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(7);
      System.out.println("Arrive : " + format.format(japanDateTime));

      System.out.println("\n---Detail---");
      System.out.println("Depart : " + klDateTime);
      System.out.println("Arrive : " + japanDateTime);
      
      
      
   // Z = UTC+0
      Instant instant = Instant.now();
      System.out.println("Instant : " + instant);
      // Japan = UTC+9
      ZonedDateTime jpTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
      System.out.println("ZonedDateTime : " + jpTime);
      System.out.println("OffSet : " + jpTime.getOffset());

	   
  }
  
  public static void DateToString(){
	  LocalDateTime arrivalDate  = LocalDateTime.now();
	  try {
	      DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy  hh:mm a");
	      String landing = arrivalDate.format(format);
	      System.out.printf("Arriving at :  %s %n", landing);
	  } catch (DateTimeException ex) {
	      System.out.printf("%s can't be formatted!%n", arrivalDate);
	      ex.printStackTrace();
	  }
  }
  
  public static void StringtoDate(){
	  String goodFriday = "Apr 18 2014";
	  try {
	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
	      LocalDate holiday = LocalDate.parse(goodFriday, formatter);
	      System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
	  } catch (DateTimeParseException ex) {
	      System.out.printf("%s is not parsable!%n", goodFriday);
	      ex.printStackTrace();
	  }
  }
}
