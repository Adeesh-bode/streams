/*

Q17. Find Any vs Find First
Given a list of numbers, find any number divisible by 5 using streams and explain how behavior changes in parallel streams.

 */
import java.util.*;
import java.util.stream.*;


public class Q17 {
    public static void main(String[] args){
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 25,20, 21,45, 61, 75, 25);

        System.out.println(ls.size());
        Integer r1 = ls.stream().filter(n-> n%5==0).findFirst().orElse(0);
        Integer r2 = ls.parallelStream().filter(n-> n%5==0).findAny().orElse(0);

        System.out.println( r1 +"\n" + r2);


    }
}