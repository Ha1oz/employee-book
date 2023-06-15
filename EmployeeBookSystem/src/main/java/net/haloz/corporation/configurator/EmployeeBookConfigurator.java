package net.haloz.corporation.configurator;

import net.haloz.corporation.service.EmployeeBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeBookConfigurator {
    @Bean
    public EmployeeBookService employeeBookService() {
        return new EmployeeBookService();
    }

}
