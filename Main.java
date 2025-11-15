//Java 8

// Minimal Code
// Functional Programming
// Lambda Expressions
// Streams
// Date and Time api

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;

//Lambda Expression is an anonymous function (no name, no return type no access Modifier)
public class Main {

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Test()); // instead of using object here as new Test we can use lambda Expression

        Thread t1 = new Thread(() -> {
            System.out.println("Hello");
        });



        // Before java8
        SumOperation s = new SumOperation();
        System.out.println(s.operate(10,20));

        SubtractOperation st = new SubtractOperation();
        System.out.println(st.operate(20,10));

        // After Java8 using Lambda

        MathOperation sumOperation = ( a,  b) -> a + b;

        System.out.println(sumOperation.operate(20, 30));


        MathOperation subtractOperation = (a,b) -> a - b;

        System.out.println(subtractOperation.operate(40,10));

//        --> Predicate -> Functional Interface --> Boolean Valued Function whose functional method is test(Object).

       // After Java8
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(10));


        // Second Example of Predicate
        Predicate<String> startsWithA = x->x.toLowerCase().startsWith("r");

        Predicate<String> endsWith = x -> x.toLowerCase().endsWith("a");

        // Combine Predicates
        Predicate<String> and = startsWithA.and(endsWith);

        System.out.println(startsWithA.test("Rabiya"));

        System.out.println(and.test("Rahida"));


        // Function --> work for you

        Function<Integer, Integer> doubleIt = x -> 2 * x;
        System.out.println(doubleIt.apply(20));

        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println(tripleIt.apply(50));

//         andThen

        Function<Integer, Integer> doubleTriple = doubleIt.andThen(tripleIt);

        System.out.println(doubleTriple.apply(100));

//        Compose

        Function<Integer, Integer> c = doubleIt.compose(tripleIt);

        // here first triple it will be performed then double it

        System.out.println(c.apply(2));


        // Before Java8
        isEven e = new isEven();
        System.out.println(e.test(11));


        // Identity
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(3));


        // Consumer accepts something but doesn't return anything

        Consumer<Integer> print = x -> System.out.println(x);

        print.accept(10);

        List<Integer> list = new ArrayList<>(Arrays.asList(20,30,40,50));

        Consumer<List<Integer>> consumer= x -> {
            for(Integer i: x)
            {
                System.out.print(i + " ");

            }
        };

        consumer.accept(list);

        System.out.println();

//        Supplier accepts nothing but returns something

        Supplier<String> giveHelloWorld = () -> "Hello, World!";

        System.out.println(giveHelloWorld.get());


        // Combined Example

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Function<Integer, Integer> fn = x -> x*x;
        Consumer<Integer> consume = x -> System.out.println(x);
        Supplier<Integer> suplier = () -> 100;


        if(isEven.test(suplier.get()))
        {
            consume.accept(fn.apply(suplier.get()));
        }


        //BiPredicate, Bifunction, BiConsumer
        BiPredicate<Integer, Integer> bp = (x,y)-> (x + y) % 2 == 0;
        System.out.println(bp.test(10,20));

        BiConsumer<Integer, String> biConsumer = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept(10,"Syeda");


        BiFunction<String, String, Integer> biFunction = (x, y) ->
            (x + y).length();


        System.out.println(biFunction.apply("Rabia", "Isha"));


    }
}

 class isEven implements Predicate<Integer>{
    @Override
    public boolean test(Integer x) {
        if(x % 2 == 0)
        {
            return true;
        }
         else{
             return false;
        }
    }
}



interface MathOperation{
    int operate(int a, int b);
}

// Before Java8 we have to implement Runnable methods
class Test implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

// Assume Lambda Expression don't exist then we have to do like this and implement every math operation in its own class


// Before Java8
 class SumOperation implements MathOperation{
    public int operate(int a, int b){
        return a + b;
    }
}

// Before Java8
 class SubtractOperation implements MathOperation{
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}


