package java8.streams.terminate.collectors;

import java8.streams.initiation.StreamFromCollections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMap {
  public static void main(String[] args) {
    StreamFromCollections sc = new StreamFromCollections();
    Map<Integer, String> collected10 = sc.stream().collect(Collectors.toMap(
        new Function<Map.Entry<Integer, String>, Integer>() {
          @Override
          public Integer apply(Map.Entry<Integer, String> entry) {
            return entry.getKey();
          }
        }, new Function<Map.Entry<Integer, String>, String>() {
          @Override
          public String apply(Map.Entry<Integer, String> entry) {
            return entry.getValue();
          }
        }));
    Map<Integer, String> collected11 = sc.stream().collect(Collectors.toMap(
        new Function<Map.Entry<Integer, String>, Integer>() {
          @Override
          public Integer apply(Map.Entry<Integer, String> entry) {
            return entry.getKey();
          }
        }, new Function<Map.Entry<Integer, String>, String>() {
          @Override
          public String apply(Map.Entry<Integer, String> entry) {
            return entry.getValue();
          }
        },
        new BinaryOperator<String>() {
          @Override
          public String apply(String s, String s2) {
            return null;
          }
        }));
    TreeMap<Integer, String> collected12 = sc.stream().collect(Collectors.toMap(
        new Function<Map.Entry<Integer, String>, Integer>() {
          @Override
          public Integer apply(Map.Entry<Integer, String> entry) {
            return entry.getKey();
          }
        }, new Function<Map.Entry<Integer, String>, String>() {
          @Override
          public String apply(Map.Entry<Integer, String> entry) {
            return entry.getValue();
          }
        },
        // a merge function, used to resolve collisions betwee values associated with the same key, as supplied
        new BinaryOperator<String>() {
          @Override
          public String apply(String s, String s2) {
            return s2;
          }
        },
        TreeMap::new));
    HashMap<Integer, String> collected13 = sc.stream().collect(Collectors.toMap(
        new Function<Map.Entry<Integer, String>, Integer>() {
          @Override
          public Integer apply(Map.Entry<Integer, String> entry) {
            return entry.getKey();
          }
        }, new Function<Map.Entry<Integer, String>, String>() {
          @Override
          public String apply(Map.Entry<Integer, String> entry) {
            return entry.getValue();
          }
        },
        // a merge function, used to resolve collisions betwee values associated with the same key, as supplied
        new BinaryOperator<String>() {
          @Override
          public String apply(String s, String s2) {
            return s2;
          }
        },
        () -> new HashMap<Integer, String>()));

    Map<Integer, String> collected20 = sc.stream().collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue
    ));

    Map<Integer, String> collected21 = sc.stream().collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (s, s2) -> null));

    TreeMap<Integer, String> collected22 = sc.stream().collect(Collectors.toMap(
        Map.Entry::getKey, Map.Entry::getValue,
        (s1, s2) -> s2, // a merge function, used to resolve collisions betwee values associated with the same key, as supplied
        TreeMap::new));

    HashMap<Integer, String> collected23 = sc.stream().collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (s1, s2) -> s2,
        HashMap::new));

    /**
     * concurrent processing is the same as a standard
     * sc.stream().collect(Collectors.toConcurrentMap());
     */
  }
}
