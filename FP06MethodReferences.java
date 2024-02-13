import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP06MethodReferences {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        courses.stream()
                //.map(str-> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);


        Supplier<String> supplier =  String::new;  //Constructor reference This will supply new object of type String

    }


}
