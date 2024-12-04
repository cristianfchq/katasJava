package org.adventofcode2024.day3;

import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.RegexUtils;
import org.adventofcode2024.StringUtils;

public class PartTwo {

  List<String> listToDo = new ArrayList<String>();

  Integer resultAddingProductInstructionForToDo = 0;

  public void findAllToDo(final String allLinesAsString) {
//    this.listToDo = RegexUtils.findPatterns(allLinesAsString, "do\\(\\)+(.*?)+don't\\(\\)");
    this.listToDo = StringUtils.getAllStringsBetweenDoAndDont(allLinesAsString);
  }

  public void calculateAddingProductInstructionForToDo() {
    for (int i = 0; i < listToDo.size(); i++) {
      PartOne partOne = new PartOne();
      partOne.findAllInstructions(listToDo.get(i));
      partOne.calculateAddingProductInstruction();
      resultAddingProductInstructionForToDo += partOne.getResultAddingProductInstruction();
    }
  }

  public List<String> getListToDo() {
    return listToDo;
  }

  public void setListToDo(List<String> listToDo) {
    this.listToDo = listToDo;
  }

  public Integer getResultAddingProductInstructionForToDo() {
    return resultAddingProductInstructionForToDo;
  }

  public void setResultAddingProductInstructionForToDo(
      Integer resultAddingProductInstructionForToDo) {
    this.resultAddingProductInstructionForToDo = resultAddingProductInstructionForToDo;
  }
}
