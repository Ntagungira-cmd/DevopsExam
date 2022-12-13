package com.calculator.calculatorapi.Dto;

public class DoMathResponse {
    private double result;

    public DoMathResponse(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
