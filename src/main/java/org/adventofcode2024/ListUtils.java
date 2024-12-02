package org.adventofcode2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

  /**
   * Gets list sorted as ascending.
   * @param numbers the list of numbers.
   * @return the list sorted as ascending.
   */
  public static List<Integer> getListSortedAscending(List<Integer> numbers) {
    List<Integer> sortedList = new ArrayList<>(numbers); // Copy the original list
    Collections.sort(sortedList); // Sort in ascending order
    return sortedList;
  }

  /**
   * Gets list sorted as descending.
   * @param numbers the list of numbers.
   * @return the list sorted as descending.
   */
  public static List<Integer> getListSortedDescending(List<Integer> numbers) {
    List<Integer> sortedList = new ArrayList<>(numbers); // Copy the original list
    Collections.sort(sortedList, Collections.reverseOrder()); // Sort in descending order
    return sortedList;
  }

  /**
   * Gets the number of occurrences of a specific element.
   * @param numbers the list of elements.
   * @param element the element to search.
   * @return the number of occurrences.
   */
  public static int countOccurrences(List<Integer> numbers, int element) {
    int count = 0;
    for (Integer number : numbers) {
      if (number == element) {
        count++;
      }
    }
    return count;
  }
}
