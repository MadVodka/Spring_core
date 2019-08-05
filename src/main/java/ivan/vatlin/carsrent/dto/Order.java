package ivan.vatlin.carsrent.dto;

import ivan.vatlin.carsrent.OrderStatus;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private Car car;
    private Client client;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private OrderStatus orderStatus;
}
