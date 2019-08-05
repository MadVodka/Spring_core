package ivan.vatlin.carsrent.controllers;

import ivan.vatlin.carsrent.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @Autowired
    private CarDao carDao;

    @GetMapping(value = "/demo-client", produces = {"application/xml; charset=UTF-8"})
    public String demoClient(Model model) {
        model.addAttribute("cars", carDao.getAllCars());
        return "demo-client";
    }

}
