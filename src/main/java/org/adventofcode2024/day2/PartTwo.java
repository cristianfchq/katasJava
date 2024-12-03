package org.adventofcode2024.day2;

import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.ListUtils;

public class PartTwo {

  public PartTwo() {
  }

  int totalReportsSafe = 0;
  int totalReportsUnsafe = 0;
  List<List<Integer>> totalSafeList = new ArrayList<List<Integer>>();
  List<List<Integer>> totalUnsafeList = new ArrayList<List<Integer>>();
  List<List<Integer>> unsafeList = new ArrayList<List<Integer>>();

  public void calculateSafeAndUnsafeList() {

//    unsafeList.forEach(System.out::println);

    for (int i = 0; i < unsafeList.size(); i++) {
      List<Integer> report = unsafeList.get(i);
      List<Integer> reportCopy = new ArrayList<Integer>();
      int aux = 0;
      for (int j = 0; j < report.size(); j++) {
        reportCopy = ListUtils.removeAtIndex(report, j);

        if (ListUtils.isOrdered(reportCopy)) {
          if (isSafe(reportCopy)) {
            System.out.println("copy " + reportCopy);
            aux = 1;
            break;
          }
        }

//        reportCopy.forEach(System.out::print);
//
//        System.out.println("&&&&&&&&&&&\n");
      }

      totalReportsSafe = totalReportsSafe + aux;

    }

    System.out.println("total report safe fixed : " + totalReportsSafe);

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

  public List<List<Integer>> getTotalSafeList() {
    return totalSafeList;
  }

  public void setTotalSafeList(List<List<Integer>> totalSafeList) {
    this.totalSafeList = totalSafeList;
  }

  public List<List<Integer>> getTotalUnsafeList() {
    return totalUnsafeList;
  }

  public void setTotalUnsafeList(List<List<Integer>> totalUnsafeList) {
    this.totalUnsafeList = totalUnsafeList;
  }

  public List<List<Integer>> getUnsafeList() {
    return unsafeList;
  }

  public void setUnsafeList(List<List<Integer>> unsafeList) {
    this.unsafeList = unsafeList;
  }
}
