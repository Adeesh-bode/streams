/*

Q7. Partition Numbers
Given a List<Integer>, partition them into even and odd using streams.

 */


import java.util.*;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args){
        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,4,5,6 ,7, 8,9,10));
        Map<Boolean, List<Integer>> mp = ls.stream().collect(Collectors.partitioningBy(x -> x %2 == 0));

        List<Integer> even = mp.get(true);
        List<Integer> odd = mp.get(false);

        even.stream().forEach(System.out::println);

        odd.stream().forEach(System.out::println);

    }
}