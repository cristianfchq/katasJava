package org.adventofcode2024.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.FileReaderUtils;
import org.adventofcode2024.ListUtils;

public class Main {

  public static void main(String[] args) throws IOException {
    String filePath = "src/main/resources/day1/input.txt";
    FileReaderUtils fileReaderUtils = new FileReaderUtils(filePath);
    List<String> allLines = fileReaderUtils.readAllLines();

//    allLines.forEach(System.out::println);
    List<Integer> firstList = new ArrayList<>();
    List<Integer> secondList = new ArrayList<>();
    for (int i = 0; i < allLines.size(); i++) {
      String[] line = allLines.get(i).split(" ");
      firstList.add(Integer.parseInt(line[0]));
      secondList.add(Integer.parseInt(line[3]));
    }

    System.out.println("\n################################");
    System.out.println("First Part of Problem");
    System.out.println("################################");
    List<Integer> firstListSorted = ListUtils.getListSortedAscending(firstList);
    List<Integer> secondListSorted = ListUtils.getListSortedAscending(secondList);
    System.out.println("firstList: " + firstListSorted);
    System.out.println("secondList: " + secondListSorted);
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < firstListSorted.size(); i++) {
      int number = 0;
      number = firstListSorted.get(i) - secondListSorted.get(i);
      resultList.add(Math.abs(number));
    }
    System.out.println("resultList: " + resultList);
    int result = 0;
    for (int i = 0; i < resultList.size(); i++) {
      result = result + resultList.get(i);
    }
    System.out.println("result: " + result);

    System.out.println("\n################################");
    System.out.println("Second Part of Problem");
    System.out.println("################################");

    List<Integer> listResult = new ArrayList<>();

    for (int i = 0; i < firstList.size(); i++) {
//      Integer count = 0;
//      for (int j = 0; j < secondList.size(); j++) {
//        if (firstList.get(i).intValue() == secondList.get(j).intValue()) {
//          count++;
//        }
//      }
      Integer count = ListUtils.countOccurrences(secondList, firstList.get(i));
      listResult.add(firstList.get(i) * count);
    }
    System.out.println("listResult: " + listResult);
    Integer longResult = 0;
    for (int i = 0; i < listResult.size(); i++) {
      longResult = longResult + listResult.get(i);
    }
    System.out.println("result: " + longResult);
  }
}
