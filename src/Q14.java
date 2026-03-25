/*

Q14. Character Frequency in a String
Given a string, return a Map<Character, Long> showing character frequency.

 */

import  java.util.*;
import  java.util.stream.*;


public class Q14 {
    public static void main(String[] args){
        String s = "happy";

        Map<Character, Long> mp = s.chars()
                .mapToObj(c -> (char) c)
                .collect(
                Collectors.groupingBy(
                        c -> c,
//                        TreeMap::new,
                        Collectors.counting()
                )
        );

        for(Map.Entry<Character,Long> entry : mp.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}