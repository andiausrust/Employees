package andi.com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static sun.misc.PostVMInitHook.run;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("hohn", 10);
        Employee max = new Employee("max", 30);
        Employee mile = new Employee("mile", 36);
        Employee uni = new Employee("uni", 31);
        Employee auni = new Employee("auni", 10);
        Employee huni = new Employee("huni", 3);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName();
        };

        List<Employee> employeeList = Arrays.asList(john, max, mile, auni, uni, auni, huni);

        System.out.println("Employees over 30");
        employeeList.forEach(employee ->
            System.out.println(employee.getName() + " " + employee.getAge()));
        System.out.println("Employees over 30: ");
        employeeList.forEach(employee -> {
            if (employee.getAge()>30)
                System.out.println(employee.getName());
        });

        System.out.println("#########################################################");
        System.out.println("Employees under 30: ");
        employeeList.forEach(employee -> {
            if(employee.getAge()<30)
                System.out.println(employee.getName());

        });
        System.out.println("#########################################################");

        printEmployeesByAge(employeeList, "Emloyees over 30: ",
                employee -> employee.getAge()>30);

        printEmployeesByAge(employeeList, "Employees under 30: ",
                employee -> employee.getAge()<=30);

        IntPredicate greaterThanFifteen = i -> i>15;
        IntPredicate lessThanHundred = i -> i<100;
        System.out.println(greaterThanFifteen.test(10));
        System.out.println(lessThanHundred.test(10));

    employeeList.forEach(
            employee -> {
              //  String lastName = employee.getName().substring(employee.getName().indexOf(' ') +1);
                System.out.println("last name is: " + employee.getName());
            }
    );


    }


    public static void printEmployeesByAge (List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition){
        System.out.println(ageText);
        for(Employee employee : employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }

       /* employees.forEach(employee -> {
            if (employee.getAge()>30)
                System.out.println(employee.getName());
        });*/
    }
}
