/*

Reduce, Optional & Custom Logic

Q16. Custom Reduce
Use reduce() to find the product of all numbers in a list.

 */

import java.util.*;
import java.util.stream.*;

public class Q16 {
    public static void main(String[] args){
        List<Integer> ls = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // can use this because seed value not provided .:. optional returned
        ls.stream().reduce( (a,b) -> a*b).ifPresent(System.out::println);


        System.out.println(ls.stream().reduce( 1, (a,b) -> a*b));



    }
}