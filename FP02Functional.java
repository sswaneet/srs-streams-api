import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {


        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        //printAllCoursesInListFunctional(courses);

        //printSpringCoursesInListFunctional(courses);

        //12print4lettersCoursesInListFunctional(courses);

        //printLengthCoursesInListFunctional(courses);

        moreStreamOperations(courses);

        // use collect to create a list from existing list
        List<Integer> coursesLength = courses.stream().map(str->str.length())
                .collect(Collectors.toList());
        
    }

    private static void printAllCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printSpringCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .filter(course-> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void print4lettersCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .filter(course-> course.length()>=4)
                .forEach(System.out::println);
    }

    // use of map() to map course name with length of string
    private static void printLengthCoursesInListFunctional(List<String> courses) {
        courses.stream()
                .map(course-> course.length())
                .forEach(System.out::println);
    }

    private static void moreStreamOperations(List<String> courses) {

        // Sort the list of String
        courses.stream().sorted().forEach(System.out::println);

        // Sort the list of String in natural order(ascending order)
        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        // Sort the list of String in reverse order(descending order)
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Sort the list of String in campare of length of string
        courses.stream().sorted(Comparator.comparing(course->course.length())).forEach(System.out::println);


    }


}
