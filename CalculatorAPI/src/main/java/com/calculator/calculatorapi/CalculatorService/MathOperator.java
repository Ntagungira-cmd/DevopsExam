package com.calculator.calculatorapi.CalculatorService;

import com.calculator.calculatorapi.Exceptions.InvalidOperationException;

public interface MathOperator {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
