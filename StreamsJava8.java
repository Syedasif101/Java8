import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsJava8 {

    public static void main(String[] args)
    {

        // why streams

        // Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism


        // What is Stream?
        // a sequence of elements supporting functional and declarative Programming

        // How to use Stream?
        // Source, Intermediate operations & terminal Operation
        List<Integer> list = Arrays.asList(2,3,4,5,6,7,8);
        System.out.println(list.stream().filter(x -> x % 2 == 0).count());

        // Create Streams
        // 1. From Collections

        list.stream().filter(x -> x % 2 == 0).count();

        // 2. From Arrays
        String[] arr = {"a","b","c"};
        Stream<String> stream = Arrays.stream(arr);

        // 3. Using StreamOf
        Stream<String> stream1 = Stream.of("A","B","c");

        // 4. Infinite Streams
        Stream<Integer> generate = Stream.generate(() -> 1).limit(100);


        // 5. From Iterate
        Stream.iterate(1, x -> x + 1).limit(100);



    }
}
