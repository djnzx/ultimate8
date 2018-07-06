package streams.initiation;

import java.util.*;
import java.util.stream.Stream;

public class StreamFromCollections {
    public static void main(String[] args) {
        Stream<Map.Entry<String, String>> stream1 = new HashMap<String, String>().entrySet().stream();
        Stream<String> stream2 = new HashMap<String, String>().keySet().stream();
        Stream<Integer> stream3 = new ArrayList<Integer>().stream();
        Stream<Character> stream4 = new LinkedList<Character>().stream();
        Stream<String> stream5 = new HashSet<String>().stream();
        Stream<Float> stream6 = new TreeSet<Float>().stream();
    }
}
