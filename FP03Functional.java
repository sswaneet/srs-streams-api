import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        Predicate<Integer> evenPredicate = x -> x % 2 == 0; // Implementation of functional interface as Predicate interface
        filterAndPrint(numbers, evenPredicate);

        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        filterAndPrint(numbers, oddPredicate);

        //Above can also be written like this;
        filterAndPrint(numbers, x -> x % 3 == 0); // Now we can flexibly change the lambda expression and result will be as required

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
