package ivan.vatlin.carsrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicationController {
    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {

        String message = "Hello Spring Boot + Ivan";
        model.addAttribute("message", message);

        return "index";
    }

}
