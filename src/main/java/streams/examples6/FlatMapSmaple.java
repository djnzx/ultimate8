package streams.examples6;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapSmaple {
    static int[][] a = new int[10][10];

    // array initialization with random values;
    static {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j]=(int)(Math.random()*100);
            }
        }
    }

    public static void easySample() {
        Stream.of(a).forEach(new Consumer<int[]>() {
            @Override
            public void accept(int[] ints) {
                System.out.println(Arrays.toString(ints));
            }
        });
    }

    public static void flatMapSample() {
        Arrays.stream(a)
                .flatMap(new Function<int[], Stream<Integer>>() {
                    @Override
                    public Stream<Integer> apply(int[] ints) {
                        return Arrays.stream(ints).boxed();
                    }
                })
                .sorted()
                .forEach(i -> System.out.print(i+" "));
    }

    public static void main(String[] args) {
        easySample();
        System.out.println("---------");
        flatMapSample();
    }

}
