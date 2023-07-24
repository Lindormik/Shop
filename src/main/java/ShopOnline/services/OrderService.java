package ShopOnline.services;


import ShopOnline.Order;
import ShopOnline.OrderStatus;
import ShopOnline.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderService {

    private static final List<Order> orders = generateOrders();

    public static List<Order> generateOrders() {
        List<Order> ordersList = new ArrayList<>();
        Map<Product, Integer> productMap1 = new HashMap<>();
        productMap1.put(ProductService.products.get(1), 4);
        Map<Product, Integer> productMap2 = new HashMap<>();
        productMap2.put(ProductService.products.get(3), 20);
        Map<Product, Integer> productMap3 = new HashMap<>();
        productMap3.put(ProductService.products.get(5), 23);

        Order order1 = new Order("Client1", "Surname1", "Address1", productMap1, 200.54, OrderStatus.PENDING);
        Order order2 = new Order("Client2", "Surname2", "Address2", productMap2, 100.99, OrderStatus.PAID);
        Order order3 = new Order("Client3", "Surname3", "Address3", productMap3, 300.09, OrderStatus.SENT);

        ordersList.add(order1);
        ordersList.add(order2);
        ordersList.add(order3);

        return ordersList;

    }

    public void addOrder(String clientName, String clientSurname, String clientAddress, double orderSum, int productId, int quantity ) {
        Map<Product, Integer> products = new HashMap<>();
        Product productById = ProductService.findProductById(productId);
        products.put(productById, quantity);
        Order newOrder = new Order(clientName, clientSurname, clientAddress, products, orderSum, OrderStatus.PENDING);
        orders.add(newOrder);
        System.out.println("Dodano nowe zamówienie o numerze: " + newOrder.getOrderId());
    }




    public void showAllOrders() {
        System.out.println("Lista wszystkich zamówień:");
        System.out.println();
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

    public void changeOrderStatus(int orderId, OrderStatus newStatus) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.changeOrderStatus(newStatus);
                System.out.println("Zmieniono status zamówienia o numerze: " + order.getOrderId());
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