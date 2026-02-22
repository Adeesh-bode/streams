/*

Q4. First Non-Repeating Element,
Given a List<Integer>, find the first element that occurs only once

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {
    public static void main(String[] args){
        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,4,5,2,4));
        ls = ls.stream().collect(Collectors.toMap(
                n -> n,
                n->n,
                (first, ignored) -> first
        )).values().stream().toList();

        ls.forEach(System.out::println);




    }
}