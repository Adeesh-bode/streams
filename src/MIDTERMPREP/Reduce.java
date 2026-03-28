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

public class Reduce {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "A", "IT", 90000, true),
                new Employee(2, "B", "IT", 120000, true),
                new Employee(3, "A", "HR", 70000, true),
                new Employee(3, "C", "HR", 70000, true),
                new Employee(4, "D", "HR", 80000, false)
        );



        // Q1 - Find total salary of all employees using reduce.

//        OR double total = employees.stream().map(Employee::salary).reduce(0.0, ( e1 , e2) -> e1 + e2);
//        ORRR :: double total = employees.stream().reduce(0.0, ( e1 , e2) -> e1.salary() + e2.salary());
//        ORRR :: double total = employees.stream().mapToDouble(Employee::salary).reduce(0.0,Double::sum);
         double total = employees.stream().mapToDouble(Employee::salary).sum();
        System.out.println(total);


        // Q2 - Find employee with highest salary using reduce
        System.out.println("--------------------------------------");
        System.out.println(employees.stream().reduce((e1,e2) -> e1.salary() > e2.salary()? e1:e2 ));

        // m2 - max comppartor
        employees.stream().max(Comparator.comparing(Employee::salary)).ifPresent(System.out::println);

        /*

// by sorted approach
Optional<Employee> result =
    employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .findFirst();

// by collectingAndThen
Employee result =
    employees.stream()
        .collect(Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
            opt -> opt.orElse(null)
        ));

         */

        // Q3 - Create a single string of all employee names separated by comma.
        // m1 - joining
        System.out.println("------------------------------------");
        System.out.println(employees.stream().map(Employee::name).collect(
                Collectors.joining(",")
        ));

        // m2 -reduce
        System.out.println("------------------------------------");
        System.out.println(
//                employees.stream().map(Employee::name).reduce((a,b) -> a + ", " + b ).get()
                employees.stream().map(Employee::name).reduce((a,b) -> a + ", " + b ).orElse("")
        );

        // q4. Q4. Custom Aggregation (Total Salary of IT Department)
        System.out.println("------------------------------------");
        double totalIt = employees.stream().filter(e-> e.department().equals("IT")).mapToDouble(Employee::salary).sum();
        System.out.println(totalIt);

        // say do by parallel stream
        double totalIt2 =
                employees.parallelStream()
                        .filter(e-> e.department().equals("IT"))
                        .mapToDouble(Employee::salary)
                        .sum();
        System.out.println(totalIt2);

    }
}