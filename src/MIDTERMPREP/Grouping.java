
import java.util.*;
import java.util.stream.*;

class Employee {
    private int salary;
    private String name;
    private String dept;

    public Employee(int salary, String name, String dept) {
        this.salary = salary;
        this.name = name;
        this.dept = dept;
    }

    public int getSalary() {
        return this.salary;
    }
    public String getName() {
        return this.name;
    }

    public String getDept() {
        return this.dept;
    }

    @Override
    public String toString() {
        return "Employee{" + "salary=" + salary + ", name=" + name + '}';
    }

}


publc class Grouping{

    public static void main(String[] args) {
        List<Employee> e = new ArrayList<>( // or better is direct List.of as we dont want mutable
                List.of(
                        new Employee(2000, "Adesh", "ENGLISH"),
                        new Employee(3000, "Benjamin", "MATHS"),
                        new Employee(4000, "Daniel", "ENGLISH"),
                        new Employee(5000, "Dan", "FRENCH"),
                        new Employee(5000, "Man", "GERMAN")
                )
        );


        // Q2 - group emp by dept
        Map<String, List<Employee>> depts = e.stream().collect(Collectors.groupingBy(
                E -> E.getDept(),
                Collectors.toList()
        ));

        // map another way to itterate other than entry set
        depts.forEach((dept, e1) -> {
            System.out.println(dept);
            System.out.println(e1);
        });

        // Q3.  count emp

        System.out.println("\n-------------------------------------\n");

        e.stream().collect(Collectors.groupingBy(
                E -> E.getDept(),
                Collectors.counting()
        )).forEach((dept, e1) -> {System.out.println(dept);System.out.println(e1);});


        // Q4. Group and Transform (Department → Employee Names)

        System.out.println("\n-------------------------------------\n");

        e.stream().collect(Collectors.groupingBy(
                E -> E.getDept(),
                Collectors.mapping(Employee::getName, Collectors.toList())
        )).forEach((dept, e1) -> {System.out.println(dept);System.out.println(e1);});


        System.out.println("\n-------------------------------------\n");
        // Q5. Multi-Level Grouping (Department → Salary Range)

        Map<String, Map<String, List<Employee>>> nestedMap =  e.stream().collect(Collectors.groupingBy(
                Employee::getDept, // classifier
                Collectors.groupingBy( // downstream
                        emp -> {
                            if(emp.getSalary() <=2000 ) return "LOW";
                            else if (emp.getSalary() >2000 && emp.getSalary() <=4000) return "MEDIUM";
                            else  return "HIGH";
                        }
                )
        ));

        // nested map cant be dealt :: Java does NOT support nested tuple destructuring

        nestedMap.forEach((dept, categoryMap) -> {
            categoryMap.forEach((cat, EMPLOYEES) -> {
                System.out.println(dept + " " + cat);
                System.out.println(EMPLOYEES);
            });
        });


        // Q6. Partition Employees (High Salary vs Others) - by 4k salary

        System.out.println("\n-------------------------------------\n");

//      Map<Boolean, List<Employee>> emps =
        e.stream().collect(
                Collectors.partitioningBy(
                        E -> E.getSalary() >= 4000
                )).forEach((bool, empss) -> {
                    System.out.println(bool);
                    System.out.println(empss);
                }
        );


    }


    }
}


