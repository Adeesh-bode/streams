/*
Q2. Count Frequency
Given a List<String>, create a Map<String, Long> where each string is mapped to its occurrence count.

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Q2 {
  public static void main(String[] args){
    List<String> ls = new ArrayList<>(Arrays.asList("adesh" , "java", "python", "adesh", "programming"));

    /*
      Using Collector.groupingBy
     */
    Map<String, Long> freq1 = ls.stream().collect(Collectors.groupingBy(s->s , Collectors.counting()));
    /* Using Collectors.ToMap

    s -> 1L → initial count ( L just mean long data type )
    Long::sum → merge duplicates
     -- it means Long class has a sum class use that in merger ftn ( used when duplicates occur )
     */

    Map<String, Long> freq2 = ls.stream().collect(Collectors.toMap(s->s //inplace of this s->s: Function.identity(),
            , s-> 1L,
            Long::sum
    ));


    BiConsumer<String,Long> printMap = (k, v) -> System.out.println(k + " " + v);
    // deconstruct method used for accessing key/value simult of map -- other alternative EntrySet()

    freq1.forEach(printMap);
    freq2.forEach(printMap);


    /* Just to explore grouping by without any downstream

     */

    List<String> ls2 = new ArrayList<>(Arrays.asList("adesh" , "java", "python", "adesh", "programming"));
    Map<String,Integer> mp = ls2.stream().collect(Collectors.groupingBy(s->s));

  }
}