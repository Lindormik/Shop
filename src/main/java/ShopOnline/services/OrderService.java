package ShopOnline.services;

import ShopOnline.Order;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private Map<Integer, Order> orders;
    private final String dataFilePath;

    public OrderService(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        orders = new HashMap<>();
        loadOrdersFromFile(); // Wczytaj zamówienia z pliku przy tworzeniu instancji klasy.
    }

    public void addOrder(Order order) {
        int orderId = order.getOrderId();
        if (!orders.containsKey(orderId)) {
            orders.put(orderId, order);
            System.out.println("Dodano nowe zamówienie: #" + orderId);
            saveOrdersToFile(); // Po dodaniu nowego zamówienia, zapisz zmiany do pliku.
        } else {
            System.out.println("Zamówienie o podanym numerze już istnieje.");
        }
    }

    public void removeOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            orders.remove(orderId);
            System.out.println("Usunięto zamówienie: #" + orderId);
            saveOrdersToFile(); // Po usunięciu zamówienia, zapisz zmiany do pliku.
        } else {
            System.out.println("Zamówienie o podanym numerze nie istnieje.");
        }
    }

    public Order showOneOrder(int orderId) {
        return orders.get(orderId);
    }

    public void showAllOrders() {
        if (!orders.isEmpty()) {
            System.out.println("Lista zamówień:");
            for (Order order : orders.values()) {
                System.out.println("Zamówienie #" + order.getOrderId() + ": " + order.getClientName() + " " + order.getClientSurname());
            }
        } else {
            System.out.println("Brak zamówień.");
        }
    }

    private void loadOrdersFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFilePath))) {
            orders = (Map<Integer, Order>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Wystąpił błąd podczas wczytywania danych z pliku.");
        }
    }

    private void saveOrdersToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            outputStream.writeObject(orders);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania danych do pliku.");
        }
    }
}