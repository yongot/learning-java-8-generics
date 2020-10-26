package generics.raw;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongot
 * @created 2020-10-24 : 11:36 AM
 */
public class Typed {
    public static void main (String ... args) {
        List<String> strings = new ArrayList<>();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");

        // compilation error
//        strings.add(LocalDate.now());

        for (String s : strings) {
            System.out.printf("%7s has %d characters%n", s, s.length());
        }

        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(new Integer(4));
        int x = ints.get(0);
        int y = ints.get(1);
    }


}
