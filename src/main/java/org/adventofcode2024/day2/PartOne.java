package org.adventofcode2024.day2;

import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.ListUtils;

public class PartOne {

  public PartOne() {
  }

  int totalReportsSafe = 0;
  int totalReportsUnsafe = 0;
  List<List<Integer>> safeList = new ArrayList<List<Integer>>();
  List<List<Integer>> unsafeList = new ArrayList<List<Integer>>();

  public void calculateSafeAndUnsafeList(List<String> allLines) {
    for (int i = 0; i < allLines.size(); i++) {
      String[] line = allLines.get(i).split(" ");
      int size = line.length;
      List<Integer> lineList = new ArrayList<>();
      for (int j = 0; j < size; j++) {
        lineList.add(Integer.parseInt(line[j]));
      }
      if (ListUtils.isOrdered(lineList)) {
        if (isSafe(lineList)) {
          totalReportsSafe++;
          safeList.add(lineList);
        } else {
          totalReportsUnsafe++;
          unsafeList.add(lineList);
        }
      } else {
        totalReportsUnsafe++;
        unsafeList.add(lineList);
      }
    }
//    System.out.println("safe: " + totalReportsSafe);
//    System.out.println("unsafe: " + totalReportsUnsafe);
//    System.out.println("+++++++++++++++++++++++++++++++++");
//    System.out.println("safe: " + safeList.size());
//    System.out.println("unsafe: " + unsafeList.size());
  }

  public boolean isSafe(List<Integer> lineList) {
    int count = 0;
    for (int j = 1; j < lineList.size(); j++) {
      int diff = lineList.get(j) - lineList.get(j - 1);
      if (Math.abs(diff) < 4 && Math.abs(diff) > 0) {
        count++;
      }
    }
    if (count == lineList.size() - 1) {
      return true;
    } else {
      return false;
    }
  }

  public int getTotalReportsSafe() {
    return totalReportsSafe;
  }

  public void setTotalReportsSafe(int totalReportsSafe) {
    this.totalReportsSafe = totalReportsSafe;
  }

  public int getTotalReportsUnsafe() {
    return totalReportsUnsafe;
  }

  public void setTotalReportsUnsafe(int totalReportsUnsafe) {
    this.totalReportsUnsafe = totalReportsUnsafe;
  }

  public List<List<Integer>> getSafeList() {
    return safeList;
  }

  public void setSafeList(List<List<Integer>> safeList) {
    this.safeList = safeList;
  }

  public List<List<Integer>> getUnsafeList() {
    return unsafeList;
  }

  public void setUnsafeList(List<List<Integer>> unsafeList) {
    this.unsafeList = unsafeList;
  }
}
