/*

Q8. Max Element per Group
Given a List<Employee(id, name, department, salary)>, find the highest-paid employee in each department.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class Employee {
    String id;
    String name;
    String department;
    Integer salary;

    public Employee(String id, String name, String department, Integer salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class Q8 {
    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("1", "Adesh", "IT", 60000),
                new Employee("2", "XYZ", "DS", 25000),
                new Employee("3", "ABC", "IT", 40000),
                new Employee("2", "WXYZ", "ECE", 25000)
        ));

        BiConsumer<String, Employee> printMap = (k, v) -> System.out.println(k + "; " + v);

        employees.stream().collect(
                Collectors.toMap(
                        e -> e.department,
                        e -> e,
                        ((a, b) -> a.salary > b.salary? a : b )
                )
//        ).entrySet().forEach(e-> System.out.println(e.getKey() + "; " + e.getValue().name)); // using Entry Set -- offers get methods
        ).forEach((k,v)-> System.out.println(k+ "; " + v.name)); // Using ForEach directly



    }
}