/*

Q10. Flatten a Nested List
Given a List<List<Integer>>, flatten it into a single list and remove duplicates.

 */


import java.util.ArrayList;
import java.util.List;

public class Q10 {
    public static void main(String[] args){
        List<List<Integer>> ls = new ArrayList<>(
                List.of(
                        List.of(1,2,4,5,6),
                        List.of(3, 33, 44)
                )
        );

        List<Integer> flat = ls.stream().flatMap(List::stream).toList();

        flat.forEach(System.out::println);




    }
}