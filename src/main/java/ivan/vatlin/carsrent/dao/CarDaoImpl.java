package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Car;
import ivan.vatlin.carsrent.generators.EntityGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    @Autowired
    private EntityGenerator<List<Car>> carsGenerator;

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    @Nullable
    public Car getCarById(long id) {
        return null;
    }

    @Override
    public long addCar(Car car) {
        return 0;
    }

    @Override
    public long removeCar(long id) {
        return 0;
    }

    @Override
    public long updateCar(Car car) {
        return 0;
    }

    @PostConstruct
    private void init() {
        cars = carsGenerator.generate();
    }

    @PreDestroy
    private void destroy() {
        cars = null;
    }
}
