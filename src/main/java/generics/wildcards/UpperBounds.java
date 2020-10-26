package generics.wildcards;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author yongot
 * @created 2020-10-24 : 12:04 PM
 */
public class UpperBounds {
    public static double sumList(List<? extends Number> numbers) {
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
        List<? extends Number> numbers = new ArrayList<>();
//        numbers.add(3);
//        numbers.add(3.14159);
//        numbers.add(new BigDecimal("3"));

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Int List: " + sumList(ints));

        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println("Double List: " + sumList(doubles));

        List<Double> double1 = DoubleStream.iterate(1.0, d -> d + 1.0)
                .limit(5)
                .mapToObj(Double::new)
                .collect(Collectors.toList());
        System.out.println("Double1 List: " + sumList(double1));

        List<BigDecimal> bigDecimals = IntStream.rangeClosed(1, 5).mapToObj(BigDecimal::new).collect(Collectors.toList());
        System.out.println("bigDecimals List: " + sumList(bigDecimals));

    }
}
