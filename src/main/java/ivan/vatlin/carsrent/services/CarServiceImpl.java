package ivan.vatlin.carsrent.services;

import ivan.vatlin.carsrent.dao.CarDao;
import ivan.vatlin.carsrent.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
}
