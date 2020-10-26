package generics.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yongot
 * @created 2020-10-24 : 4:55 PM
 */
public class SortGolfers {
    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Jack", "Nicklaus", 68),
            new Golfer("Tiger", "Woods", 70),
            new Golfer("Tom", "Watson" ,70),
            new Golfer("Ty", "Webb", 68),
            new Golfer("Bubba", "Watson", 70)
    );

    // default sort
    public void defaultSort() {
        golfers.stream().sorted().forEach(System.out::println);
    }

    // sort by score, then by last name
    public void sortByScoreThenLast() {
        System.out.println("sortByScoreThenLast");
        golfers.stream().sorted(Comparator.comparingInt(Golfer::getScore).thenComparing(Golfer::getLast)).forEach(System.out::println);
    }

    // sort by score, then by last name, then by first name
    public void sortByScoreThenLastThenFirst() {
        System.out.println("sortByScoreThenLastThenFirst");
        golfers.stream().sorted(
                Comparator.comparingInt(Golfer::getScore)
                        .thenComparing(Golfer::getLast)
                .thenComparing(Golfer::getFirst)
        ).forEach(System.out::println);
    }


    public static void main(String ... args) {
        new SortGolfers().sortByScoreThenLast();
        new SortGolfers().sortByScoreThenLastThenFirst();
    }
}
