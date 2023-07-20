package ShopOnline;

import java.util.Map;

public class Order {
    private final int orderId;
    private static int lastOrderId = 0;
    private final double orderSum;
    private final String clientName;
    private final String clientSurname;
    private final String clientAddress;
    private OrderStatus orderStatus;
    private Map<Product, Integer> products;

    public Order(String clientName, String clientSurname, String clientAddress, Map<Product, Integer> products, double orderSum, OrderStatus orderStatus) {
        lastOrderId++;
        this.orderId = lastOrderId;
        this.orderSum = orderSum;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.products = products;
        this.clientAddress = clientAddress;
        this.orderStatus = orderStatus;
    }
    public void changeOrderStatus(OrderStatus newStatus) {
        this.orderStatus = newStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
