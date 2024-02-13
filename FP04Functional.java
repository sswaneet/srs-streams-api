import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        //First Integer parameter is input second is output
        Function<Integer, Integer> mappingFunction = x -> x * x;

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);

        //Now it is generic method for mappping and collecting in a list, We can change lambda expression as per requirement
        List<Integer> cubeNumbers = mapAndCreateNewList(numbers, x-> x*x*x);

        System.out.println(cubeNumbers);

    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }


}
