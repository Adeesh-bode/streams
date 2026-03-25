/*

Q13. Find Longest Word in a Sentence
Given a sentence string, find the longest word using streams.

 */

import java.util.*;
import java.util.stream.*;


public class Q13 {
    public static void main(String[] args){

        String sent = "Hey, How are you?";

        // .split return a Array have to convert to stream
        String word = Arrays.stream(sent.split("\\W+")).sorted(Comparator.comparing(String::length).reversed()).findFirst().orElse("");

        System.out.println(word);

        // m2 - using max

        Optional<String> longestWord = Arrays.stream(sentence.split("\\W+"))
                .max(Comparator.comparingInt(String::length));

        longestWord.ifPresent( word ->
                System.out.println("Longest word: " + word)
        );

    }
}