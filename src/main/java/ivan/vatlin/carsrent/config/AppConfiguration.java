package ivan.vatlin.carsrent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class AppConfiguration {
    @Bean()
    @Scope(scopeName = "prototype")
    Random getRandom() {
        return new Random();
    }
}
