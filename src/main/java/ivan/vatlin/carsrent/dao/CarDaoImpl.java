package ivan.vatlin.carsrent.dao;

import ivan.vatlin.carsrent.dto.Car;
import ivan.vatlin.carsrent.generators.EntityGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {
    private List<Car> cars;
    @Autowired
    private EntityGenerator<List<Car>> carsGenerator;

    @Override
    public List<Car> getAllCars() {
        return cars;
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
