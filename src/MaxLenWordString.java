import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class MaxLenWordString {
    public static void main(String[] args) {
//        String sentence = "hey, my name is Adesh!";
        String sentence = "";
        String maxLen = Arrays.stream(sentence.split("\\W+")).sorted(Comparator.comparingInt(String::length).reversed()).findFirst().orElse("EMPTY");
        System.out.println(maxLen);
    }
}