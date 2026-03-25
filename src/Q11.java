/*

🔹 Advanced Stream Pipelines

Q11. Second Highest Number
Given a List<Integer>, find the second highest distinct number using streams.

 */

import java.util.*;
import java.util.stream.*;

public class Q11 {
    public static void main(String[] args){
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5)); // this is mutable
        List<Integer> ls = Arrays.asList(1,2,3,4,4,5,1); // this is immutable

        // .sorted() for ascending
        Integer secondHigh = ls.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHigh);

    }
}