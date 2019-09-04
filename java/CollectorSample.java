import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is based on Quiz Yourself: Using Collectors published in Java Magazine (Sep, 2019)
 */
public class CollectorSample {

    public static void main(String[] a) {
        List<Student> studentList = initializeStudentList();
        print(studentList);
    }

    private static List<Student> initializeStudentList() {
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("John", 15));
        studentList.add(new Student("William", 18));
        studentList.add(new Student("James", 22));
        studentList.add(new Student("George", 14));
        studentList.add(new Student("Joseph", 19));
        studentList.add(new Student("Frank", 16));
        studentList.add(new Student("Henry", 23));
        studentList.add(new Student("Thomas", 20));
        studentList.add(new Student("Harry", 27));

        return studentList;
    }

    private static void print(List<Student> studentList) {
        printCountOfStudentAges(studentList);
        printCountOfStudentAgesByPredicate(studentList);
    }

    /**
     * Prints ages and their counts in the list.
     * @param studentList
     */
    private static void printCountOfStudentAges(List<Student> studentList) {
        studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting())).forEach((k, v) -> System.out.print(k + " = " + v + ", "));
    }

    /**
     * Printing count of student ages based on a condition.
     * @param studentList
     */
    private static void printCountOfStudentAgesByPredicate(List<Student> studentList) {
        studentList.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 18, Collectors.counting()))
                .forEach((key, val) -> System.out.print(key + " " + val + " "));
    }
}

class Student {

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
