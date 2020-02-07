package com.ajnolz8747fgcu;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
	// write your code here
      System.out.println("Hello.");

      CsvParser csvP = new CsvParser("src/Data/SEOExample.csv");
      csvP.printCsv();
    }
}
