package com.bookstore.Models;

import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private List<Book> books;

    public Order(int orderId, User user, List<Book> books) {
        this.orderId = orderId;
        this.user = user;
        this.books = books;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", books=" + books +
                '}';
    }
}
