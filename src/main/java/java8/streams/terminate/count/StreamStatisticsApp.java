package java8.streams.terminate.count;

import java.util.IntSummaryStatistics;
import java.util.Random;

public class StreamStatisticsApp {
  public static void main(String[] args) {
    // Int, Long, Double
    IntSummaryStatistics stat = new Random()
        .ints(10, 30)
        .limit(20)
        .summaryStatistics();
    System.out.println(stat);
  }
}
