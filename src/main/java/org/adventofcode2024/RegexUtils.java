package org.adventofcode2024;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

  /**
   * Finds all occurrences according to the given pattern [regex] into an input string.
   *
   * @param input the input string.
   * @param regex the pattern.
   * @return the list of occurrences.
   */
  public static List<String> findPatterns(String input, String regex) {
    List<String> results = new ArrayList<>();
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
//      System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//      System.out.println(matcher.group());
      results.add(matcher.group());
    }
    return results;
  }

  // Method to get the string between the first pair of parentheses using regex
  public static String getStringBetweenParentheses(String input) {
    // Check if the input string is null or empty
    if (input == null || input.isEmpty()) {
      return "Input string is empty or null.";
    }

    // Define the regex pattern to match text between parentheses
    String regex = "\\(([^)]+)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    // Check if the pattern matches
    if (matcher.find()) {
      // Return the first group (text between parentheses)
      return matcher.group(1);
    } else {
      return "No parentheses found in the input string.";
    }
  }
}
