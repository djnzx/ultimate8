package java8.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

/**
 * https://www.oracle.com/technical-resources/articles/java/jf14-date-time.html
 * https://www.baeldung.com/java-8-date-time-intro
 *
 * https://habr.com/en/post/274811/
 * https://habr.com/ru/post/274905/
 *
 * https://www.w3schools.com/java/java_date.asp
 *
 * new API - java.time.*
 */
public class DateTimeApp {

  private void time_creating() {
    LocalTime now1 = LocalTime.now(); // system based
    System.out.println(now1);
    LocalTime now2 = LocalTime.now(ZoneId.of("GMT+2")); // explicitly ask for (Kiev)
    System.out.println(now2);
    LocalTime now3 = LocalTime.now(ZoneId.of("CET")); // explicitly ask for Europe
    System.out.println(now3);
    LocalTime now4 = LocalTime.of(15, 10);
    LocalTime now5 = LocalTime.of(15, 10, 33);
    LocalTime now6 = LocalTime.of(15, 10, 33, 677);

    int h = now1.getHour();
    int m = now1.getMinute();
    int s = now1.getSecond();
    int ns = now1.getNano();

    // how to truncate
    LocalTime now4new = now4.truncatedTo(ChronoUnit.SECONDS);

    String formatted = now1.format(DateTimeFormatter.ISO_LOCAL_TIME);
    System.out.println(formatted);

    now1.compareTo(now2);
  }

  private void date_creating() {
    LocalDate now1 = LocalDate.now(ZoneId.of("GMT+3"));
    System.out.println(now1);
    LocalDate now2 = LocalDate.now(ZoneId.of("GMT+2")); // allowed calc -18..18
    System.out.println(now2);
    LocalDate now3 = LocalDate.now(ZoneId.of("GMT"));
    System.out.println(now3);
    LocalDate now4 = LocalDate.of(2019, Month.OCTOBER, 29);

    int year = now1.getYear();
    Month month = now1.getMonth(); // JAN .. DEC
    int dayOfMonth = now1.getDayOfMonth();
    DayOfWeek dayOfWeek = now1.getDayOfWeek(); // MON .. SUN
    int dayOfYear = now1.getDayOfYear();
    boolean leapYear = now1.isLeapYear();
  }

  private void datetime_creating() {
    ZoneId z = ZoneId.of("GMT+3");

    LocalDateTime now = LocalDateTime.now(z);

    LocalDate ldate = LocalDate.now(z);
    LocalTime ltime = LocalTime.now(z);
    LocalDateTime localDateTime1 = ldate.atTime(ltime);
    LocalDateTime localDateTime2 = ltime.atDate(ldate);
    LocalDateTime localDateTime3 = LocalDateTime.of(ldate, ltime);
  }

  private void period1_creating() {
    // range
    Period period = Period.ofMonths(3);
    // date
    LocalDateTime ldt = LocalDateTime.now();
    // shift
    Temporal temporal1 = period.addTo(ldt);
    Temporal temporal2 = period.subtractFrom(ldt);
    // shifted date
    LocalDateTime ldt_shifted1 = LocalDateTime.from(temporal1);
    LocalDateTime ldt_shifted2 = LocalDateTime.from(temporal2);
    System.out.println(ldt);
    System.out.println(ldt_shifted1);
    System.out.println(ldt_shifted2);
  }

  private void period2_creating() {
    LocalDate ld1 = LocalDate.of(2015, Month.OCTOBER, 20);
    LocalDate ld2 = LocalDate.of(2015, Month.NOVEMBER, 20);
    Period period = Period.between(ld1, ld2);
  }

  private void date_comparing() {
    LocalDate ld1 = LocalDate.of(2015, Month.OCTOBER, 20);
    LocalDate ld2 = LocalDate.of(2015, Month.NOVEMBER, 20);
    if (ld1.isAfter(ld2))   { /* */ }
    if (ld1.isBefore(ld2))  { /* */ }
    if (ld1.isEqual(ld2))   { /* */ }

    LocalTime ltime1 = LocalTime.now(ZoneId.of("GMT+1")); // 13:18:08.328
    LocalTime ltime2 = LocalTime.now(ZoneId.of("GMT-1")); // 11:18:08.328
    System.out.println(ltime1);
    System.out.println(ltime2);
  }

  private void instant() {

  }

  private void formatting() {

  }

  private void parsing() {

  }

  public static void main(String[] args) {
    DateTimeApp app = new DateTimeApp();
    app.date_comparing();
  }

}
