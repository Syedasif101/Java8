import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface CharacterFinder{

    int findChar(char c);
}

class Cat {
    String name;
    int age;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


// Before Java8
//class CharFinderImpl implements CharacterFinder{
//
//    private String str;
//
//    public CharFinderImpl(String str)
//    {
//        this.str = str;
//    }
//
//    @Override
//    public int findChar(char c) {
//        return str.indexOf(c);
//    }
//}
public class MethodReferences {

    public static int triple(int num){
        return num * 3;
    }

    public static void main(String[] args)
    {
    //   CharacterFinder finder = new CharFinderImpl("racecar");
    //   System.out.println(finder.findChar('e'));
        // Using Lambda after java8
        String str = "Hello";

        CharacterFinder c1 = c -> str.indexOf(c);

        System.out.println(c1.findChar('e'));

        // using method reference
        CharacterFinder ch = str::indexOf;
        System.out.println(ch.findChar('H'));


        // using lambda
        Function<Integer, Integer> fn = num -> triple(num);
        System.out.println(fn.apply(10));

        // using method reference
        Function<Integer, Integer> fn1 = MethodReferences::triple;

        System.out.println(fn1.apply(30));



        // Reference to an instance method of an arbitrary object

        BiPredicate<String, String> biPredicate = String::startsWith;

        boolean result = biPredicate.test("Hello world", "He");
        System.out.println(result);

        biPredicate = String:: equalsIgnoreCase;

        boolean res = biPredicate.test("GoodBye", "gOoDbYe");
        System.out.println(res);



        // Reference to a constructor

        Supplier<Cat> catGetter = Cat::new;

        Cat c = catGetter.get();

        c.name = "Olivia";
        c.age = 4;

        System.out.println(c);
        
    }
}
