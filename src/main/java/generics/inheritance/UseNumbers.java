package generics.inheritance;

import java.util.Arrays;
import java.util.List;

/**
 * @author yongot
 * @created 2020-10-24 : 11:49 AM
 */
public class UseNumbers {

    public static double sumList(List<Number> numbers) {
        // Java 7
//        double total = 0;
//        for (Number n : numbers) {
//            total += n.doubleValue();
//        }
//
//        return total;

        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
    public static void main(String ... args) {
        List<Number> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        System.out.println("Number List: " + sumList(numbers));

        List<Integer> ints = Arrays.asList(3, 1, 4, 1, 5, 9);
//        System.out.println("Int List: " + sumList(ints));
    }
}
