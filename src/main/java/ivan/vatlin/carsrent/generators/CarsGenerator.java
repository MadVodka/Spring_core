package ivan.vatlin.carsrent.generators;

import ivan.vatlin.carsrent.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ivan.vatlin.carsrent.holder.CarDataHolder.models;

@Component
@Lazy
public class CarsGenerator implements EntityGenerator<List<Car>> {
    @Autowired
    private Random random;

    @Autowired
    @Qualifier(value = "regNumberGenerator")
    private EntityGenerator<String> regNumberGenerator;

    @Override
    public List<Car> generate() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < models.length; i++) {
            String regNumber = regNumberGenerator.generate();
            int price = random.nextInt(100) + 50;
            Car car = new Car(i, models[i], regNumber, price);
            cars.add(car);
        }
        return cars;
    }
}
