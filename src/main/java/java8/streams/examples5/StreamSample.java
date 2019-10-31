package java8.streams.examples5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class StreamSample {
    static final String[] months = {"Jan", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    static final List<String> am = Arrays.asList(months);

    public static void m1() {
        List<String> m = Arrays.asList(months);
        m.forEach(s -> System.out.println(s));

        ArrayList<String> a2 = new ArrayList<>();
        m.forEach(s -> a2.add(s.toUpperCase()));
        m.forEach(s -> System.out.println(s));
    }

    public static void m2_v0() {
        Stream<String> s1 = am.stream();
        Stream<String> s2 = s1.map(String::toUpperCase);
        s2.forEach(System.out::println);
    }

    public static void m2() {
        am.stream()
                .distinct()
                //.sorted((o1, o2) -> o1.charAt(2)-o2.charAt(2))
                .map((String s) -> "Month: "+s.toUpperCase())
                .forEach(System.out::println);
    }

    public static void m3() {
        int[] ii = {1,2,7,4,3,8,7};
        OptionalInt min = Arrays.stream(ii)
                //.parallel()
                .filter(StreamSample::test5)
                .min();
        //.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //m1();
        //m2();
        m3();
    }

    private static boolean test5(int value) {
        return value < 5;
    }
}
