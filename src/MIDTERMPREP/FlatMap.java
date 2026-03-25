
import java.util.*;
import java.util.stream.*;


class Employee {
    private int salary;
    private String name;
//    private String dept;

    public Employee(String name, int salary) {
        this.salary = salary;
        this.name = name;
//        this.dept = dept;
    }

    public int getSalary() {
        return this.salary;
    }
    public String getName() {
        return this.name;
    }

//    public String getDept() {
//        return this.dept;
//    }

    @Override
    public String toString() {
        return "Employee{" + "salary=" + salary + ", name=" + name + '}';
    }
}

class Department {
    String name;
    List<Employee> employees;

    Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }
}


public class FlatMap {
    public static void main(String[] args) {

        // q1. normal flatmap
        List<List<Integer>> numbers = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        // List::stream → converts each inner list into a stream
        // THAN flatMap → flattens all streams into one
        numbers.stream().flatMap(List::stream).forEach(System.out::println);

        // q2. filter + flatmap
//        before flattening (more efficient)
        List<Integer> result =
                numbers.stream()
                        .flatMap(list -> list.stream().filter(n -> n % 2 == 0))
                        .collect(Collectors.toList());


        // q3. Flatten Nested Objects to employees list across all depts
        List<Department> departments = List.of(

                new Department("HR", List.of(
                        new Employee("Alice", 3000),
                        new Employee("Bob", 1500)
                )),

                new Department("IT", List.of(
                        new Employee("Charlie", 5000),
                        new Employee("David", 4000)
                )),

                new Department("Sales", List.of(
                        new Employee("Eve", 2500),
                        new Employee("Frank", 2000)
                ))
        );

        System.out.println("--------------------------------------\n");
//        departments.stream().map(Department::getEmployees).flatMap(List::stream).forEach(System.out::println);

        // directly
        departments.stream().flatMap(dept -> dept.getEmployees().stream()).forEach(System.out::println);



        // Q4. Flatten Optional Values - Extract only present values.
        System.out.println("--------------------------------------\n");

        List<Optional<String>> optionals = List.of(
                Optional.of("Adesh"),
                Optional.ofNullable(null),
                Optional.empty(),
                Optional.of("Tushar")
        );

        // m1- java 8+ Optional::stream - better as Avoids unsafe .get() and is cleaner
        optionals.stream().flatMap(Optional::stream).forEach(System.out::println);

        // m2 - old school
        optionals.stream().filter(Optional::isPresent).map(Optional::get).forEach(System.out::println);


        // Q5. String to 2d to chars stream

        List<String> words = List.of("java", "stream");

        // this will give strings stream
        words.stream().flatMap(str -> Arrays.stream( str.split(""))).distinct().forEach(System.out::println);

        // but as we want char stream
        List<Character> chars = words.stream().flatMap(str -> Arrays.stream(str.split(""))).distinct().map(s-> s.charAt(0)).toList();

        chars.forEach(System.out::println);

        // Q6 . Flatten map object
        Map<String, List<String>> mp = Map.of(
                "A", List.of("a1", "a2"),
                "B", List.of("b1", "b2")
        );

        mp.entrySet().stream().flatMap(entry-> entry.getValue().stream()).forEach(System.out::println);


        // better
        mp.values().stream().flatMap(List::stream).forEach(System.out::println);


        // Q7. Split Sentences into Words (Real-World Problem)
        List<String> sentences = List.of(
                "Java is powerful?",
                "Streams are useful"
        );

        sentences.stream().flatMap(
                sent -> Arrays.stream(sent.split("\\W+"))   // W/w - refers non word/word characters , s - whitespaces
        ).forEach(System.out::println);

        // Q8. Cartesian Product (🔥 Interview Favorite)
        List<String> list1 = List.of("A", "B");
        List<Integer> list2 = List.of(1, 2);

        list1.stream().flatMap(
                a -> list2.stream().map(
                        b -> a+b
                )
        ).forEach(System.out::println);

    }
}