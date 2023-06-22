package pl.ww.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@Configuration
public class ApplicationConfig {
    @Bean
    public Model model() {
        return new ExtendedModelMap();
    }
}