package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private List<Order> orders;

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public Order getOrderById(long id) {
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        return orders.add(order);
    }

    @Override
    public long removeOrder(long id) {
        return 0;
    }

    @Override
    public long updateOrder(Order order) {
        return 0;
    }

    @PostConstruct
    private void init() {
        orders = new ArrayList<>();
    }
}
