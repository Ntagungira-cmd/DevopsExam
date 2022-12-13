package com.calculator.calculatorapi.calculatorController;

import com.calculator.calculatorapi.CalculatorService.MathOperator;
import com.calculator.calculatorapi.Dto.DoMathRequest;
import com.calculator.calculatorapi.Dto.DoMathResponse;
import com.calculator.calculatorapi.Exceptions.InvalidOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MathController {
    @Autowired
    private MathOperator mathOperator;

    @PostMapping("/math")
    public DoMathResponse DoMath(@RequestBody DoMathRequest request) throws InvalidOperationException {
        double result = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return new DoMathResponse(result);
    }
}
