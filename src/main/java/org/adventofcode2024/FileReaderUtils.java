package org.adventofcode2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderUtils {

  private String filePath;

  /**
   * Constructor to initialize the file path.
   *
   * @param filePath the file path.
   */
  public FileReaderUtils(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Reads all lines from the file and returns them as a list.
   *
   * @return list of lines from the file.
   * @throws IOException if there is an error reading the file.
   */
  public List<String> readAllLines() throws IOException {
    return Files.readAllLines(Paths.get(filePath));
  }

  /**
   * Reads the file and returns its content as a string.
   *
   * @return content of the file as a string.
   * @throws IOException if there is an error reading the file.
   */
  public String readFileAsString() throws IOException {
    return Files.readString(Paths.get(filePath));
  }

  /**
   * Gets the file path.
   *
   * @return the path of th file.
   */
  public String getFilePath() {
    return filePath;
  }

  /**
   * Sets the file path.
   *
   * @param filePath the new file path.
   */
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
}
