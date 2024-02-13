import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP08PreformanceImprovement {

    public static void main(String[] args) {


        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println(courses.stream().filter(course->course.length()>11).map(String::toUpperCase)
                .findFirst());

        System.out.println(courses.stream().peek(System.out::println).filter(course->course.length()>11).map(String::toUpperCase).peek(System.out::println)
                .findFirst()); // This will not going to traverse all element.


    }




}
