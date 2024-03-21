package service.serviceImpl;

import model.Book;
import model.Library;
import service.LibraryService;
import tools.CustomException;

import java.util.Map;
import java.util.Objects;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public String addBook(Book book) {
        boolean overlap = false;
        for (Map.Entry<String, Book> oneBook : Library.books.entrySet()) {
            if (oneBook.getValue().getTitle().equalsIgnoreCase(book.getTitle())) {
                overlap = true;
                break;
            }
        }
        if (!overlap) {
            Library.setBook(String.valueOf(book.getISBN()), book);
            return "Book successfully added!";
        }
        return "\nThis book already exists in the library!";
    }

    @Override
    public String removeBook(String ISBN) {
        for (Map.Entry<String, Book> book : Library.books.entrySet()) {
            if (book.getValue().getISBN().equalsIgnoreCase(ISBN)) {
                Library.books.remove(ISBN);
                return "Book successfully deleted!";
            }
        }
        return "There is no such book in libraries!";
    }

    @Override
    public Book searchBook(String keyWord) {
        try {
            for (Map.Entry<String, Book> book : Library.books.entrySet()) {
                if (Objects.equals(book.getValue().getISBN(), keyWord)) {
                    return book.getValue();
                }
            }
            throw new CustomException("There is no such book in libraries!");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<String, Book> getAllBooks() {
        try {
            if (!Library.books.isEmpty()) {
                return Library.getBooks();
            } else {
                throw new CustomException("There are no books in the library yet...");
            }
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        return Library.books;
    }
}
