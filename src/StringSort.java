/*

Transform
["java","python","programming","automation","python"]
into
[PROGRAMMING, AUTOMATION, PYTHON]
Rules
Remove duplicates
Length > 5
Uppercase
Sort by length descending
If same length → alphabetical

 */


import java.util.*;
import java.util.stream.*;

public class StringSort{
    public static void main(String[] args){
        List<String> list = Arrays.asList("java","python","programming","automation","python");

        list.stream().distinct().filter(s->s.length() > 5).map(String::toUpperCase)
                .sorted(
                        Comparator.comparingInt(String::length).reversed()
                                .thenComparing(Comparator.naturalOrder())
                ).forEach(System.out::println);
    }
}