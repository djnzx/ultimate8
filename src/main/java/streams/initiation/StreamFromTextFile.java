package streams.initiation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class StreamFromTextFile {
    public static void main(String[] args) throws FileNotFoundException {
        Stream<String> stream10 =
                new BufferedReader(
                        new FileReader(
                                new File("path", "filename")
                        )
                ).lines();
    }
}
