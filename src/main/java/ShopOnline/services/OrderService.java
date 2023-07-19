package ShopOnline.services;

import ShopOnline.Order;
import ShopOnline.OrderStatus;
import ShopOnline.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orders;

    public OrderService() {
        orders = new ArrayList<>();
    }

    public void addOrder(String clientName, String clientSurname, String clientAddress, Map<Product, Integer> products, double orderSum, OrderStatus orderStatus) {
        Order order = new Order(clientName, clientSurname, clientAddress, products, orderSum, orderStatus);
        orders.add(order);
        System.out.println("Dodano nowe zamówienie. ID zamówienia: " + order.getOrderId());
    }

    public void deleteOrder(int orderId) {
        Order order = findOrderById(orderId);
        if (order != null) {
            orders.remove(order);
            System.out.println("Usunięto zamówienie o ID: " + orderId);
        } else {
            System.out.println("Zamówienie o podanym ID nie zostało znalezione.");
        }
    }

    public void showAllOrders() {
        System.out.println("Lista wszystkich zamówień:");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void showOneOrder(int orderId) {
        Order order = findOrderById(orderId);
        if (order != null) {
            System.out.println("Szczegóły zamówienia o ID: " + orderId);
            System.out.println(order.toString());
        } else {
            System.out.println("Zamówienie o podanym ID nie zostało znalezione.");
        }
    }

    private Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}