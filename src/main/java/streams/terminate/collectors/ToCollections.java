package streams.terminate.collectors;

import streams.initiation.StreamFromCollections;
import streams.initiation.StreamFromIterable;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToCollections {
    public static void main(String[] args) {
        StreamFromIterable si = new StreamFromIterable();

        List<String> collected0 = si.stream().collect(Collectors.toList());
        Set<String> collected1 = si.stream().collect(Collectors.toSet());

        ArrayList<String> collected2 = si.stream().collect(Collectors.toCollection(ArrayList::new));
        LinkedList<String> collected3 = si.stream().collect(Collectors.toCollection(LinkedList::new));
        PriorityQueue<String> collected4 = si.stream().collect(Collectors.toCollection(PriorityQueue::new));
        HashSet<String> collected5 = si.stream().collect(Collectors.toCollection(HashSet::new));
        TreeSet<String> collected6 = si.stream().collect(Collectors.toCollection(TreeSet::new));
        Stack<String> collected7 = si.stream().collect(Collectors.toCollection(Stack::new));
        Vector<String> collected8 = si.stream().collect(Collectors.toCollection(Vector::new));

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
