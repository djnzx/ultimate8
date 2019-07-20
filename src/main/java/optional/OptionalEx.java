package optional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalEx {
    public static void main1(String[] args) {
        ArrayList<Optional<String>> a = new ArrayList<>();
        a.add(Optional.of("info"));
        a.add(Optional.empty());
        //
        a.forEach(os -> os
                .map(s -> "<"+s+">")
                .ifPresent(System.out::println)
        );
//        a.forEach(os -> os);



        Optional<Integer> integer = Optional.of("1").map(s -> Integer.parseInt(s));


        a.forEach(s -> {
            if (s.isPresent()) {
                System.out.println("<"+s.get()+">");
            }
        });




//        Optional<String> extra1 = ;
//        Optional<String> extra2 = ;
//        boolean present = extra1.isPresent();
//        String s = extra1.get();
//        Optional<String> extra31 = Optional.of(from_front);
//        Optional<String> extra32 = Optional.of(null);
    }

    public static void main(String[] args) {
//        Optional<String> opt = Optional.of("AAAA");
        Optional<String> opt = Optional.empty();

        String s1 = opt.orElse("!empty object");
        String s2 = opt.orElseGet(() -> "!empty object");
        System.out.println(s1);
        System.out.println(s2);

        String s3 = opt.orElseThrow(() -> new IllegalArgumentException("Must be a string!!!"));
        System.out.println(s3);



        String sss1 = "";
        String sss2 = null;
    }
}
