import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

}
public class FP07CustomClassFunctional {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservice",97,22000),
                new Course("Microservices","Microservice",96,25000),
                new Course("Fullstack","Fullstack",91,14000),
                new Course("AWS","cloud",92,21000),
                new Course("Azure","cloud",99,21000),
                new Course("Docker","cloud",92,20000),
                new Course("Kubernetes","cloud",91,20000)
        );

        //allMatch :: Return true if all the courses from list matches the condition
        System.out.println(courses.stream()
                .allMatch(course -> course.getReviewScore() > 90));


        Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;

        System.out.println(courses.stream()
                .allMatch(reviewScoreGreaterThan95));

        //noneMatch :: Return true if no course from list matches the condition

        System.out.println(courses.stream()
                .noneMatch(reviewScoreGreaterThan95));

        //noneMatch :: Return true if any course (at least 1) from list matches the condition

        System.out.println(courses.stream()
                .anyMatch(reviewScoreGreaterThan95));

        //****************Sorting*****************
        //Comparator
        Comparator<Course> camparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(courses.stream()
                            .sorted(camparingByNoOfStudentsIncreasing)
                            .collect(Collectors.toList()));

        Comparator<Course> camparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream()
                .sorted(camparingByNoOfStudentsDecreasing)
                .collect(Collectors.toList()));

        Comparator<Course> camparingByNoOfStudentsThenReviewScore = Comparator.comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();
        System.out.println(courses.stream()
                .sorted(camparingByNoOfStudentsThenReviewScore)
                .collect(Collectors.toList()));

        //Using Premitive instead of wrapper class will increase the performance coz this will not do outboxing.
        Comparator<Course> camparingByNoOfStudentsThenReviewScorePremitive = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();
        System.out.println(courses.stream()
                .sorted(camparingByNoOfStudentsThenReviewScore)
                .collect(Collectors.toList()));

        //limit :: it will give the only number of elements given
        System.out.println(courses.stream()
                .sorted(camparingByNoOfStudentsThenReviewScore)
                .limit(5)
                .collect(Collectors.toList()));

        //Skip :: it will skip the given no of elements from start
        System.out.println(courses.stream()
                .sorted(camparingByNoOfStudentsThenReviewScore)
                .skip(3)
                .collect(Collectors.toList()));

        //takeWhile :: return until when conditions matches breaks when condition fails
        System.out.println(courses.stream()
                        .takeWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));

        //dropWhile :: return after conditions fails for the first time
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));

        //max :: get maximum value based on Predicate
        System.out.println(courses.stream()
                .max(camparingByNoOfStudentsThenReviewScore));

        //max :: get minimum value based on Predicate
        System.out.println(courses.stream()
                .min(camparingByNoOfStudentsThenReviewScore));

        //findFirst :: get first value
        System.out.println(courses.stream()
                        .filter(reviewScoreGreaterThan95)
                .findFirst());

        //findAny :: get any element :: there no selection criteria
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                .findFirst());

        //sum :: get sum of values
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        //average :: get average of values
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .average());

        //count :: get average of values
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .count());

        //max :: get maximum of values
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                .max());

        //************Grouping************
        //Group the stream based on criteria
        System.out.println( courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        // {cloud=[Course{name='AWS', category='cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='cloud', reviewScore=99, noOfStudents=21000}, Course{name='Docker', category='cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='cloud', reviewScore=91, noOfStudents=20000}],
        // Microservice=[Course{name='API', category='Microservice', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservice', reviewScore=96, noOfStudents=25000}],
        // Fullstack=[Course{name='Fullstack', category='Fullstack', reviewScore=91, noOfStudents=14000}],
        // Framework=[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}]}

        // Get maximum reviews in each category
        System.out.println( courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        //{cloud=Optional[Course{name='Azure', category='cloud', reviewScore=99, noOfStudents=21000}], Microservice=Optional[Course{name='API', category='Microservice', reviewScore=97, noOfStudents=22000}], Fullstack=Optional[Course{name='Fullstack', category='Fullstack', reviewScore=91, noOfStudents=14000}], Framework=Optional[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}]}


        // get the grouping and get only name of courses after grouping
        System.out.println( courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName,Collectors.toList()))));

        //{cloud=[AWS, Azure, Docker, Kubernetes], Microservice=[API, Microservices], Fullstack=[Fullstack], Framework=[Spring, Spring Boot]}

        //Join the course names
        System.out.println( courses.stream()
                        .map(Course::getName)
                .collect(Collectors.joining(" ; ")));

        //Split the course names in each letter
        //Flatmap used to replace element of streams with content of mapped stream
        System.out.println( courses.stream()
                .map(Course::getName)
                .map(course -> course.split(""))
                        .flatMap(Arrays::stream)
                .collect(Collectors.toList()));

        //[S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, F, u, l, l, s, t, a, c, k, A, W, S, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]

    }


}
