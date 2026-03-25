import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
class Employee {
    private int salary;
    private String name;
    private String dept;
    private String empId;

    public Employee(String empId, int salary, String name, String dept) {
        this.empId = empId;
        this.salary = salary;
        this.name = name;
        this.dept = dept;
    }

    public int getSalary() { return salary; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public String getEmpId() { return empId; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + empId +
                ", name=" + name +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }
}


public class Mapping {
    public static void main(String[] args) {


        // Q1. Handle Duplicate Keys (🔥 VERY COMMON) // merger ftn use
        List<Employee> employees = List.of(
                new Employee("E101", 3000, "Adesh", "IT"),
                new Employee("E102", 4000, "Tushar", "HR"),
                new Employee("E103", 2500, "Rahul", "IT"),
                new Employee("E104", 5000, "Sneha", "Sales"),
                new Employee("E101", 6000, "Priya", "HR"),
                new Employee("E106", 4500, "Amit", "IT")
        );


        employees.stream().collect(Collectors.toMap(
                Employee::getEmpId,
//                E -> E
                Function.identity(),
//                (e1, e2) -> e1  // keep 1st employee if duplicate Id
                (e1, e2) -> e1.getSalary() > e2.getSalary()? e1:e2
        )).forEach((key, value) -> System.out.println(key + " : " + value));


        // Q2. Create Nested Map (Department → Name → Salary)
        System.out.println("------------------------------------");
        employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.toMap(
                                Employee::getName,
                                Employee::getSalary
                                // can have a merger ftn for case same dept, same name employee
                        )
                )
        ).forEach((key, value) -> System.out.println(key + " : " + value));


        // Q3. List → Map (Grouping with Aggregation) - department → total salary
        System.out.println("------------------------------------");
        // m1 - groupingBy ( prefered as key can be duplicate )
        employees.stream().collect(
                Collectors.groupingBy(
                        e->e.getDept(),
                        Collectors.summingInt(Employee::getSalary)
                )
        ).forEach((key, value) -> System.out.println(key + " : " + value));

        // M2 - toMap

        System.out.println("=====================");
        employees.stream().collect(
                Collectors.toMap(
                        Employee::getDept,
                        Employee::getSalary,
                        Integer::sum // MERGER FTN MUSTTTTT - Responsible to Handle Key Collision
                )
        ).forEach((key, value) -> System.out.println(key + " : " + value));







    }
}