import model.Book;
import service.serviceImpl.LibraryServiceImpl;
import tools.GenerateISBN;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);

        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        System.out.println("Welcome to mini mini mini library!");
        while (true) {
            System.out.println("""
                    \n-*-*-*-*-*-ACTIONS-*-*-*-*-*-
                    1) Add book
                    2) Remove book
                    3) Search book
                    4) Get all books
                    """);
            System.out.print("Your command: ");
            int command = scannerNum.nextInt();

            switch (command) {
                case 1 -> {
                    System.out.print("Write book title: ");
                    String bookTitle = scannerLn.nextLine();

                    System.out.print("Write book author: ");
                    String bookAuthor = scannerLn.nextLine();

                    Book book = new Book(GenerateISBN.generateBookISBN(), bookTitle, bookAuthor);
                    System.out.println(libraryService.addBook(book));
                }
                case 2 -> {
                    System.out.print("Write the ISBN code of the book you want to delete: ");
                    String ISBNCode = scannerLn.nextLine();

                    System.out.println(libraryService.removeBook(ISBNCode));
                }
                case 3 -> {
                    System.out.print("Write the ISBN code of the book you want to find: ");
                    String keyWord = scannerLn.nextLine();

                    System.out.println(libraryService.searchBook(keyWord));
                }
                case 4 -> {
                    System.out.println(libraryService.getAllBooks().values());
                }
                default -> {
                    System.out.println("Wrong command!");
                }
            }
        }
    }
}