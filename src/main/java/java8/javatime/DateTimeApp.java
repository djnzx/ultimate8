package java8.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Set;

/**
 * new API - java.time.*
 * links do web-resources in the "_links.txt"
 */
public class DateTimeApp {

  /**
   * The LocalTime represents a time
   * in ISO format (HH:MM:SS.nnnnnnnnn) without date
   */
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
    LocalTime now7 = LocalTime.parse("5:30:12");
    LocalTime now8 = LocalTime.MAX;
    LocalTime now9 = LocalTime.MIN;
    LocalTime nowA = LocalTime.NOON;
    LocalTime nowB = LocalTime.MIDNIGHT;

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

  /**
   * The LocalDate represents a date
   * in ISO format (yyyy-MM-dd) without time
   */
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

    LocalDate tomorrow = now1.plusDays(1);
    LocalDate monthAgo = LocalDate.now().minus(1, ChronoUnit.MONTHS);
  }

  /**
   * date and time combination without zone
   */
  private void datetime_creating() {
    ZoneId z = ZoneId.of("GMT+3");

    // system default zone
    LocalDateTime now1 = LocalDateTime.now();
    // zone specified directly
    LocalDateTime now2 = LocalDateTime.now(z);
    LocalDateTime now3 = LocalDateTime.of(2019, Month.NOVEMBER, 1, 11, 41);
    System.out.println(now3);

    LocalDate ldate = LocalDate.now(z);
    LocalTime ltime = LocalTime.now(z);
    LocalDateTime localDateTime1 = ldate.atTime(ltime);
    LocalDateTime localDateTime2 = ltime.atDate(ldate);
    LocalDateTime localDateTime3 = LocalDateTime.of(ldate, ltime);
    LocalDateTime localDateTime4 = ldate.atStartOfDay();
    LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
        .with(TemporalAdjusters.firstDayOfMonth());
    LocalDateTime localDateTime5 = localDateTime1.plusHours(1);
    LocalDateTime localDateTime6 = localDateTime1.minusDays(1);
    LocalDateTime localDateTime7 = localDateTime1.plus(2, ChronoUnit.MINUTES);
    LocalDateTime localDateTime8 = localDateTime1.minus(2, ChronoUnit.SECONDS);
    int hour = localDateTime8.getHour();
    int minute = localDateTime8.getMinute();
  }

  /**
   * The Period   class represents a "quantity" of time in terms of years, months and days
   * the Duration class represents a "quantity" of time in terms of seconds and nano seconds.
   */
  private void period_creating() {
    LocalDate start = LocalDate.of(2015, Month.OCTOBER, 20);
    LocalDate finish = LocalDate.of(2015, Month.NOVEMBER, 20);
    Period period1 = Period.between(start, finish); // 1m

    LocalDate start2 = LocalDate.of(2015, Month.OCTOBER, 20);
    LocalDate finish2 = start2.plusDays(2);
    Period period2 = Period.between(start2, finish2); // 2d

    long days = ChronoUnit.DAYS.between(start, finish); // 31

    Period period3 = Period.ofMonths(3);

    // date
    LocalDateTime ldt = LocalDateTime.now();
    // shift
    Temporal temporal1 = period3.addTo(ldt);
    Temporal temporal2 = period3.subtractFrom(ldt);
    // shifted date
    LocalDateTime ldt_shifted1 = LocalDateTime.from(temporal1);
    LocalDateTime ldt_shifted2 = LocalDateTime.from(temporal2);
  }

  /**
   * The Period   class represents a "quantity" of time in terms of years, months and days
   * the Duration class represents a "quantity" of time in terms of seconds and nano seconds.
   */
  private void duration_creating() {
    LocalTime initialTime = LocalTime.of(6, 30, 0);
    LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
    long seconds = Duration.between(initialTime, finalTime).getSeconds(); // 30
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

  /**
   * date and time combination with zone
   */
  private void zoned_date_time() {
    Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
    String origin =
//        "2015-05-03T10:15:30+01:00[Europe/Paris]";
//        "2015-05-03T10:15:30+01:00";
        "2015-05-03T10:15:30+05:45";
    ZonedDateTime kiev =          ZonedDateTime.parse("2015-05-03T10:15:30+02:00");
    ZonedDateTime baku =          ZonedDateTime.parse("2015-05-03T10:15:30+04:00");
    ZonedDateTime india =         ZonedDateTime.parse("2015-05-03T10:15:30+05:30");
    ZonedDateTime kathmandu =     ZonedDateTime.parse("2015-05-03T10:15:30+05:45");
    ZonedDateTime now_kiev =      ZonedDateTime.now(ZoneId.of("GMT+02:00"));
    ZonedDateTime now_baku =      ZonedDateTime.now(ZoneId.of("GMT+04:00"));
    ZonedDateTime now_india =     ZonedDateTime.now(ZoneId.of("GMT+05:30"));
    ZonedDateTime now_kathmandu = ZonedDateTime.now(ZoneId.of("GMT+05:45"));
    LocalDateTime now = LocalDateTime.now();
    ZonedDateTime calculated_baku = ZonedDateTime.of(now, ZoneId.of("GMT+04:00"));
    ZonedDateTime calculated_kiev = ZonedDateTime.of(now, ZoneId.of("GMT+02:00"));
  }

  private void offset_date_tim() {
    LocalDateTime ldt = LocalDateTime.of(2015, Month.FEBRUARY, 20, 9, 30);
    System.out.println(ldt);
    ZoneOffset offset = ZoneOffset.of("+02:00");
    OffsetDateTime ldtPlus2Hr = OffsetDateTime.of(ldt, offset);
    System.out.println(ldtPlus2Hr);
  }

  private void formatting() {
    LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
    String d1 = localDateTime.format(DateTimeFormatter.ISO_DATE);
    System.out.println(d1);
    String d2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    System.out.println(d2);
    String d3 = localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK));
    String d4 = localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK));
    String d5 = localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    System.out.println(d3);
    System.out.println(d4);
    System.out.println(d5);
  }

  private void parsing() {
    // given string must be represented in ISO format (yyyy-MM-dd) without time
    LocalDate ldate = LocalDate.parse("2019-11-01");
    // given string must be represented in ISO format HH:MM:SS.nnnnnnnnn
    // can be shortened to any nano second digit, or to seconds, or to minutes
    // HH:MM:SS or HH:MM
    LocalTime ltime = LocalTime.parse("05:30:12.123456789");

    LocalDateTime ldt1 = LocalDateTime.parse("2019-11-01T11:43:12.123456789");
    LocalDateTime ldt2 = LocalDateTime.parse("2019-11-01T11:43:12");
    LocalDateTime ldt3 = LocalDateTime.parse("2019-11-01T11:43");
    System.out.println(ldt3);

  }

  public static void main(String[] args) {
    DateTimeApp app = new DateTimeApp();
  }

}
