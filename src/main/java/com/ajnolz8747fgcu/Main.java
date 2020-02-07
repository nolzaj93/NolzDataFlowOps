package com.ajnolz8747fgcu;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

/**
 * Main holds the main method, which is the starting point of the program.
 *
 * @author austinnolz This project is a part of the curriculum for Introduction to Data Engineering
 * at FGCU.
 */
public class Main {

  public static void main(String[] args) throws IOException, CsvValidationException {

    // Reads and prints the contents of SEOExample.csv
    CsvParser csvP = new CsvParser("src/Data/SEOExample.csv");
    csvP.printCsv();
  }
}
