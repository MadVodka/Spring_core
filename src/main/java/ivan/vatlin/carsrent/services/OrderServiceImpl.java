package ivan.vatlin.carsrent.services;

import ivan.vatlin.carsrent.dao.OrderDao;
import ivan.vatlin.carsrent.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDao.addOrder(order);
    }
}
