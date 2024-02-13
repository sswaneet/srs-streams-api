import java.util.List;
import java.util.stream.Collectors;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> list = List.of(12,9,13,4,6,2,4,12,15);

        //printAllNumbersInListFunctional(list);

        //printEvenNumbersInListFunctional(list);



        //printSquareOfEvenNumbersInListFunctional(list);

        int sum = sumOfListFunctional(list);
        //print(sum);

        //reduceOperations(list);

        //moreStreamOperations(list);

        List<Integer> doubledList = doubledTheList(list);

        doubledList.stream().forEach(System.out::println);
        
    }


    private static void print(int num)
    {
        System.out.println(num);
    }

    private static boolean isEven(int num)
    {
        return num % 2 == 0;
    }
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream().forEach(FP01Functional::print); //method reference (should be static method)

        numbers.stream().forEach(System.out::println); //method reference directly print (should be static method)

    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        // filter using method reference
        numbers.stream()
                .filter(FP01Functional::isEven)//Filter - Allows even numbers only
                .forEach(System.out::println); //method reference directly print (should be static method)

        // filter using lambda expression
        numbers.stream()
                .filter(num -> num%2 == 0)//Filter with Lambda Expression - Allows even numbers only
                .forEach(System.out::println); //method reference directly print (should be static method)

    }


    // Use map to map stream with square of numbers
    private static void printSquareOfEvenNumbersInListFunctional(List<Integer> numbers) {

        // filter using lambda expression
        numbers.stream()
                .filter(num -> num%2 == 0)//Filter with Lambda Expression - Allows even numbers only
                .map(number -> number * number) // map stream of number with stream of square of number
                .forEach(System.out::println); //method reference directly print (should be static method)

    }

    private static int sum(int a, int b)
    {
        return a+b;
    }

    // use reduce() to combine the stream into one single value
    private static int sumOfListFunctional(List<Integer> numbers) {

         numbers.stream()
                .reduce(0,FP01Functional::sum); // reduce to combine the result into one value

         numbers.stream()
                .reduce(0,(x,y) ->x+y); // reduce to one value using lambda aggregation

//        x + y and value of addition set to x
//        0 + 12 = 12
//        12+ 9 = 21 ...

        return numbers.stream()
                .reduce(0,Integer::sum); // reduce to one value using sum method of Integer class

    }

    private static void reduceOperations(List<Integer> numbers) {

        // print x
         print(numbers.stream()
                .reduce(0,(x,y) ->x)); // return x everytime which is 0 initially

        //print y
        print(numbers.stream()
                .reduce(0,(x,y) ->y)); // return y which is 15 in the last

        //print Maximum value
        print(numbers.stream()
                .reduce(0,(x,y) -> x>y? x: y)); // return maximum value but this logic will also consider 0 as part of list will give 0 max if list having negative integers

        //print Correct Maximum value
        print(numbers.stream()
                .reduce(Integer.MIN_VALUE,(x,y) -> x>y? x: y)); // return maximum value but this logic will also consider the lowest negative integer as part of list and give correct

        //print minimum value
        print(numbers.stream()
                .reduce(0,(x,y) -> x<y? x: y)); // return minimum value which is 0 here bcoz this logic will also consider 0 as part of initial value

        //print correct minimum value
        print(numbers.stream()
                .reduce(Integer.MAX_VALUE,(x,y) -> x<y? x: y)); // return minimum value which is 0 here bcoz this logic will also consider 0 as part of initial value

        //print sum of squares of numbers
        print(numbers.stream()
                .map(num -> num*num)
                .reduce(0,Integer::sum)); // return minimum value which is 0 here bcoz this logic will also consider 0 as part of initial value

        //print sum of odd numbers
        print(numbers.stream()
                .filter(x -> x%2==1)
                .reduce(0,Integer::sum)); // return minimum value which is 0 here bcoz this logic will also consider 0 as part of initial value


    }


    //Other Stream methods

    private static void moreStreamOperations(List<Integer> numbers) {
        //numbers.stream().distinct().forEach(System.out::println);

        //numbers.stream().sorted().forEach(System.out::println);

        numbers.stream().sorted().distinct().forEach(System.out::println);
    }


    private static List<Integer> doubledTheList(List<Integer> list) {
        // use collect to create a list from existing list
       return list.stream()
               .map(num->num+num)
               .collect(Collectors.toList()); // use collect to create a list from existing list
    }


}
