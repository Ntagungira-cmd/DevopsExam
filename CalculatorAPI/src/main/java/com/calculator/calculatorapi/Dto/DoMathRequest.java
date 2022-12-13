package com.calculator.calculatorapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoMathRequest {
    private double operand1;
    private double operand2;
    private String operation;

}
