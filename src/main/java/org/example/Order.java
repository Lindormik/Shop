package org.example;

import java.util.Map;

public class Order {
    /*-orderId | int | autoinrementacja,
-orderNumber| String | losowo generowany ciąg 8
  znaków
-orderSum | double | wartość większa od 0.
-clientName | String | walidacja != null, !isBlank,
  name.size > 0 && name.size < 50, only chars.
-clientSurname | String | walidacja != null, !isBlank,
  name.size > 0 && name.size < 50, only chars.
-clientAddress | String | walidacja != null, !isBlank,
  name.size > 0 && name.size < 50
-orderStatus | Enum | oplacone, anulowane, wysłane,
w przygotowaniu
-products | Map<Product, Integer> | wartość > 0*/

    private int orderId;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private OrderStatus orderStatus;
    private Map<Product, Integer> products;

    public Order(String clientName, String clientSurname, String clientAddress, Map<Product, Integer> products, double orderSum, OrderStatus orderStatus) {
        this.orderSum = orderSum;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.products = products;
        this.clientAddress = clientAddress;
        this.orderStatus = orderStatus;
        this.orderId++;
    }
}
