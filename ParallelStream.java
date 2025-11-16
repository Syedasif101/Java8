import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args)
    {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        // check the taken take to complete this operation using stream()
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorial = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream: " + (endTime-startTime) + " ms");


        // now check the time taken by using parallelStream()
        startTime = System.currentTimeMillis();
        List<Integer> list1 = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorial1 = list.parallelStream().map(ParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream: " + (endTime-startTime) + " ms");


        // parallel streams are most effective for CPU-Intensive or large datasets where tasks are independent
        // They may add overhead for simple tasks or small datasets
    }

    private static long factorial(int n)
    {
        int result = 1;
        for(int i=2; i<=n; i++)
        {
            result = result * i;
        }
        return result;
    }
}
