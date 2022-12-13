package com.calculator.calculatorapi.CalculatorService.Implementation;

import com.calculator.calculatorapi.Exceptions.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class MathOperatorImplUnitTest {
    @Test
    void doMath_succes() throws InvalidOperationException {
        final double operator1=1;
        final double operator2=2;
        final String operation="+";
        final double expectedResult=3;
        final MathOperatorImpl mathOperator = new MathOperatorImpl();
        final double result = mathOperator.doMath(operator1, operator2, operation);
        assertEquals(expectedResult, result);
    }

    @Test
    void doMath_divideByZero() throws InvalidOperationException {
        final double operator1=1;
        final double operator2=0;
        final String operation="/";
        final MathOperatorImpl mathOperator = new MathOperatorImpl();
        final InvalidOperationException exception = assertThrows(InvalidOperationException.class, () -> mathOperator.doMath(operator1, operator2, operation));
        assertEquals("Cannot divide by 0", exception.getMessage());
    }
}