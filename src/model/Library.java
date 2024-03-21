package model;

import java.util.Map;
import java.util.TreeMap;

public class Library {
    public static Map<String, Book> books = new TreeMap<>();

    public static Map<String, Book> getBooks() {
        return books;
    }

    public static void setBook(String key, Book book) {
        books.put(key, book);
    }
}
