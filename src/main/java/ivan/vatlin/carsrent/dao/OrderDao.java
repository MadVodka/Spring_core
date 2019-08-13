package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    boolean addOrder(Order car);
}
