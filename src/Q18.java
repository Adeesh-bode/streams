/*

Q18. Optional Handling
Given a List<Integer>, find the maximum value and return 0 if the list is empty.

 */

import java.util.*;
import java.util.stream.*;


public class Q18 {
    public static void main(String[] args){
        List<Integer> ls = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> max = ls.stream().max(Comparator.naturalOrder());

//        max.ifPresent(System.out::println);
        System.out.println(max.orElse(0));

    }
}