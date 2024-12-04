package org.adventofcode2024;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

  /**
   * Replaces all occurrences of targetWord with replacementWord.
   *
   * <p>Examle: </p>
   * <p> input = "The quick brown fox jumps over the lazy dog." </p>
   * <p> targetWord = "fox" </p>
   * <p> replacementWod = "cat" </p>
   * <p> return = "The quick brown cat jumps over the lazy dog" </p>
   *
   * @param input           the input string.
   * @param targetWord      the target word.
   * @param replacementWord the replacement word.
   * @return the string with the new replacement word replaced.
   */
  public static String replaceWords(String input, String targetWord, String replacementWord) {
    if (input == null) {
      return null;
    }
    if (targetWord == null || targetWord.isEmpty()) {
      return input;
    }
    String regex = "\\b" + Pattern.quote(targetWord) + "\\b";
    return input.replaceAll(regex, replacementWord);
  }

  /**
   * Gets all strings between every occurrence of "do()" and "don't()"
   *
   * <p> Example: </p>
   * <p> input = "I do() love programming but I don't() like bugs. I do() enjoy coding, don't()
   * you?" </p>
   * <p> return = ["love programming but I", "enjoy coding,"] </p>
   *
   * @param input the input string.
   * @return all list of strings between each occurrence of "do()" and "don't()".
   */
  public static List<String> getAllStringsBetweenDoAndDont(String input) {
    List<String> allStrings = new ArrayList<>();
    // Check if the input string is null or empty
    if (input == null || input.isEmpty()) {
      return allStrings;
    }
    int startIndex = 0;
    // Loop to find all occurrences of "do()" and "don't()"
    while (true) {
      startIndex = input.indexOf("do()", startIndex);
      int endIndex = input.indexOf("don't()", startIndex);
      if (startIndex != -1 && endIndex != -1) {
        String substring = input.substring(startIndex + 4, endIndex).trim();
        allStrings.add(substring);
        startIndex = endIndex + 7;
      } else {
        break;
      }
    }
    return allStrings;
  }
}
