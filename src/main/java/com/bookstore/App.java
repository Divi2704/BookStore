package com.bookstore;  
import com.bookstore.Models.Book;
import com.bookstore.Services.BookService;
import java.util.Scanner;
import java.util.List;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.connect();
        //check connection
        if (connection != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to make connection!");
        }
        // Initialize services
        
        // Start the application (e.g., web server or CLI)
        System.out.println("Online Bookstore Application Started!");
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Bookstore");
            System.out.println("1. Add a Book");
            System.out.println("2. List all Books");
            System.out.println("3. Find a Book by ID");
            System.out.println("4. Remove a Book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Book Price: ");
                    double price = scanner.nextDouble();

                    Book newBook = new Book(id, title, author, price);
                    bookService.addBook(newBook);
                    break;

                case 2:
                    List<Book> books = bookService.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\nList of Books:");
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to find: ");
                    int bookIdToFind = scanner.nextInt();
                    Book foundBook = bookService.getBookById(bookIdToFind);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int bookIdToRemove = scanner.nextInt();
                    bookService.removeBookById(bookIdToRemove);
                    break;

                case 5:
                    System.out.println("Exiting the bookstore app.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}