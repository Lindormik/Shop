package ShopOnline.services;

import ShopOnline.Order;
import ShopOnline.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
    }

    @Test
    public void givenGenerateOrdersMethod_whenCalled_thenOrderListShouldNotBeEmpty() {
        // Given

        // When
        List<Order> orderList = orderService.generateOrders();

        // Then
        Assertions.assertNotNull(orderList);
        Assertions.assertFalse(orderList.isEmpty());
    }

    @Test
    public void givenAddOrderMethod_whenNewOrderAdded_thenOrderListSizeShouldIncrease() {
        // Given
        int initialSize = orderService.getAllOrders().size();
        String clientName = "John";
        String clientSurname = "Doe";
        String clientAddress = "123 Main Street";
        double orderSum = 150.0;
        int productId = 1;
        int quantity = 2;

        // When
        orderService.addOrder(clientName, clientSurname, clientAddress, orderSum, productId, quantity);

        // Then
        int finalSize = orderService.getAllOrders().size();
        Assertions.assertEquals(initialSize + 1, finalSize);
    }

    @Test
    public void givenShowSelectedOrderMethod_whenExistingOrderShown_thenOutputContainsCorrectOrder() {
        // Given
        Order testOrder = orderService.getAllOrders().get(0);

        // When


        // Then

    }

    @Test
    public void givenShowSelectedOrderMethod_whenNonExistingOrderShown_thenOutputContainsErrorMessage() {
        // Given
        int nonExistingOrderId = 999;

        // When

        // Then

    }

    @Test
    public void givenChangeOrderStatusMethod_whenExistingOrderStatusChanged_thenOrderStatusShouldBeUpdated() {
        // Given
        Order testOrder = orderService.getAllOrders().get(0);
        OrderStatus newStatus = OrderStatus.SENT;

        // When
        orderService.changeOrderStatus(testOrder.getOrderId(), newStatus);

        // Then
        Order updatedOrder = orderService.getAllOrders().get(0);
        assertThat(updatedOrder.getOrderStatus()).isEqualTo(newStatus);
    }
}