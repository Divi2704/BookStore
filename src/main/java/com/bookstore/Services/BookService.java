package com.bookstore.Services;

import com.bookstore.DatabaseConnection;
import com.bookstore.Models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


public class BookService {

    // Method to add a book
    public void addBook(Book book) {
    String query = "INSERT INTO books (id, name, author, price) VALUES (?, ?, ?, ?)";
    try (Connection connection = DatabaseConnection.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setInt(1, book.getId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setDouble(4, book.getPrice());
        
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Book added successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // Method to get all books
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books"; // Query to get all books
    
        try (Connection connection = DatabaseConnection.connect(); // Now using static connect()
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
    
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
    
                Book book = new Book(id, name, author, price);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }    

    // Method to find a book by ID
    public Book getBookById(int id) {
        String query = "SELECT * FROM books WHERE id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int bookId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                return new Book(bookId, name, author, price);
            } else {
                System.out.println("No book found with that ID.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }    

    // Method to remove a book by ID
    public void removeBookById(int id) {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book removed successfully!");
            } else {
                System.out.println("No book found with that ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
