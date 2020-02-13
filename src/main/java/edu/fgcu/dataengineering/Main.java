package edu.fgcu.dataengineering;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.SQLiteException;


/**
 * Main holds the main method, which is the starting point of the program.
 *
 * @author austinnolz This project is a part of the curriculum for Introduction to Data Engineering
 * at FGCU.
 */
public class Main {


  private static final String JDBC_DRIVER = "org.sqlite.JDBC";
  private static final String DB_URL = "jdbc:sqlite:src/Data/BookStore.db";

  private static Connection conn = null;
  private static Statement stmt = null;

  public static void main(String[] args)
      throws IOException, CsvValidationException {

    CsvParser csvP = new CsvParser("src/Data/bookstore_report2.csv");

    initializeDB();

    ArrayList<Book> books = new ArrayList<>();

    csvP.getFileRows().remove(0); //remove header

    List<String[]> csvRows = csvP.getFileRows();
    for (String[] bookInfo : csvRows) {



      try {
        String insertStatement = "INSERT INTO book(isbn, book_title, author_name, publisher_name) VALUES(?,?,?,?)";
        String isbnNumber = bookInfo[0].replaceAll("\\D","");
        Book nextBook = new Book(isbnNumber, bookInfo[1], bookInfo[2], bookInfo[3]);
        books.add(nextBook);
        System.out.println(nextBook.toString());

        PreparedStatement insertBook = conn.prepareStatement(insertStatement);
        insertBook.setString(1, isbnNumber);
        insertBook.setString(2, "\""+bookInfo[1]+"\"");
        insertBook.setString(3, "\""+bookInfo[2]+"\"");
        insertBook.setString(4, "\""+bookInfo[3]+"\"");
        insertBook.executeUpdate();

      } catch (SQLiteException ex) {
        ex.printStackTrace();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    // Load the json
        /*
        1. Create instance of GSON
        2. Create a JsonReader object using FileReader
        3. Array of class instances of AuthorParser, assign data from our JsonReader
        4. foreach loop to check data
         */
    Gson gson = new Gson();
    JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));
    AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);

    for (AuthorParser aParser : authors) {
      try {

        String insertStatement = "INSERT INTO author(author_name, author_email, author_url) VALUES(?,?,?)";

        PreparedStatement insertAuthor = conn.prepareStatement(insertStatement);
        insertAuthor.setString(1, aParser.getName());
        insertAuthor.setString(2,aParser.getEmail());
        insertAuthor.setString(3,aParser.getUrl());

        insertAuthor.executeUpdate();

      } catch (SQLiteException ex) {
        ex.printStackTrace();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }

  private static void initializeDB() {
    //Exact same for every database
    //Result set looks like the database table
    try {

      // STEP 1: Register JDBC driver

      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection

      conn = DriverManager.getConnection(DB_URL);


    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();
    }
  }
}
