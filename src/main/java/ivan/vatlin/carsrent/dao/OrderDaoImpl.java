package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private List<Order> orders;
    private long orderId = 0;

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public boolean addOrder(Order order) {
        order.setId(orderId++);
        return orders.add(order);
    }

    @PostConstruct
    private void init() {
        orders = new ArrayList<>();
    }
}
