/*
Q1. Given a List<String>, return a list of strings that: have length > 5
are converted to uppercase
sorted alphabetically
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Q1 {
    public static void main(String[] args){
        List<String> ls = new ArrayList<>(Arrays.asList("adesh" , "java", "python", "programming"));
        ls.stream().filter(s->s.length()> 5).map(String::toUpperCase).sorted().forEach(System.out::println);
        System.out.println(ls);
    }
}