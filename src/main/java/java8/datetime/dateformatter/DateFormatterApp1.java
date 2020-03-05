package java8.datetime.dateformatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateFormatterApp1 {
  public static void main(String[] args) {
    // user input
    String userInput = "05/03/2020";
    // formatter
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // local date without time
    LocalDate ld = LocalDate.parse(userInput, fmt);
    // local date with time, way 1
//    LocalDateTime ldt = ld.atTime(LocalTime.now());
    // local date with time, way 2
    LocalDateTime ldt = ld.atTime(0,0);
    // we need zone
    ZoneOffset offset = ZoneOffset.ofHours(4);
    // and now, we can convert it to Instant and to milliseconds (long)
    long l = ldt.toInstant(offset).toEpochMilli();
    System.out.println(ld); // 2020-03-05
    System.out.println(l);  // 1583352000000
  }
}
