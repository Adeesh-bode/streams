/*
Q1. Given a List<String>, return a list of strings that: have length > 5
are converted to uppercase
sorted alphabetically

Q1- variatn
Given a List<String>:
Ignore null, blank values
Remove duplicates case-insensitively
Keep only words length > 5
Convert to uppercase
Sort by
length descending
then alphabetically
Return result as LinkedHashSet

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Q1 {
    public static void main(String[] args){

        // this creates a mutable variable size list -- but 2 times obj creatn
        List<String> ls = new ArrayList<>(Arrays.asList("adesh" , "java", "python", "programming"));
        ls.stream().filter(s->s.length()> 5).map(String::toUpperCase).sorted().forEach(System.out::println);
        System.out.println(ls);

        // immutable arraylist
        List<String> ls = Arrays.asList("adesh" , "java", "python", "programming");

        LinkedHashSet<String> linkedHashSet = ls.stream()
                .filter(Objects::nonNull)
                .filter( s -> !s.isBlank())
                .map(String::toUppercase)
                .distinct()
                .filter(s -> s.length > 5)
                .sort(comparator.compare(String::length).thenComparing(

                ))


                .





    }
}