/*

Q9. Average Salary per Department
Using the same Employee list, compute average salary per department.

 */


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q9 {
    public static void main(String[] args){


        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("1", "Adesh", "IT", 60000),
                new Employee("2", "XYZ", "DS", 25000),
                new Employee("3", "ABC", "IT", 40000),
                new Employee("2", "WXYZ", "ECE", 25000)
        ));


        // M1 - averaging downstream by Collectors.averagingInt
        employees.stream().collect(
                Collectors.groupingBy(
                        s -> s.department,
                        Collectors.averagingInt(s -> s.salary)
                )
        ).forEach((k,v)-> System.out.println(k+ "; " + v));

        // M2 -




    }
}