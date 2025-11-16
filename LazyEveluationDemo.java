import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEveluationDemo {

    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Danish", "Raju", "Charlie", "David");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.length() > 4;
                });

        System.out.println("Before terminal operation");

        List<String> result = stream.collect(Collectors.toList());
        System.out.println("After Terminal Operation");
        System.out.println(result);
    }
}
