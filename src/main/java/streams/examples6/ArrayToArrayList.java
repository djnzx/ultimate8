package streams.examples6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToArrayList {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(collect);

        Integer[] ints2 = {1, 2, 3};
        List<Integer> integers = Arrays.asList(ints2);
        System.out.println(integers);
    }
}
