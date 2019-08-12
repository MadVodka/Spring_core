package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();

    Car getCarById(long id);

    long addCar(Car car);

    long removeCar(long id);

    long updateCar(Car car);
}
