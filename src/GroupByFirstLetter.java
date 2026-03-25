
// ["java","python","programming","automation"]
// {P=[PYTHON, PROGRAMMING], A=[AUTOMATION]}

// after above task variatn inside that values alpha sorting
import java.util.*;
import java.util.stream.*;
public class GroupByFirstLetter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","python","programming","automation");

        Map<Character, List<String>> mp = list.stream()
                .map(String::toUpperCase)
                .collect(
                        Collectors.groupingBy(
                                s -> s.charAt(0),
// if not doing implicit storing to list logic - but by default grouping goes to list so uncessary
//                                Collectors.mapping(s-> s, toList())

                            Collectors.collectingAndThen(
                                    toList(),
                                    Collections::sort()
                            )
                        )
                );

        for(Map.Entry<Character, List<String>> Entry : mp.entrySet()){
            System.out.println(Entry.getKey() + "=" + Entry.getValue());
        }
    }
}