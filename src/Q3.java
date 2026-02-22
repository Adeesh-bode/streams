/*
Q3. Remove Duplicates Case-Insensitive
Given a List<String>, remove duplicates ignoring case while preserving insertion order.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args){

        // m1 - used map, duplicate handled by merge ftn & LinkedHashMap madesure insertion order
        List<String> ls1 = new ArrayList<>(Arrays.asList("adesh", "java","Adesh", "python", "programming"));
        ls1 = ls1.stream().collect(Collectors.toMap(
                        String::toLowerCase, // key (case-insensitive)
                        s-> s,          // value (original string)
                        (first, ignored ) -> first , // Merge function - if duplicates found
                        LinkedHashMap::new // Map supplier -- Uses LinkedHashMap instead of HashMap for insertion order prevention in this case
                ))
                .values()
                .stream()
                .toList();

        ls1.stream().forEach(System.out::println);


        // m2 - using set nature :: s.lowercase making sure insentivity ignored && duplicatn check done by set returned boolean
        List<String> ls2 = new ArrayList<>(Arrays.asList("adesh", "java","Adesh", "python", "programming"));
        Set<String> checkSet = new HashSet<>();
        ls2 = ls2.stream().filter(s-> checkSet.add(s.toLowerCase())).toList();

        ls2.stream().forEach(System.out::println);
    }
}