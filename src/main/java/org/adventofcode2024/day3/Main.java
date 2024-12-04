package org.adventofcode2024.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.FileReaderUtils;


public class Main {

  public static void main(String[] args) throws IOException {

    String filePath = "src/main/resources/day3/input.txt";
    FileReaderUtils fileReaderUtils = new FileReaderUtils(filePath);
    String allLinesAsString = fileReaderUtils.readFileAsString();

    System.out.println(allLinesAsString);

    System.out.println("\n################################");
    System.out.println("First Part of Problem");
    System.out.println("################################");

    PartOne partOne = new PartOne();
    partOne.findAllInstructions(allLinesAsString);
    System.out.println("Instructions : " + partOne.getInstructions());
    partOne.calculateAddingProductInstruction();
    System.out.println(
        "Result adding each product instruction : " + partOne.getResultAddingProductInstruction());

    System.out.println("\n################################");
    System.out.println("Second Part of Problem");
    System.out.println("################################");

    List<String> listAllLines = new ArrayList<String>();
    listAllLines = fileReaderUtils.readAllLines();

//    System.out.println("All list lines : " + listAllLines);

//    listAllLines.forEach(System.out::println);

    allLinesAsString = "";
    for (int i = 0; i < listAllLines.size(); i++) {
      allLinesAsString = allLinesAsString + listAllLines.get(i);
    }

    System.out.println("++++===>\n" + allLinesAsString);

    String allLinesAsStringToWork = "do()" + allLinesAsString + "don't()";

    System.out.println("===>\n" + allLinesAsStringToWork);

    PartTwo partTwo = new PartTwo();

    partTwo.findAllToDo(allLinesAsStringToWork);
//    System.out.println("All ToDo's : " + partTwo.getListToDo());
//    System.out.println(partTwo.getListToDo().size());

    partTwo.calculateAddingProductInstructionForToDo();

    System.out.println("Result adding each product instruction : " + partTwo.getResultAddingProductInstructionForToDo());
  }
}
