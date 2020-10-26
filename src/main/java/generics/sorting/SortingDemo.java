package generics.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongot
 * @created 2020-10-24 : 4:46 PM
 */
public class SortingDemo {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    // default sort from Java 7
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // default sort from Java 8+
    public List<String> alphaSortUsingStreams() {
        return sampleStrings.stream().sorted().collect(Collectors.toList());
    }

    // Java 7 - using Comparator with anonymous inner class
    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return sampleStrings;
    }

    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings, (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
    }

    // Sort by length then reverse alpha using sorted
    public List<String> lengthSortThenReverseAlphaUsingSorted() {
        return sampleStrings.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder())).collect(Collectors.toList());
    }
}
