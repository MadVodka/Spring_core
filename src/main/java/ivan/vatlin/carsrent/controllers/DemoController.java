package ivan.vatlin.carsrent.controllers;

import ivan.vatlin.carsrent.dao.CarDao;
import ivan.vatlin.carsrent.dao.OrderDao;
import ivan.vatlin.carsrent.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
    @Autowired
    private CarDao carDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    @Qualifier(value = "orderValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @GetMapping(value = "/demo-client", produces = {"application/xml; charset=UTF-8"})
    public String demoClient(Model model) {
        model.addAttribute("cars", carDao.getAllCars());
        model.addAttribute("orders", orderDao.getAllOrders());
        return "demo-client";
    }

    @GetMapping(value = "/demo-client/add")
    public String addOrder(Model model, Order order) {
        model.addAttribute("cars", carDao.getAllCars());
        return "add_order";
    }

    @PostMapping(value = "/demo-client/add")
    public String saveOrder(@ModelAttribute @Validated Order order, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cars", carDao.getAllCars());
            return "add_order";
        }

        orderDao.addOrder(order);
        return "redirect:/demo-client";
    }

    @GetMapping(value = "/demo-admin", produces = {"application/xml; charset=UTF-8"})
    public String demoAdmin(Model model) {
        model.addAttribute("cars", carDao.getAllCars());
        model.addAttribute("orders", orderDao.getAllOrders());
        return "demo-admin";
    }
}
