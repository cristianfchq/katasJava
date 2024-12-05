package org.adventofcode2024.day4;

import java.util.ArrayList;
import java.util.List;

public class PartOne {

  int size = 0;
  List<String> input = new ArrayList<String>();
  List<List<String>> allDiagonalsPrincipal = new ArrayList<List<String>>();
  List<List<String>> allDiagonalsSecondary = new ArrayList<List<String>>();
  List<List<String>> horizontalList = new ArrayList<List<String>>();
  List<List<String>> verticalList = new ArrayList<List<String>>();
  List<List<String>> soupLetters = new ArrayList<List<String>>();
  List<List<Integer>> zeros = new ArrayList<List<Integer>>();
  List<List<String>> resultSoupLetters = new ArrayList<List<String>>();

  public PartOne() {
  }

  public PartOne(int size, List<String> input) {
    this.size = size;
    this.input = input;
    generateAllDiagonalsPrincipal();
    generateAllDiagonalsSecondary();
    generateHorizontalAndVerticalList();
    generateZerosArrayTwoDimensional();
    generateSoupLetter();
  }

  /**
   * Generates all diagonals principal that are the following list of list elements values.
   * <p>                        [(0,4)]</p>
   * <p>                  [(0,3),(1,4)]</p>
   * <p>            [(0,2),(1,3),(2,4)]</p>
   * <p>      [(0,1),(1,2),(2,3),(3,4)]</p>
   * <p>[(0,0),(1,1),(2,2),(3,3),(4,4)]</p>
   * <p>      [(1,0),(2,1),(3,2),(4,3)]</p>
   * <p>            [(2,0),(3,1),(4,2)]</p>
   * <p>                  [(3,0),(4,1)]</p>
   * <p>                        [(4,0)]</p>
   */
  public void generateAllDiagonalsPrincipal() {
    // Generate Diagonal.
    List<String> diagonalPrincipal = new ArrayList<String>();
    for (int i = 0; i < size; i++) {
      diagonalPrincipal.add("(" + (i) + "," + (i) + ")");
    }
    allDiagonalsPrincipal.add(diagonalPrincipal);
    // Generate Diagonal superior.
    int auxValue1 = size;
    for (int i = 1; i < size; i++) {
      diagonalPrincipal = new ArrayList<String>();
      ;
      auxValue1 = auxValue1 - 1;
      for (int j = 0; j < auxValue1; j++) {
        diagonalPrincipal.add("(" + (j) + "," + (j + i) + ")");
      }
      allDiagonalsPrincipal.add(diagonalPrincipal);
    }
    // Generate Diagonal inferior.
    auxValue1 = size;
    for (int i = 1; i < size; i++) {
      diagonalPrincipal = new ArrayList<String>();
      ;
      auxValue1 = auxValue1 - 1;
      for (int j = 0; j < auxValue1; j++) {
        diagonalPrincipal.add("(" + (j + i) + "," + (j) + ")");
      }
      allDiagonalsPrincipal.add(diagonalPrincipal);
    }
  }

  /**
   * Generates all diagonal secondary that are the following list of list elements values
   * <p>                        [(0,0)]</p>
   * <p>                  [(1,0),(0,1)]</p>
   * <p>            [(2,0),(1,1),(0,2)]</p>
   * <p>      [(3,0),(2,1),(1,2),(0,3)]</p>
   * <p>[(4,0),(3,1),(2,2),(1,3),(0,4)]</p>
   * <p>[(4,1),(3,2),(2,3),(1,4)]      </p>
   * <p>[(4,2),(3,3),(2,4)]            </p>
   * <p>[(4,3),(3,4)]                  </p>
   * <p>[(4,4)]                        </p>
   */
  public void generateAllDiagonalsSecondary() {
    // Generate Diagonal.
    List<String> diagonalSecondary = new ArrayList<String>();
    for (int i = 0; i < size; i++) {
      diagonalSecondary.add("(" + (size - i - 1) + "," + (i) + ")");
    }
    allDiagonalsSecondary.add(diagonalSecondary);

    // Generate Diagonal superior.
    int auxValue1 = size;
    for (int i = 1; i < size; i++) {
      diagonalSecondary = new ArrayList<String>();
      ;
      auxValue1 = auxValue1 - 1;
      for (int j = 0; j < auxValue1; j++) {
        diagonalSecondary.add("(" + (size - (i + j) - 1) + "," + (j) + ")");
      }
      allDiagonalsSecondary.add(diagonalSecondary);
    }

    // Generate Diagonal inferior.
    auxValue1 = size;
    for (int i = 1; i < size; i++) {
      diagonalSecondary = new ArrayList<String>();
      ;
      int aux = size;
      auxValue1 = auxValue1 - 1;
      for (int j = 0; j < auxValue1; j++) {
        diagonalSecondary.add("(" + (aux - 1 - j) + "," + (j + i) + ")");
      }
      allDiagonalsSecondary.add(diagonalSecondary);
    }
  }

  /**
   * Generates horizontal list that are the following list of list elements values
   *
   * <p>Horizontal lines.</p>
   * <p>[(0,0),(0,1),(0,2),(0,3),(0,4)]</p>
   * <p>[(1,0),(1,1),(1,2),(1,3),(1,4)]</p>
   * <p>[(2,0),(2,1),(2,2),(2,3),(2,4)]</p>
   * <p>[(3,0),(3,1),(3,2),(3,3),(3,4)]</p>
   * <p>[(4,0),(4,1),(4,2),(4,3),(4,4)]</p>
   *
   * <p>Vertical lines.</p>
   * <p>[(0,0),(1,0),(2,0),(3,0),(4,0)]</p>
   * <p>[(0,1),(1,1),(2,1),(3,1),(4,1)]</p>
   * <p>[(0,2),(1,2),(2,2),(3,2),(4,2)]</p>
   * <p>[(0,3),(1,3),(2,3),(3,3),(4,3)]</p>
   * <p>[(0,4),(1,4),(2,4),(3,4),(4,4)]</p>
   */
  public void generateHorizontalAndVerticalList() {
    for (int i = 0; i < size; i++) {
      List<String> horizontalRow = new ArrayList<String>();
      List<String> verticalRow = new ArrayList<String>();
      for (int j = 0; j < size; j++) {
        horizontalRow.add("(" + i + "," + j + ")");
        verticalRow.add("(" + j + "," + i + ")");
      }
      horizontalList.add(horizontalRow);
      verticalList.add(verticalRow);
    }
  }

  public void generateZerosArrayTwoDimensional() {
    for (int i = 0; i < size; i++) {
      List<Integer> horizontalRow = new ArrayList<Integer>();
      for (int j = 0; j < size; j++) {
        horizontalRow.add(0);
      }
      zeros.add(horizontalRow);
    }
  }

  public void generateSoupLetter() {
    for (int i = 0; i < size; i++) {
      List<String> row = new ArrayList<String>();
      String[] letters = input.get(i).split("");
      for (int j = 0; j < size; j++) {
        row.add(letters[j]);
      }
      soupLetters.add(row);
    }
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<List<String>> getAllDiagonalsPrincipal() {
    return allDiagonalsPrincipal;
  }

  public void setAllDiagonalsPrincipal(
      List<List<String>> allDiagonalsPrincipal) {
    this.allDiagonalsPrincipal = allDiagonalsPrincipal;
  }

  public List<List<String>> getAllDiagonalsSecondary() {
    return allDiagonalsSecondary;
  }

  public void setAllDiagonalsSecondary(
      List<List<String>> allDiagonalsSecondary) {
    this.allDiagonalsSecondary = allDiagonalsSecondary;
  }

  public List<List<String>> getHorizontalList() {
    return horizontalList;
  }

  public void setHorizontalList(List<List<String>> horizontalList) {
    this.horizontalList = horizontalList;
  }

  public List<List<String>> getVerticalList() {
    return verticalList;
  }

  public void setVerticalList(List<List<String>> verticalList) {
    this.verticalList = verticalList;
  }

  public List<String> getInput() {
    return input;
  }

  public void setInput(List<String> input) {
    this.input = input;
  }

  public List<List<String>> getSoupLetters() {
    return soupLetters;
  }

  public void setSoupLetters(List<List<String>> soupLetters) {
    this.soupLetters = soupLetters;
  }

  public List<List<Integer>> getZeros() {
    return zeros;
  }

  public void setZeros(List<List<Integer>> zeros) {
    this.zeros = zeros;
  }

  public List<List<String>> getResultSoupLetters() {
    return resultSoupLetters;
  }

  public void setResultSoupLetters(List<List<String>> resultSoupLetters) {
    this.resultSoupLetters = resultSoupLetters;
  }
}
