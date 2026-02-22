/*

Q5. Sum of Squares of Even Numbers
Given a List<Integer>, compute the sum of squares of all even numbers
using streams.

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5 {
    public static void main(String[] args){
        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        // reduce chain used
        Integer sum = ls.stream().filter(x -> x % 2 == 0).map(n-> n*n).reduce(0, (a , b) -> a + b );
        System.out.println(sum);

        // map + sum
        Integer sum2 = ls.stream().filter(x -> x % 2 == 0).map(n-> n*n).mapToInt(Integer::intValue).sum();
        System.out.println(sum2);

    }
}