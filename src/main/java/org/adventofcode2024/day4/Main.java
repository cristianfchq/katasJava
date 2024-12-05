package org.adventofcode2024.day4;

import static org.adventofcode2024.ListUtils.updateValueAtPosition;
import static org.adventofcode2024.StringUtils.findAllOccurrences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.FileReaderUtils;

public class Main {

  public static void main(String[] args) throws IOException {
    String filePath = "src/main/resources/day4/example.txt";
    FileReaderUtils fileReaderUtils = new FileReaderUtils(filePath);

    List<String> listAllLines = new ArrayList<String>();
    listAllLines = fileReaderUtils.readAllLines();

    int size = listAllLines.get(0).length();
    String search = "XMAS";

    System.out.println("Size: " + size);
    System.out.println("Search: " + search);
    // horizontal
    // [1,1,1,1,1,1]   -> [(0,0),(0,1),(0,2),(0,3),(0,4),(0,5)]
    // [1,1,1,1,1,1]   -> [(1,0),(1,1),(1,2),(1,3),(1,4),(1,5)]
    // [1,1,1,1,1,1]   -> [(2,0),(2,1),(2,2),(2,3),(2,4),(2,5)]
    // [1,1,1,1,1,1]   -> [(3,0),(3,1),(3,2),(3,3),(3,4),(3,5)]
    // [1,1,1,1,1,1]   -> [(4,0),(4,1),(4,2),(4,3),(4,4),(4,5)]
    // [1,1,1,1,1,1]   -> [(5,0),(5,1),(5,2),(5,3),(5,4),(5,5)]

    // horizontal
    // [1,1,1,1,1]   -> [(0,0),(0,1),(0,2),(0,3),(0,4)]
    // [1,1,1,1,1]   -> [(1,0),(1,1),(1,2),(1,3),(1,4)]
    // [1,1,1,1,1]   -> [(2,0),(2,1),(2,2),(2,3),(2,4)]
    // [1,1,1,1,1]   -> [(3,0),(3,1),(3,2),(3,3),(3,4)]
    // [1,1,1,1,1]   -> [(4,0),(4,1),(4,2),(4,3),(4,4)]

    // vertical [horizontal transp]
    // [1,1,1,1,1]   -> [(0,0),(1,0),(2,0),(3,0),(4,0)]
    // [1,1,1,1,1]   -> [(0,1),(1,1),(2,1),(3,1),(4,1)]
    // [1,1,1,1,1]   -> [(0,2),(1,2),(2,2),(3,2),(4,2)]
    // [1,1,1,1,1]   -> [(0,3),(1,3),(2,3),(3,3),(4,3)]
    // [1,1,1,1,1]   -> [(0,4),(1,4),(2,4),(3,4),(4,4)]

    // All Diagonal Secondary
    // [1]           ->                         [(0,0)]
    // [1,1]         ->                   [(1,0),(0,1)]
    // [1,1,1]       ->             [(2,0),(1,1),(0,2)]
    // [1,1,1,1]     ->       [(3,0),(2,1),(1,2),(0,3)]
    // [1,1,1,1,1]   -> [(4,0),(3,1),(2,2),(1,3),(0,4)]
    // [1,1,1,1]     -> [(4,1),(3,2),(2,3),(1,4)]
    // [1,1,1]       -> [(4,2),(3,3),(2,4)]
    // [1,1]         -> [(4,3),(3,4)]
    // [1]           -> [(4,4)]

    // All Diagonals principal
    // [1]           ->                         [(0,4)]
    // [1,1]         ->                   [(0,3),(1,4)]
    // [1,1,1]       ->             [(0,2),(1,3),(2,4)]
    // [1,1,1,1]     ->       [(0,1),(1,2),(2,3),(3,4)]
    // [1,1,1,1,1]   -> [(0,0),(1,1),(2,2),(3,3),(4,4)]
    // [1,1,1,1]     ->       [(1,0),(2,1),(3,2),(4,3)]
    // [1,1,1]       ->             [(2,0),(3,1),(4,2)]
    // [1,1]         ->                   [(3,0),(4,1)]
    // [1]           ->                         [(4,0)]

    PartOne partOne = new PartOne(size, listAllLines);
//
//    partOne.getAllDiagonalsPrincipal().forEach(System.out::println);
//
//    System.out.println("^^^^^^^^^^^^^^^^^^");
//
//    partOne.getAllDiagonalsSecondary().forEach(System.out::println);
//
//    System.out.println("---------------------");
//
//    partOne.getHorizontalList().forEach(System.out::println);
//
//    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
//
//    partOne.getVerticalList().forEach(System.out::println);

    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");

    partOne.getSoupLetters().forEach(System.out::println);

    System.out.println("-----------------------");

    partOne.getZeros().forEach(System.out::println);


    String mainString = "MMMSXXMASMMMMSXXMASMSAXAMASAAAMXMXXMASXAMXSXMAAMMMMMSXXMASM";
    String substring = search;

    List<Integer> positions = findAllOccurrences(mainString, substring);

    System.out.println("Positions of occurrences: " + positions);



    //////////////////////////////////////////////

    // Create a List of Lists
    List<List<Integer>> listOfLists = new ArrayList<>();

    // Initialize the List of Lists with some values
    for (int i = 0; i < 3; i++) {
      List<Integer> innerList = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        innerList.add(i * 3 + j); // Fill with some values
      }
      listOfLists.add(innerList);
    }

    // Print the original List of Lists
    System.out.println("Original List of Lists: " + listOfLists);

    // Change value at position (x, y)
    int x = 1; // Row index
    int y = 2; // Column index
    int newValue = 99; // New value to set

    // Update the value at the specified position
    updateValueAtPosition(listOfLists, x, y, newValue);

    // Print the updated List of Lists
    System.out.println("Updated List of Lists: " + listOfLists);
    System.out.println("prueba");

  }

}
