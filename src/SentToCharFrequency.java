import java.util.*;
import java.util.stream.*;
import java.util.function.Function;


public class SentToCharFrequency {
    public static void main(String[] args) {
        String sentence = "hey, my name is Adesh!";

        Arrays.stream(sentence.split("\\W+")).flatMap(s -> Arrays.stream(s.split(""))).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        ).forEach((k,v)->{
            System.out.println(k + ": " + v);
        });


        // Using chars() avoids regex overhead and gives a more efficient and readable solution compared to splitting twice.”
        System.out.println("---------------------------------");

        sentence.chars().mapToObj(c->(char) c).filter(Character::isLetter) // ignores  // ignore punctuation & spaces
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}