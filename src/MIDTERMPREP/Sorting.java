import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import import java.util.function.*;

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

public class Sorting {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "A", "IT", 90000, true),
                new Employee(2, "B", "IT", 90000, true),
                new Employee(3, "A", "HRA", 120000, true),
                new Employee(3, "C", "HRBC", 70000, true),
                new Employee(4, "D", "HRAAA", 80000, false)
        );


        // Q1. Sort employees by salary in ascending order. Sort and Get Top 3 Highest Salaries
        // m1- using compaarator
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary))
                .collect(Collectors.toList())
                .limit(3)
                .forEach(System.out::println);

        // m2 - using custom logic
        System.out.println("--------------------------------");
        employees.stream()
//UTH:          .sorted((e1, e2) -> e1.salary()>e2.salary()? 1:-1) // e1 bada -- e1 badme aaega
                .sorted((e1, e2) -> Double.compare(e1.salary(), e2.salary())) // e1 bada -- e1 badme aaega
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

//        Q2. Sort by Salary Descending, Then Name Ascending
        System.out.println("------------------m1-using comparator--------------");
        employees.stream().sorted(
                Comparator.comparingDouble(Employee::salary).reversed()
                        .thenComparing(Comparator.comparing(Employee::name))
        ).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("------------------m1-using comparator--------------");
        employees.stream().sorted(
                (e1, e2) ->{
                    int sorted = Double.compare(e2.salary(), e1.salary()); // descending order
                    if(sorted !=0){
                        return sorted;
                    }

                    sorted = e1.name().compareTo(e2.name()); // ascending order for name
                    return sorted;
                }
        ).collect(Collectors.toList()).forEach(System.out::println);


        // Q1. Sort employees by dept len in ascending order.
        System.out.println("------------------m1-using comparator--------------");
        // m1- using compaarator
        employees.stream()
                .sorted(Comparator.comparingInt( ( Employee e) -> e.department().length()).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}