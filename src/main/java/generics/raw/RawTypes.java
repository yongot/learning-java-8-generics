package generics.raw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yongot
 * @created 2020-10-24 : 11:33 AM
 */
public class RawTypes {
    public static void main (String ... args) {
        List strings = new ArrayList();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");
        strings.add(LocalDate.now());

        for (Object o : strings) {
            String s = (String) o;
            System.out.printf("%7s has %d characters%n", s, s.length());
        }
    }
}
