package edu.fgcu.dataengineering;

public class Book {

  private String isbn;

  private String publisherName;

  private String authorName;

  private int bookYear;

  private String bookTitle;

  private double bookPrice = 9.99;

  public Book(String isbn, String title, String author, String publisher){
    this.isbn = isbn;
    bookTitle = title;
    authorName = author;
    publisherName = publisher;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public int getBookYear() {
    return bookYear;
  }

  public void setBookYear(int bookYear) {
    this.bookYear = bookYear;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public double getBookPrice() {
    return bookPrice;
  }

  public void setBookPrice(int bookPrice) {
    this.bookPrice = bookPrice;
  }

  @Override
  public String toString(){
    return isbn + "," + publisherName +"," +authorName + "," + bookTitle;
  }
}
