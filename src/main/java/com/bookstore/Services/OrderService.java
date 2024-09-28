package com.bookstore.Services;

import com.bookstore.Models.Book;
import com.bookstore.Models.Order;
import com.bookstore.Models.User;

import java.util.List;

public class OrderService {

    public Order createOrder(User user, List<Book> books) {
        int orderId = generateOrderId();
        Order order = new Order(orderId, user, books);
        System.out.println("Order created: " + order);
        return order;
    }

    private int generateOrderId() {
        return (int) (Math.random() * 10000);
    }
}
