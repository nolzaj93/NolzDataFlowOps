package com.ajnolz8747fgcu;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Main holds the main method, which is the starting point of the program.
 *
 * @author austinnolz This project is a part of the curriculum for Introduction to Data Engineering
 * at FGCU.
 */
public class Main {

  public static void main(String[] args) throws IOException, CsvValidationException, ParseException {

    // Reads and prints the contents of SEOExample.csv
    CsvParser csvP = new CsvParser("src/Data/SEOExample.csv");
    csvP.printCsv();

    // Credit: https://www.geeksforgeeks.org/parse-json-java/
    //Sample code:
    // parsing file "JSONExample.json"
    Object obj = new JSONParser().parse(new FileReader("src/Data/authors.json"));

    // typecasting obj to JSONObject
    JSONArray jo = (JSONArray) obj;

    for (Object object : jo){
      System.out.println(object.toString());
    }
    /*


        // getting firstName and lastName
        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");

        System.out.println(firstName);
        System.out.println(lastName);

        // getting age
        long age = (long) jo.get("age");
        System.out.println(age);

        // getting address
        Map address = ((Map)jo.get("address"));

        // iterating address Map
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        // getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("phoneNumbers");

        // iterating phoneNumbers
        Iterator itr2 = ja.iterator();

        while (itr2.hasNext())
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
}
     */


  }
}
