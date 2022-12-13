package com.calculator.calculatorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CalculatorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApiApplication.class, args);
    }

}
