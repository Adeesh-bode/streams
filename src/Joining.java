/*

Transform
["java","python","programming","automation","code"]
into
AUTOMATION-PROGRAMMING-PYTHON
Rules
Length > 5
Uppercase
Sort alphabetically
Join with -
 */

import java.util.*;
import java.util.stream.*;

public class Joining  {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("java","python","programming","automation","python");

        String joined = ls.stream().distinct().filter(s -> s.length() >5).map(String::toUpperCase).sorted()
                .collect(Collectors.joining("-"));

        System.out.println(joined);

    }
}