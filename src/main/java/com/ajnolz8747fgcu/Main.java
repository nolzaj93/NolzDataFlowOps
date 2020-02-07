package com.ajnolz8747fgcu;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

/**
 * Main holds the main method, which is the starting point of the program.
 *
 * @author austinnolz This
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {

      // Reads and prints the contents of SEOExample.csv
      CsvParser csvP = new CsvParser("src/Data/SEOExample.csv");
      csvP.printCsv();
    }
}
