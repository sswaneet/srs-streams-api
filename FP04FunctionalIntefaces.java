import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP04FunctionalIntefaces {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        //Functional Interface for filter()
        // One Input and return boolean output
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;

        //Functional Interface for map()
        Function<Integer, Integer> mappingFunction = x -> x * x;

        //Functional Interface for forEach()
        Consumer<Integer> printConsumer = System.out::println;

        //Functional Interface for reduce()
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

        //replace above lambda with method reference
        BinaryOperator<Integer> sumBinaryOperator2 = Integer::sum;

        numbers.stream()
                .filter(evenPredicate)
                .map(mappingFunction)
                .forEach(printConsumer);

        numbers.stream()
                .filter(evenPredicate)
                .map(mappingFunction)
                .reduce(0, sumBinaryOperator2);

        //Other Functional Interfaces

        //Supplier
        //No Input -> Parameter is output return type here :: Integer as output in below
        Supplier<Integer> randomNumberGenerate = ()-> {
            Random random = new Random();
            return random.nextInt();
        };

        System.out.println(randomNumberGenerate.get());

        //UnaryOperator
        // One Parameter only If Integer input then return Integer output only
        UnaryOperator<Integer> unaryOperator = x->3*x;
        System.out.println(unaryOperator.apply(10));

        //BiPredicate
        // Same As predicate but Two input types are given and Boolean output will return
        BiPredicate<Integer,String> biPredicate = (number,string) -> {
            return number <10 && string.length() > 5;
        };

        System.out.println(biPredicate.test(5,"Swaneet"));


        //BiFunction
        // Same As Function Interface but first Two parameters are input types are given and third parameter is output type that will return
        BiFunction<Integer,String,String> biFunction = (number,string) -> {
            return number + "::" + string;
        };

        System.out.println(biFunction.apply(10,"Swaneet"));

        //BiConsumer
        // Same As Consumer Interface but Two parameters are given as input type and return no output i.e. return type is void
        BiConsumer<String,String> biConsumer = (string1,string2) -> {
            System.out.println(string1);
            System.out.println(string2);
        };

        biConsumer.accept("Deeksha","Swaneet");



    }


}
