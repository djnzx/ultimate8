package streams.terminate.count;

import streams.initiation.StreamFromIterable;

public class Count {
    public static void main(String[] args) {
        StreamFromIterable si = new StreamFromIterable();
        long count = si.stream().count();
        System.out.println(count);
    }
}
