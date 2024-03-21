package service;

import model.Book;

import java.util.Map;

public interface LibraryService {
    String addBook(Book book);
    String removeBook(String ISBN);
    Book searchBook(String keyWord);
    Map<String, Book> getAllBooks();
}
