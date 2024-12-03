package org.adventofcode2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

  /**
   * Gets list sorted as ascending.
   *
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
   *
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
   *
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

  /**
   * Validates if the list is ordered in ascending order.
   *
   * @param numbers the list to validate.
   * @return true if the list is ordered in ascending order, false otherwise.
   */
  private static boolean isOrderedAscending(List<Integer> numbers) {
    for (int i = 1; i < numbers.size(); i++) {
      if (numbers.get(i) < numbers.get(i - 1)) {
        return false; // Found an element that is less than the previous one
      }
    }
    return true; // The list is ordered in ascending order
  }

  /**
   * Validates if the list is ordered in descending order.
   *
   * @param numbers the list to validate.
   * @return true if the list is ordered in descending order, false otherwise.
   */
  private static boolean isOrderedDescending(List<Integer> numbers) {
    for (int i = 1; i < numbers.size(); i++) {
      if (numbers.get(i) > numbers.get(i - 1)) {
        return false; // Found an element that is greater than the previous one
      }
    }
    return true; // The list is ordered in descending order
  }

  /**
   * Validates if the list is ordered (ascending or descending).
   *
   * @param numbers the list to validate.
   * @return true if the list is ordered in descending or ascending order, false otherwise.
   */
  public static boolean isOrdered(List<Integer> numbers) {
    return isOrderedAscending(numbers) || isOrderedDescending(numbers);
  }

  /**
   * Removes a specific index from the list
   *
   * @param numbers the list to remove element.
   * @param index   the index of element to remove.
   */
  public static List<Integer> removeAtIndex(List<Integer> numbers, int index) {
    if (index < 0 || index >= numbers.size()) {
      System.out.println("Index out of bounds: " + index); // Handle invalid index
      return new ArrayList<>(numbers); // Return a copy of the original list
    }
    List<Integer> newList = new ArrayList<>(numbers); // Create a copy of the original list
    newList.remove(index); // Remove the element at the specified index
    return newList; // Return the new list
  }
}
