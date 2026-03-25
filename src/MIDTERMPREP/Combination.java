import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

record Employee (
    int id,
    String name,
    String department,
    double salary,
    boolean isActive
){
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", dept=" + department +
                ", salary=" + salary +
                '}';
    }
}



public class Combination {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "A", "IT", 90000, true),
                new Employee(2, "B", "IT", 120000, true),
                new Employee(3, "C", "HR", 70000, true),
                new Employee(4, "D", "HR", 80000, false)
        );


        // Q1 . Dept wise highesht salary
        // m1 - grouping is better than toMap here
        System.out.println("-----------------------------------");
        employees.stream().collect(Collectors.groupingBy(
                Employee::department,
                Collectors.maxBy(
                        Comparator.comparingDouble(
                                Employee::salary
                        )
                )
        )).forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value.orElse(null));
//            System.out.println(value.ifPresentOrElse(
//                    v -> System.out.println(v),
//                    () -> System.out.println("NONE")
//            ));
        });


        // m2 - by toMap
        System.out.println("-----------------------------------");
        employees.stream().collect(
                Collectors.toMap(
                        Employee::department,
                        Function.identity(),
                        (e1, e2) -> e1.salary() > e2.salary()? e1 : e2
                )
        ).forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });




        // Q2. Top 2 per dept
        System.out.println("-----------------------------------");
        employees.stream().collect(
                Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                                        .limit(2)
                        )
                )
        ).forEach((key, value)->{
            System.out.println(key);
            System.out.println(value);
        });


        // Q3. Get Department-wise Average Salary (Only Active Employees)
        System.out.println("-----------------------------------");
        // m1 - grouping
        employees.stream().filter( E -> E.isActive()).collect(
                Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                )
        ).forEach((key, value)->{
            System.out.println(key);
            System.out.println(value);
        });

        // m2 - toMap --- cant do
//                Collectors.toMap(
//                    Employee::department,
//                        Employee::salary,
//                        Double::average  // ❌  Double::sum/min/max exists -- Average is not a simple 2-value operation
//                )



    }
}