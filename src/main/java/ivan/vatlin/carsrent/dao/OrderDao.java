package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    Order getOrderById(long id);

    boolean addOrder(Order car);

    long removeOrder(long id);

    long updateOrder(Order car);
}
