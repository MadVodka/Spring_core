package ivan.vatlin.carsrent.dto;

import ivan.vatlin.carsrent.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

public class Order {
    private static long counter = 1;
    private final long id = counter++;
    private long clientId;

    @NotNull
    private long carId;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String startDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String endDate;
    private OrderStatus orderStatus;

    public long getId() {
        return id;
    }

    public long getCarId() {
        return carId;
    }

    public Order setCarId(long carId) {
        this.carId = carId;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Order setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public Order setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", carId=" + carId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
