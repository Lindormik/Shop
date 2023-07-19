package ShopOnline.services;

import ShopOnline.Category;
import ShopOnline.Order;
import ShopOnline.OrderStatus;
import ShopOnline.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static List<Order> orders = generateOrders();

    public static List<Order> generateOrders() {
        List<Order> ordersList = new ArrayList<>();
        Map<Product, Integer> productMap = new HashMap<>();
        productMap.put(ProductService.products.get(1), 4);
        Order order1 = new Order("Client1", "Surname1", "Address1", productMap, 200.54, OrderStatus.PENDING);


        ordersList.add(order1);


        return ordersList;

    }

    public void addOrder(String clientName, String clientSurname, String clientAddress, Map<Product, Integer> products, double orderSum, OrderStatus orderStatus) {
        Order newOrder = new Order(clientName, clientSurname, clientAddress, products, orderSum, OrderStatus.PENDING);
        orders.add(newOrder);
        System.out.println("Dodano nowe zamówienie o numerze: " + newOrder.getOrderId());
    }

    public void showAllOrders() {
        System.out.println("Lista wszystkich zamówień:");
        for (Order order : orders) {
            displayOrderDetails(order);
        }
    }

    public void showSelectedOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                displayOrderDetails(order);
                return;
            }
        }
        System.out.println("Zamówienie o podanym numerze nie istnieje.");
    }

    private void displayOrderDetails(Order order) {
        System.out.println("Numer zamówienia: " + order.getOrderId());
        System.out.println("Suma zamówienia: " + order.getOrderSum());
        System.out.println("Imię klienta: " + order.getClientName());
        System.out.println("Nazwisko klienta: " + order.getClientSurname());
        System.out.println("Adres klienta: " + order.getClientAddress());
        System.out.println("Status zamówienia: " + order.getOrderStatus());
        System.out.println("Produkty w zamówieniu:");
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(" - Nazwa produktu: " + product.getProductName() + ", Ilość: " + quantity);
        }
        System.out.println();
    }
}