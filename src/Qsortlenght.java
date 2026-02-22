/*



 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Qsortlenght {
    public static void main(String[] args){
        List<String> ls1 = new ArrayList<>(Arrays.asList("adesh", "java","Adesh", "python", "programming"));
        ls1 = ls1.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        System.out.println(ls1);
    }
}