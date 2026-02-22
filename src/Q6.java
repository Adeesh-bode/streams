/*

Intermediate & Grouping Logic

Q6. Group by String Length
Given a List<String>, group strings by their length into a
Map<Integer, List<String>>.

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q6 {
    public static void main(String[] args){
        List<String> ls1 = new ArrayList<>(Arrays.asList("adesh", "java","Adesh", "python", "programming"));

        Map<Integer,List<String>>  mp = ls1.stream().collect(Collectors.groupingBy(String::length));

        mp.forEach((k,v)-> System.out.println(k+": " + v));


    }
}