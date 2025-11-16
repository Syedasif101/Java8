import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class IntermidiateOps {

    public static void main(String[] args){
        // Intermediate Operations transform a stream into another stream
        // They are lazy, meaning they don't execute until a terminal operation is invoked

        List<String> list = Arrays.asList("Akshit","Ram","Shayam", "Ghansham","Akshit");

        // Filter
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // no filtering at this point cause there is no terminal operation
        long res  = list .stream().filter(x->x.startsWith("A")).count();
        System.out.println(res);


        // map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);
        
        // sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a,b)->a.length() - b.length());

        // distinct
        System.out.println(list.stream().filter(x->x.startsWith("A")).distinct().count());

        // Limit
//        Stream<Integer> limit = Stream.iterate(1, x -> x + 1).limit(100);
//        limit.forEach(System.out::println);

        // skip
        Stream<Integer> l = Stream.iterate(1, x -> x + 1).skip(10).limit(20);
        l.forEach(System.out::println);

        // forEach (Terminal Operator)
        List<Integer> newList = Arrays.asList(1,2,3,4);
        newList.forEach(System.out::println);

        // reduce
        Optional<Integer> reduce = newList.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

        // terminal operator

        // count

        // anyMatch, allMatch, noneMatch
        boolean b = newList.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean b1 = newList.stream().allMatch(x -> x > 0);
        System.out.println(b1);

        boolean b2 = newList.stream().noneMatch(x -> x < 0);
        System.out.println(b2);

        // findFirst, findAny

        System.out.println(newList.stream().findFirst().get());
        System.out.println(newList.stream().findAny().get());

        // stateful and stateless
        // stateful like distinct(), sorted()
        // stateless like map()


        // peek is same as forEach but peek is intermediate operator while as forEach() is terminal operator
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        // toArray
        Object[] array = Stream.of(2, 44, 33, 12).toArray();

        // min, max
        Stream.of(1,2,3).max(Comparator.naturalOrder());
        Stream.of(1,2,3).min(Comparator.naturalOrder());

        // using lambda
        Stream.of(1,2,3).min((o1,o2) -> o2 -o1);

        // flatMap
        // Handle streams of collections, lists, or group where each element is itself a collection
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time


        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange","kiwi"),
                Arrays.asList("pear", "grape")
        );

        System.out.println(listOfLists.get(1).get(1));

        // i dont want nested lists so we can use flatMap here

        List<String> list1 = listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList();
        System.out.println(list1);


        // Take another Example

        List<String> sentences = Arrays.asList(
            "Hello Good Morning","Java is Powerful", "faltMap is Powerful"
        );

        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toUpperCase).toList());


        // One more
        List<String> sen = Arrays.asList(
            "Good Afternoon Namrata Mam",
            "Today's Topic is Spring boot dependency injection"
        );

        System.out.println(sen
                .stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toUpperCase).toList());


        List<String> names = Arrays.asList("shahid", "owais", "amir", "witty");
        Stream<String>   = names.stream();


    }
}
