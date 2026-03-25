/*

Q15. Join Strings with Conditions
Given a List<String>, join only strings starting with "A" into a single string separated by commas.

 */

import  java.util.*;
import  java.util.stream.*;


public class Q15 {
    public static void main(String[] args){
        String sent = "hey Adesh , amid covid 19 , what is the situation at your place";

        String joined = Arrays.stream(sent.split("\\W+"))
                .filter(s -> s.toLowerCase().charAt(0)=='a' )
                .collect(Collectors.joining(","));

        System.out.println(joined);
    }
}