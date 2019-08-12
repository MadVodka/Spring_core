package ivan.vatlin.carsrent.validation;

import ivan.vatlin.carsrent.dto.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

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

        Pattern pattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
        if (order.getStartDate() == null || order.getStartDate().isEmpty() || !(pattern.matcher(order.getStartDate()).matches())) {
            errors.rejectValue("startDate", null, "Неправильный формат даты");
        }

        if (order.getEndDate() == null || order.getEndDate().isEmpty() || !(pattern.matcher(order.getEndDate()).matches())) {
            errors.rejectValue("endDate", null, "Неправильный формат даты");
        }

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate startLocalDate = LocalDate.parse(order.getStartDate(), dateTimeFormatter);
//        LocalDate endLocalDate = LocalDate.parse(order.getStartDate(), dateTimeFormatter);
//
//        if (endLocalDate.isBefore(startLocalDate)) {
//            errors.rejectValue("startDate", null, "Дата начала аренды не может быть больше даты окончания аренды");
//            errors.rejectValue("endDate", null, "Дата окончания аренды не может быть меньше даты начала аренды");
//        }
    }
}
