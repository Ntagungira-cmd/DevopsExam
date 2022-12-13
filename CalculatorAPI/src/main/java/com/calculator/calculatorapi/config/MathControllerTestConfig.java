package com.calculator.calculatorapi.config;

import com.calculator.calculatorapi.CalculatorService.MathOperator;
import com.calculator.calculatorapi.calculatorController.MathController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MathControllerTestConfig {
    @Autowired
    MathOperator operator;

    @Bean
    public MathController mathController() {
        return new MathController(operator);
    }
}
