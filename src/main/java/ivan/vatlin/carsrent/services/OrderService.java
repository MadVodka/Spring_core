package ivan.vatlin.carsrent.services;

import ivan.vatlin.carsrent.dto.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    boolean addOrder(Order order);
}
