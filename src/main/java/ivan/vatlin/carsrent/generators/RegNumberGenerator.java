package ivan.vatlin.carsrent.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Lazy
public class RegNumberGenerator implements EntityGenerator<String> {
    @Autowired
    private Random random;

    @Override
    public String generate() {

        char firstChar = generateChar();
        String number = generateNumber();
        char secondChar = generateChar();
        char thirdChar = generateChar();

        return firstChar + number + secondChar + thirdChar;
    }

    private char generateChar() {
        int start = (int) 'а';
        int end = (int) 'я';
        return (char) (random.nextInt(end - start) + start);
    }

    private String generateNumber() {
        int number = random.nextInt(1000);
        return String.format("%03d", number);
    }
}
