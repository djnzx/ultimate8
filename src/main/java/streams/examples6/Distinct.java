package streams.examples6;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Distinct {
    static String vovels =     "AEIOUY";
    static String consonants = "BCDFGHJKLMNPQRSTVWXZ";

    public static boolean rule(char letter) {
        return vovels.contains(letter+"");
    }

    public static void main0(String[] args) {
        Stream
                .generate(() -> ((char) ('A' + Math.random() * 26)))
                //.parallel()
                .limit(100)
                //.collect(groupingBy(Function.identity(), counting()))
                .collect(groupingBy(c->c, counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> o1.getKey()-o2.getKey())
                .forEach(e -> System.out.printf("%s:%d\n",e.getKey(),e.getValue()));
    }

    public static void main1(String[] args) {
        Stream
                .generate(() -> ((char) ('A' + Math.random() * 26)))
                .limit(50)
                //.collect(groupingBy(c->rule(c), counting()))
                .collect(groupingBy(Distinct::rule, counting()))
                .forEach((key, cnt) -> System.out.printf("%s: %s\n", key?"vovel":"consonant", cnt));
    }

    public static void main(String[] args) {
        Stream
                .generate(() -> ((char) ('A' + Math.random() * 26)))
                .limit(50)
                //.distinct()
                .sorted()
                .collect(groupingBy(Distinct::rule, toList()))
                .forEach((key, list) -> System.out.printf("%s: %s\n", key?"vovel":"consonant", list));
    }
}
