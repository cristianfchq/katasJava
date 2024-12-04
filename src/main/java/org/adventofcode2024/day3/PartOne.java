package org.adventofcode2024.day3;

import static org.adventofcode2024.RegexUtils.getStringBetweenParentheses;

import java.util.ArrayList;
import java.util.List;
import org.adventofcode2024.RegexUtils;

public class PartOne {

  List<String> instructions = new ArrayList<String>();
  Integer resultAddingProductInstruction = 0;

  public PartOne() {
  }

  public void findAllInstructions(final String allLinesAsString) {
    this.instructions = RegexUtils.findPatterns(allLinesAsString, "mul\\(\\d+,\\d+\\)");
  }

  public void calculateAddingProductInstruction() {
    for (String instruction : instructions) {
      String[] operands = getStringBetweenParentheses(instruction).split(",");
      int operand1 = Integer.parseInt(operands[0]);
      int operand2 = Integer.parseInt(operands[1]);
      resultAddingProductInstruction += operand1 * operand2;
//      System.out.println(instruction);
//      System.out.println(getStringBetweenParentheses(instruction));
    }
  }

  public List<String> getInstructions() {
    return instructions;
  }

  public void setInstructions(List<String> instructions) {
    this.instructions = instructions;
  }

  public Integer getResultAddingProductInstruction() {
    return resultAddingProductInstruction;
  }

  public void setResultAddingProductInstruction(Integer resultAddingProductInstruction) {
    this.resultAddingProductInstruction = resultAddingProductInstruction;
  }
}
