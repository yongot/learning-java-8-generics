package generics.map;

import generics.max.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @author yongot
 * @created 2020-10-24 : 5:05 PM
 */
public class MapEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenanajar"),
                new Employee(3, "Michael Bolton"),
                new Employee(4, "Milton Waddams")
        );
    }

    public static void main(String ... args) {
        List<Employee> employees = createEmployees();
        List<String> names = employees.stream().map(Employee::getName).collect(Collectors.toList());

        List<Integer> ids = employees.stream().map(Employee::getId).collect(Collectors.toList());

        int totalLength = employees.stream().map(Employee::getName).mapToInt(String::length).sum();

        // Add employees to a map using id as key
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));

        // Sort employees by id and print them
        System.out.println("Sorted by key:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Reverse sort employees by id and print them
        System.out.println("Reverse sorted by key:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Sort employees by name and print them
        System.out.println("Sorted by name:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparing(Employee::getName)))
                // .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }
}
