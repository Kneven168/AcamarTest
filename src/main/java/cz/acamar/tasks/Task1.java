package cz.acamar.tasks;

import java.util.Optional;
import java.util.stream.Stream;

public class Task1 {

    /**
     * Task 1. Length of the last word.
     * <p>
     * Given a string s consisting of some words separated by some number of spaces,
     * return the length of the last word in the string.
     * <p>
     * A word is a maximal substring consisting of non-space characters only.
     * <p>
     * Example input: "Hello World"
     * Expected output: 5
     *
     * @param str - a string s consisting of some words separated by some number of spaces.
     * @return - the length of the last word in the string.
     */

    private final String regexForPunctuationMarks = "\\p{P}";

    public int lengthOfLastWord(String str) {
        return Optional.ofNullable(str).map(s -> str.replaceAll(regexForPunctuationMarks, ""))
            .map(s -> s.split(" "))
            .map(array -> array[array.length-1])
            .map(String::length)
            .orElseThrow(IllegalArgumentException::new);
    }
}
