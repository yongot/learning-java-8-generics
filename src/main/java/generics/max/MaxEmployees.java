package generics.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yongot
 * @created 2020-10-24 : 4:31 PM
 */
public class MaxEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenanajar"),
                new Employee(3, "Michael Bolton"),
                new Employee(4, "Milton Waddams")
        );
    }

    public static void main (String ... args) {
        List<Employee> employees = createEmployees();
        Employee maxId = employees.stream().max((Employee o1, Employee o2) -> o1.getId() - o2.getId()).orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxName = employees.stream().max(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        }).orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println(maxId);
        System.out.println(maxName);

        maxId = employees.stream().max(Comparator.comparingInt(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
        maxName = employees.stream().max(Comparator.comparing(Object::toString)).orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println(maxId);
        System.out.println(maxName);

    }
}
