package java8.streams.initiation;

import org.junit.Test;
import source.Source;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamFromIterableTest {

    /*
    *  https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki
     */
    @Test
    public void test01() {
        Iterable<String> iterable = Source.iterables();

        List<String> result = StreamSupport.stream(iterable.spliterator(), false)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertThat(
                result,
                contains("TESTING", "ITERABLE", "CONVERSION", "TO", "STREAM")
        );
    }

}
