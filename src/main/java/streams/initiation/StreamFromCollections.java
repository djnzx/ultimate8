package streams.initiation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFromCollections {
    public Stream<Map.Entry<Integer, String>> stream() {
        int[] key = {0};
        return new StreamFromIterable().stream().collect(Collectors.toMap(
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return key[0]++;
                    }
                },
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s;
                    }
                }))
                .entrySet().stream();
    }

    public static void main(String[] args) {
        Stream<Map.Entry<String, String>> stream1 = new HashMap<String, String>().entrySet().stream();
        Stream<String> stream2 = new HashMap<String, String>().keySet().stream();
        Stream<Integer> stream3 = new ArrayList<Integer>().stream();
        Stream<Character> stream4 = new LinkedList<Character>().stream();
        Stream<String> stream5 = new HashSet<String>().stream();
        Stream<Float> stream6 = new TreeSet<Float>().stream();
    }
}
