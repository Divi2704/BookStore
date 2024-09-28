package com.bookstore.Services;

import com.bookstore.Models.Book;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {

    private List<Book> cart;

    // Constructor
    public ShoppingCartService() {
        this.cart = new ArrayList<>();
    }

    // Add a book to the cart
    public void addBook(Book book) {
        cart.add(book);
        System.out.println("Book added to the cart: " + book.getTitle());
    }

    // Remove a book from the cart by book ID
    public void removeBook(int bookId) {
        boolean removed = cart.removeIf(book -> book.getId() == bookId);
        if (removed) {
            System.out.println("Book with ID " + bookId + " removed from the cart.");
        } else {
            System.out.println("Book with ID " + bookId + " not found in the cart.");
        }
    }

    // View all books in the cart
    public List<Book> viewCart() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Books in the cart:");
            cart.forEach(book -> System.out.println(book));
        }
        return cart;
    }

    // Clear all books from the cart
    public void clearCart() {
        cart.clear();
        System.out.println("Cart has been cleared.");
    }

    // Get total price of all books in the cart
    public double getTotalPrice() {
        return cart.stream()
                .mapToDouble(Book::getPrice)
                .sum();
    }
}
