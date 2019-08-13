package ivan.vatlin.carsrent.validation;

import ivan.vatlin.carsrent.dto.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class OrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Order order = (Order) o;

        if (order.getCarId() < 0) {
            errors.rejectValue("carId", null, "Выберите автомобиль");
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startLocalDate = null;
        LocalDate endLocalDate;

        try {
            startLocalDate = LocalDate.parse(order.getStartDate(), dateTimeFormatter);

            if (startLocalDate.isBefore(LocalDate.now())) {
                errors.rejectValue("startDate", null, "Дата начала аренды не может быть раньше мегодняшнего дня");
            }
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            errors.rejectValue("startDate", null, "Неправильный формат даты");
        }

        try {
            endLocalDate = LocalDate.parse(order.getEndDate(), dateTimeFormatter);

            if (startLocalDate != null && endLocalDate.isBefore(startLocalDate)) {
                errors.rejectValue("endDate", null, "Дата окончания аренды не может быть меньше даты начала аренды");
            }
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            errors.rejectValue("endDate", null, "Неправильный формат даты");
        }
    }
}
