package org.adventofcode2024.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.FileReaderUtils;
import org.adventofcode2024.ListUtils;

public class Main {

  public static void main(String[] args) throws IOException {
    String filePath = "src/main/resources/day2/input.txt";
    FileReaderUtils fileReaderUtils = new FileReaderUtils(filePath);
    List<String> allLines = fileReaderUtils.readAllLines();
//    allLines.forEach(System.out::println);

    System.out.println("\n################################");
    System.out.println("First Part of Problem");
    System.out.println("################################");

    PartOne partOne = new PartOne();

    partOne.calculateSafeAndUnsafeList(allLines);

    System.out.println("safe : " + partOne.getTotalReportsSafe());
    System.out.println("safe : " + partOne.getSafeList().size());

//    partOne.getSafeList().forEach(System.out::println);

    System.out.println("unsafe : " + partOne.getTotalReportsUnsafe());
    System.out.println("unsafe : " + partOne.getUnsafeList().size());

//    partOne.getUnsafeList().forEach(System.out::println);


    System.out.println("\n################################");
    System.out.println("Second Part of Problem");
    System.out.println("################################");

    PartTwo partTwo = new PartTwo();

    partTwo.setUnsafeList(partOne.getUnsafeList());

    partTwo.calculateSafeAndUnsafeList();

    System.out.println("total safe with update : " + (partTwo.getTotalReportsSafe() + partOne.getTotalReportsSafe()));
  }

}
