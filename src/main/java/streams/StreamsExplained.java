package streams;

import iterable.Months1;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.joining;

public class StreamsExplained {

    private static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final int[][] nested = {{1,2,3}, {4,5}};

    // all collections have .forEach iterator since Java8
    public static void main0(String[] args) {
        List<String> m = Arrays.asList(months);
        m.forEach(s -> System.out.println(s));

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"QQ");
        map.put(2,"SS");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer key, String value) {
                System.out.printf("Map.Entry:[key:'%d', val:'%s']\n",key,value);
            }
        });
    }

    // several different ways to initiate streams
    public static void main1(String[] args) throws FileNotFoundException {
        // stream from collections
        Stream<Map.Entry<String, String>> stream1 = new HashMap<String, String>().entrySet().stream();
        Stream<String> stream2 = new HashMap<String, String>().keySet().stream();
        Stream<Integer> stream3 = new ArrayList<Integer>().stream();
        Stream<Character> stream4 = new LinkedList<Character>().stream();
        Stream<String> stream5 = new HashSet<String>().stream();
        Stream<Float> stream6 = new TreeSet<Float>().stream();

        // stream from array
        Stream<String> stream7 = Arrays.stream(months);
        // nested
        Stream<int[]> stream8 = Arrays.stream(nested);
        // nested, flatted
        Stream<Integer> stream9 = Arrays.stream(nested).flatMap((Function<int[], Stream<Integer>>) ints -> Arrays.stream(ints).boxed());

        // lines from text-file
        Stream<String> stream10 = new BufferedReader(new FileReader(new File("path", "filename"))).lines();

        // stream from ANY iterable
        Stream<String> stream11 = StreamSupport.stream(new Months1().spliterator(), false);

        // integer stream (for-loop)
        IntStream intstream1 = IntStream.range(0, 10); // 0..9,    10 excluded
        IntStream intstream2 = IntStream.rangeClosed(0, 10); // 0..10    10 included
        IntStream intstream3 = IntStream.generate(() -> (int) (Math.random() * 100)).limit(10);// 10 random integers from 0-100 range
    }

    public static void main2(String[] args) {
        for (int i = 1 ; i<=10 ; i++ ) {
            System.out.print(i + " ");
        }
        System.out.println();
        IntStream.rangeClosed(1,10)
                .forEach(value -> System.out.print(value));
    }

    public static void main3(String[] args) {
        IntStream.rangeClosed(1,10)
                .map(new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return operand*2;
                    }
                })
                .forEach(value -> System.out.print(value));
    }

    public static void main4(String[] args) {
        IntStream.rangeClosed(1,10) // int
                .mapToObj(new IntFunction<String>() {
                    @Override
                    public String apply(int value) {
                        return ":: " + Integer.toString(value)+ " :::";
                    }
                }) // Stream<String>
                .forEach(value -> System.out.println(value));
    }

    public static void main5(String[] args) {
        Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()*100);
            }
        })
                //.skip(5)
                .limit(10)
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer value) {
                        return ":: " + Integer.toString(value)+ " :::";
                    }
                })
                .forEach(System.out::println);
    }

    public static void main6(String[] args) {
        Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()*100);
            }
        })
                //.skip(5)
                .limit(0)
                .findFirst()
                .ifPresent(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer v) {
                        System.out.println(v);
                    }
                });
    }

    public static void main7(String[] args) {
        Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()*100);
            }
        })
                .limit(10)
                .min(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                })
                .ifPresent(System.out::print);
    }

    public static void main8(String[] args) {
        List<Integer> collect = Stream.generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .collect(Collectors.toList());

        LinkedList<Integer> collect1 = Stream.generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .collect(Collectors.toCollection(LinkedList::new));

        Set<Integer> collect2 = Stream.generate(() -> (int) (Math.random() * 100))
                .limit(10)
                .collect(Collectors.toSet());
    }

    public static void main9(String[] args) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Stream<String> stream = Arrays.stream(months);
        Arrays.stream(months)
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));
    }

    public static void main10(String[] args) {
        int[][] complexArray = {{1,2},{3,4,5}};
        Stream<int[]> stream = Arrays.stream(complexArray);
        Stream<Integer> integerStream = Arrays.stream(complexArray)
                .flatMap((Function<int[], Stream<Integer>>) ints -> Arrays.stream(ints).mapToObj(value -> value));
    }

    static class Item {
        final char sym;
        final int pos;

        Item(char sym, int pos) {
            this.sym = sym;
            this.pos = pos;
        }

        public char sym() {
            return sym;
        }

        public int pos() {
            return pos;
        }

        @Override
        public String toString() {
            return String.format("Item:[sym:'%s',pos:%d]", sym, pos);
        }
    }

    public static void main11(String[] args) {
        String input = "This is test string";
        String collect = IntStream.range(0, input.length())
                .mapToObj(idx -> new Item(input.charAt(idx), idx))
                //.forEach(item -> System.out.println(item));
                .filter(item -> Character.isLetter(item.sym()))   // Stream<Item>
                //.forEach(item -> System.out.println(item));
                .collect(
                        Collectors.groupingBy(
                                item -> item.sym(),
                                Collectors.mapping(
                                        (Function<Item, Integer>) item -> item.pos(),
                                        Collectors.toList()
                                )
                        )
                )
                .entrySet().stream() // Map.Entry<Character, List<Integer>>
                .sorted((o1, o2) -> o1.getKey() - o2.getKey())
                .map(e -> String.format("%s=%s", e.getKey(), e.getValue()))
                .collect(joining(", "));

        System.out.println(collect);
    }

    public static void main12(String[] args) {
        String[] names = {"Alex", "Dima", "Andy", "Alex"};
        Map<String, Long> collect = Arrays.stream(names)
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()));

        System.out.println(collect);
    }

    static int gen () throws Exception {
        throw new Exception("Hello)))");
    }

    // stream don't know how to deal with cheched exceptions
    public static void main13(String[] args) {
        Stream<Integer> stream = Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    return gen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public static void main14(String[] args) {
        Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()*10);
            }
        }).limit(100)
                .distinct()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                })
                .forEach(i -> System.out.println(i));

        IntStream intStream = IntStream.rangeClosed(1, 10)
                //.parallel()
                .filter(i -> i % 2 == 0)
                .distinct();

        intStream.forEach(i -> System.out.println(i));
    }

    public static void main15(String[] args) {
        String s = "Hello World Alex Masha Dima Mama";
        String collect = Arrays.stream(s.split(" "))
                .map(s1 -> new StringBuilder(s1).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(s);
        System.out.println(collect);

    }
}
