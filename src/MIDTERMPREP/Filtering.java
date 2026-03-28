import java.util.*;
import java.util.stream.*;
import java.util.function.*;


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

public class Filtering {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "A", "IT", 90000, true),
                new Employee(2, "B", "IT", 90000, true),
                new Employee(3, "A", "HRA", 120000, true),
                new Employee(3, "C", "HRBC", 70000, true),
                new Employee(4, "D", "HRAAA", 80000, false)
        );


        // Filter Active IT Employees - Multiple filter
        // Multiple filters improve readability and debugging instead of &&

        employees.stream()
                .filter(e -> e.department().equals("IT"))
                .filter(e -> e.isActive())
                .toList()
                .forEach(System.out::println);

        // m2 - writing a predicate
        System.out.println("-w----riting a prediate");
        Predicate<Employee> it = e -> e.department().equals("IT");
        Predicate<Employee> active =e -> e.isActive();
//        Predicate<Employee> young = e-> e.age() > 20
        employees.stream()
//                .filter(it && active)    NOT VALID --- only condtn can
//                Predicate composition
                .filter(it.and(active))  // .and(young ) can also be added
//                .filter(it)
//                .filter(active)
                .toList()
                .forEach(System.out::println);









    }
}