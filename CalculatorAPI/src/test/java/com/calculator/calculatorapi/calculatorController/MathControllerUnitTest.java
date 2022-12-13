package com.calculator.calculatorapi.calculatorController;

import com.calculator.calculatorapi.CalculatorService.Implementation.MathOperatorImpl;
import com.calculator.calculatorapi.Dto.DoMathRequest;
import com.calculator.calculatorapi.Dto.DoMathResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
class MathControllerUnitTest {
    @Mock
    private MathOperatorImpl mathOperator;

    @InjectMocks
    private MathController mathController;
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @BeforeEach
    public void setup() {
        mockMvc =
                MockMvcBuilders.standaloneSetup(mathController).build();
    }


    @Test
    void doMath_succes() throws Exception {
        DoMathRequest request = new DoMathRequest(1, 2, "+");

        ResultActions result = mockMvc.perform(post("/api/math")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));

        verify(mathOperator, times(1)).doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        result.andReturn().getResponse().getContentAsString().equals("3.0");
    }

    @Test
    void doMath_divideByZero() throws Exception {
        DoMathRequest request = new DoMathRequest(1, 0, "/");

        ResultActions result = mockMvc.perform(post("/api/math")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));

        verify(mathOperator, times(1)).doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        result.andReturn().getResponse().getContentAsString().equals("Cannot divide by 0");
    }
}